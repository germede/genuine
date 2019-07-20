package org.fluentness.base.generics;

import org.fluentness.base.exceptions.ProviderException;
import org.fluentness.base.logging.Log;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Provider<T extends Component> {

    private List<T> components = new ArrayList<>();

    public List<T> getComponents() {
        if (components.isEmpty()) {

            try {
                Field[] fields = this.getClass().getDeclaredFields();
                // todo: improve adding default tasks
                if (this instanceof TaskProvider) {
                    fields = Stream.concat(Arrays.stream(fields), Arrays.stream(TaskProvider.class.getDeclaredFields())).toArray(Field[]::new);
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
                    if (!getProducedComponentType().isAssignableFrom(field.get(this).getClass())) {
                        throw new ProviderException(
                            "Provider %s should provide Components of type %s, use consumer interfaces for dependency injection instead",
                            this.getClass().getSimpleName(),
                            field.getName(),
                            getProducedComponentType().getSimpleName()
                        );
                    }
                    T component = (T) field.get(this);
                    component.setName(field.getName());
                    if (component.getClass().equals(Task.class)) {
                        component.setName(field.getName().replaceAll("_", ":"));
                    }
                    components.add(component);
                }
            } catch (IllegalAccessException e) {
                Log.instance.error(e);
            } catch (ProviderException e) {
                Log.instance.error(e.getMessage());
                System.exit(1);
            }
        }
        return components;
    }

    public T getComponent(String name) {
        List<T> components = getComponents();
        return components.stream().filter(component -> component.getName().equals(name)).findFirst().get();
    }

    public abstract Class<T> getProducedComponentType();
}
