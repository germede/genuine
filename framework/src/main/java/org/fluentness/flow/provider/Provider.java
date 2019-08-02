package org.fluentness.flow.provider;

import org.fluentness.flow.component.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Provider<C extends Component> {

    default Class<C> getType() {
        for (Type genericInterface : getClass().getGenericInterfaces()) {
            ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
            if (parameterizedType.getRawType().getTypeName().equals(Component.class.getSimpleName())) {
                return (Class<C>) parameterizedType.getActualTypeArguments()[0];
            }
        }
        return null;
    }

}
