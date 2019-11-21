package org.fluentness.repository.field;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public enum FieldExtractor {
    INSTANCE;

    public List<java.lang.reflect.Field> getModelFields(Object o) {
        return o.getClass().isAnnotationPresent(Entity.class) ?
            Arrays.stream(o.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(org.fluentness.repository.field.Field.class))
                .collect(Collectors.toList()) :
            new LinkedList<>();
    }
}
