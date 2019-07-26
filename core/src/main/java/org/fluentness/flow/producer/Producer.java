package org.fluentness.flow.producer;

import org.fluentness.Fluentness;
import org.fluentness.base.common.exception.ProviderException;
import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;
import org.fluentness.flow.producer.task.Task;
import org.fluentness.flow.producer.task.TaskProducer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Stream;

public abstract class Producer<C extends Component> {

    private List<C> components = new ArrayList<>();

    protected <Comp extends Component> Consumer<Comp> consume(Class<Comp> componentClass) {
        return new Consumer<>(componentClass);
    }


    protected class Consumer<Comp extends Component> {

        private Class<Comp> componentClass;

        private Consumer(Class<Comp> componentClass) {
            this.componentClass = componentClass;
        }

        public <P extends Producer<Comp>> P from(Class<P> producerClass) {
            return (P) Fluentness.getFlow().getProducer(componentClass);
        }

    }

    protected <M extends Model> Repository<M> repository(Class<M> modelClass) {
        return Fluentness.getData().getRepository(modelClass);
    }

    public List<C> getComponents() {
        if (components.isEmpty()) {

            try {
                Field[] fields = this.getClass().getDeclaredFields();
                // todo: improve adding default tasks
                if (this instanceof TaskProducer) {
                    fields = Stream.concat(Arrays.stream(fields), Arrays.stream(TaskProducer.class.getDeclaredFields())).toArray(Field[]::new);
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
                            "Producer %s should provide Components of type %s, use consumer interfaces for dependency injection instead",
                            this.getClass().getSimpleName(),
                            field.getName(),
                            getProducedComponentType().getSimpleName()
                        );
                    }
                    C component = (C) field.get(this);
                    component.setName(field.getName());
                    if (component.getClass().equals(Task.class)) {
                        component.setName(field.getName().replaceAll("_", ":"));
                    }
                    components.add(component);
                }
            } catch (IllegalAccessException e) {
                Fluentness.getBase().getService(Logger.class).severe(e);
            } catch (ProviderException e) {
                Fluentness.getBase().getService(Logger.class).severe(e.getMessage());
                System.exit(1);
            }
        }
        return components;
    }

    public C getComponent(String name) {
        List<C> components = getComponents();
        return components.stream().filter(component -> component.getName().equals(name)).findFirst().get();
    }

    public abstract Class<C> getProducedComponentType();
}
