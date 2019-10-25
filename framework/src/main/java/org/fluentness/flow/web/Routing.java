package org.fluentness.flow.web;

import org.fluentness.base.exception.ProviderException;
import org.fluentness.flow.console.Task;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Routing {

    private final List<C> components = new ArrayList<>();

    public final List<C> provideComponents() {
        if (components.isEmpty()) {

            try {
                Field[] fields = this.getClass().getDeclaredFields();
                // todo: improve adding default tasks
                if (this instanceof AbstractTaskProvider) {
                    fields = Stream.concat(Arrays.stream(fields), Arrays.stream(AbstractTaskProvider.class.getDeclaredFields())).toArray(Field[]::new);
                }
                for (Field field : fields) {
                    if (field.getModifiers() != 0) {
                        throw new ProviderException(
                                "Component %s->%s should have no modifiers, found %s",
                                this.getClass().getSimpleName(),
                                field.getName(),
                                Modifier.toString(field.getModifiers())
                        );
                    }
                    field.setAccessible(true);
                    if (!getComponentClass().isAssignableFrom(field.get(this).getClass())) {
                        throw new ProviderException(
                                "Provider %s should provide Components of type %s, use consumer interfaces for dependency injection instead",
                                this.getClass().getSimpleName(),
                                field.getName(),
                                getComponentClass().getSimpleName()
                        );
                    }
                    C component = (C) field.get(this);
                    component.setName(field.getName());
                    if (component.getClass().equals(Task.class)) {
                        component.setName(field.getName().replaceAll("_", ":"));
                    }
                    components.add(component);
                }
            } catch (IllegalAccessException | ProviderException e) {
                e.printStackTrace();
            }
        }
        return components;
    }

    public final C getComponent(String name) {
        return provideComponents().stream().filter(component -> component.getName().equals(name)).findFirst().get();
    }
}
