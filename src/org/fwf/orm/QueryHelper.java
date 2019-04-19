package org.fwf.orm;

import org.fwf.ann.Column;
import org.fwf.ann.Table;
import org.fwf.exc.GetterIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.mvc.Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class QueryHelper {


    public static ColumnValueListsPair generateColumnValueListPair(Model model)
            throws GetterIsAbsentOrInaccessibleException, IllegalAccessException, InvocationTargetException {

        ColumnValueListsPair result = new ColumnValueListsPair();

        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Column.class)) {
                Method getter = retrieveGetterMethod(model, field);
                result.columns.add(field.getName());
                result.values.add(String.valueOf(getter.invoke(model)));
            }
        }

        return result;
    }

    public static String retrieveTable(Model model) throws ModelHasNoMappedTableException {
        if (model.getClass().isAnnotationPresent(Table.class)) {
            return model.getClass().getAnnotation(Table.class).value();
        } else {
            throw new ModelHasNoMappedTableException();
        }
    }

    private static Method retrieveGetterMethod(Model model, Field field) throws GetterIsAbsentOrInaccessibleException {
        String getterName = "get" + Character.toString(field.getName().charAt(0)).toUpperCase() + field.getName().substring(1);
        Method[] declaredMethods = model.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (getterName.equals(declaredMethod.getName()) && Modifier.isPublic(declaredMethod.getModifiers())) {
                return declaredMethod;
            }
        }
        throw new GetterIsAbsentOrInaccessibleException(field.getName());
    }

    public static class ColumnValueListsPair {

        public List<String> columns;
        public List<Object> values;

        ColumnValueListsPair() {
            this.columns = new ArrayList<>();
            this.values = new ArrayList<>();
        }
    }
}