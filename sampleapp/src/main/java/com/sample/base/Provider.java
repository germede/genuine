package com.sample.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface Provider<T> {

    default List<T> provideAll() {
        List<T> list = new ArrayList<>();
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                list.add((T) field.get(this));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

}
