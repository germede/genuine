package org.fwf.dba;

import org.fwf.ann.Column;
import org.fwf.ann.Table;
import org.fwf.exc.MethodIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.exc.ModelHasNoPrimaryKeyException;
import org.fwf.mvc.Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class QueryHelper {


    public static Query.ColumnsValuesPairs retrieveColumnsValuesPair(Model model)
            throws MethodIsAbsentOrInaccessibleException, IllegalAccessException, InvocationTargetException {

        Query.ColumnsValuesPairs result = new Query.ColumnsValuesPairs();

        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Column.class)) {
                Method getter = retrieveGetterMethod(model.getClass(), field.getName());
                result.columns.add(field.getName());
                result.values.add(String.valueOf(getter.invoke(model)));
            }
        }

        return result;
    }

    public static String retrieveTable(Class modelClass) throws ModelHasNoMappedTableException {
        if (modelClass.isAnnotationPresent(Table.class)) {
            return ((Table) modelClass.getAnnotation(Table.class)).value();
        } else {
            throw new ModelHasNoMappedTableException(modelClass.getCanonicalName());
        }
    }

    public static String retrievePrimaryKeyColumnName(Class modelClass) throws ModelHasNoPrimaryKeyException {
        Field[] declaredFields = modelClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Column.class) && declaredField.getAnnotation(Column.class).pk()) {
                return declaredField.getName();
            }
        }
        throw new ModelHasNoPrimaryKeyException(modelClass.getCanonicalName());
    }

    public static Object retrievePrimaryKey(Model model) throws InvocationTargetException, IllegalAccessException, MethodIsAbsentOrInaccessibleException, ModelHasNoPrimaryKeyException {
        return retrieveGetterMethod(model.getClass(), retrievePrimaryKeyColumnName(model.getClass())).invoke(model);
    }

    public static Method retrieveGetterMethod(Class modelClass, String fieldName) throws MethodIsAbsentOrInaccessibleException {
        String getterName = "get" + Character.toString(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
        Method[] declaredMethods = modelClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (getterName.equals(declaredMethod.getName()) && Modifier.isPublic(declaredMethod.getModifiers())) {
                return declaredMethod;
            }
        }
        throw new MethodIsAbsentOrInaccessibleException(modelClass.getCanonicalName(), getterName);
    }

    public static Method retrieveSetterMethod(Class modelClass, String fieldName) throws MethodIsAbsentOrInaccessibleException {
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