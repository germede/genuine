package org.fluentness.model;

import org.fluentness.common.NamedValue;
import org.fluentness.logging.Logger;
import org.fluentness.repository.RepositoryImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Model {

    default String getTable() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    default List<String> getColumns() {
        return Arrays.stream(this.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    }

    default int create() {
        return RepositoryImpl.create(this, this.getClass());
    }

    default int update() {
        return RepositoryImpl.update(this, this.getClass());
    }

    default int delete() {
        return RepositoryImpl.delete(this, this.getClass());
    }

    default void set(NamedValue<Object>... properties) {
        try {
            for (NamedValue<Object> property : properties) {
                this.getClass().getDeclaredField(property.name()).set(this, property.value());
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Logger.error(this.getClass(),e);
        }
    }
}
