package org.fluencyframework.dao;

import org.fluencyframework.ann.Column;
import org.fluencyframework.ann.Table;
import org.fluencyframework.dba.Query;
import org.fluencyframework.exc.MethodIsAbsentOrInaccessibleException;
import org.fluencyframework.exc.ModelHasNoMappedTableException;
import org.fluencyframework.exc.ModelHasNoPrimaryKeyException;
import org.fluencyframework.mvc.Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RepositoryHelper {


    public static Query.ColumnsValuesPairs retrieveColumnsValuesPair(Model model)
            throws MethodIsAbsentOrInaccessibleException, IllegalAccessException, InvocationTargetException {

        Query.ColumnsValuesPairs result = new Query.ColumnsValuesPairs();

        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Column.class)) {
                Method getter = retrieveGetterMethod(model.getClass(), field.getName());
                result.add(field.getName(), getter.invoke(model));
            }
        }

        return result;
    }

    public static Query.ColumnsValuesPairs retrieveColumnsValuesPairBasedOnDifferences(Model model, Model original)
            throws MethodIsAbsentOrInaccessibleException, IllegalAccessException, InvocationTargetException {

        Query.ColumnsValuesPairs result = new Query.ColumnsValuesPairs();

        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Column.class)) {
                Method getter = retrieveGetterMethod(model.getClass(), field.getName());
                Object value = getter.invoke(model);
                Object originalValue = getter.invoke(original);
                if (!value.equals(originalValue)) {
                    result.add(field.getName(), value);
                }
            }
        }

        return result;
    }

    static String retrieveTable(Class modelClass) throws ModelHasNoMappedTableException {
        if (modelClass.isAnnotationPresent(Table.class)) {
            return ((Table) modelClass.getAnnotation(Table.class)).value();
        } else {
            throw new ModelHasNoMappedTableException(modelClass.getCanonicalName());
        }
    }

    static String retrievePrimaryKeyColumnName(Class modelClass) throws ModelHasNoPrimaryKeyException {
        Field[] declaredFields = modelClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Column.class) && declaredField.getAnnotation(Column.class).pk()) {
                return declaredField.getName();
            }
        }
        throw new ModelHasNoPrimaryKeyException(modelClass.getCanonicalName());
    }

    static Object retrievePrimaryKey(Model model) throws InvocationTargetException, IllegalAccessException, MethodIsAbsentOrInaccessibleException, ModelHasNoPrimaryKeyException {
        return retrieveGetterMethod(model.getClass(), retrievePrimaryKeyColumnName(model.getClass())).invoke(model);
    }

    private static Method retrieveGetterMethod(Class modelClass, String fieldName) throws MethodIsAbsentOrInaccessibleException {
        String getterName = "get" + Character.toString(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
        Method[] declaredMethods = modelClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (getterName.equals(declaredMethod.getName()) && Modifier.isPublic(declaredMethod.getModifiers())) {
                return declaredMethod;
            }
        }
        throw new MethodIsAbsentOrInaccessibleException(modelClass.getCanonicalName(), getterName);
    }

    static Method retrieveSetterMethod(Class modelClass, String fieldName) throws MethodIsAbsentOrInaccessibleException {
        String setterName = "set" + Character.toString(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
        Method[] declaredMethods = modelClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (setterName.equals(declaredMethod.getName()) && Modifier.isPublic(declaredMethod.getModifiers())) {
                return declaredMethod;
            }
        }
        throw new MethodIsAbsentOrInaccessibleException(modelClass.getCanonicalName(), setterName);
    }

}