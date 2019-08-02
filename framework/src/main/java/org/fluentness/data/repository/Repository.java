package org.fluentness.data.repository;

import org.fluentness.data.model.Model;
import org.fluentness.flow.component.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Repository<M extends Model> {
    default Class<M> getType() {
        for (Type genericInterface : getClass().getGenericInterfaces()) {
            ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
            if (parameterizedType.getRawType().getTypeName().equals(Component.class.getSimpleName())) {
                return (Class<M>) parameterizedType.getActualTypeArguments()[0];
            }
        }
        return null;
    }
}
