package org.fluentness.base.generics;

import org.fluentness.base.exceptions.ComponentNotFoundException;
import org.fluentness.base.logging.Log;
import org.fluentness.flow.task.Task;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public abstract class Provider<T extends Component> {

    private List<T> components;

    public List<T> getAll() {
        if (components == null) {
            components = new ArrayList<>();
            try {
                Field[] fields = this.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.getModifiers() != 0) {
                        Log.call.fatal("Component %s->%s should have no modifiers, found %s",
                            this.getClass().getSimpleName(),
                            field.getName(),
                            Modifier.toString(field.getModifiers())
                        );
                    }
                    field.setAccessible(true);
                    if (!getProducedComponentType().isAssignableFrom(field.get(this).getClass())) {
                        Log.call.fatal("Provider %s should provide Components of type %s, use consumer interfaces for dependency injection instead",
                            this.getClass().getSimpleName(),
                            field.getName(),
                            getProducedComponentType().getSimpleName()
                        );
                    }
                    T component = (T) field.get(this);
                    component.setName(field.getName());
                    if (component.getClass().equals(Task.class)) {
                        component.setName(field.getName().replaceAll("_",":"));
                    }
                    components.add(component);
                }
            } catch (IllegalAccessException e) {
                Log.call.fatal(e);
            }
        }
        return components;
    }

    public T get(String name) {
        try {
            return getAll().stream()
                .filter(component -> name.contains(component.getName()))
                .findAny().orElseThrow(ComponentNotFoundException::new);
        } catch (ComponentNotFoundException e) {
            Log.call.fatal("Component %s not found by provider %s",
                name,
                this.getClass().getSimpleName()
            );
        }
        return null;
    }

    public void addAll(List<T> components) {
        getAll().addAll(components);
    }

    public abstract Class<T> getProducedComponentType();
}
