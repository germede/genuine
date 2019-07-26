package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.common.environment.Environment;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.common.exception.InjectionException;
import org.fluentness.base.common.exception.TaskNotFoundException;
import org.fluentness.base.common.exception.WrongUseOfTaskException;
import org.fluentness.base.common.injection.InjectProvider;
import org.fluentness.base.common.injection.InjectRepository;
import org.fluentness.base.common.injection.InjectService;
import org.fluentness.base.service.Service;
import org.fluentness.data.Data;
import org.fluentness.data.model.Model;
import org.fluentness.flow.Flow;
import org.fluentness.flow.producer.Component;
import org.fluentness.flow.producer.Producer;
import org.fluentness.flow.producer.task.Task;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

public abstract class Fluentness {

    private static Environment environment;

    public static Environment getEnvironment() {
        return environment;
    }

    protected static Fluentness bootstrap(Fluentness app, Environment environment, String[] args) {
        environment.initialize();
        Fluentness.environment = environment;
        try {

            app.base = new Base(app);
            app.data = new Data(app);
            app.flow = new Flow(app);

            app.define(app.base);
            app.define(app.base);
            app.define(app.base);

            app.base.applyDefinition();
            app.data.applyDefinition();
            app.flow.applyDefinition();

            app.execute(args);

        } catch (DefinitionException | InjectionException | ExecutionException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return app;
    }

    private Base base;
    private Data data;
    private Flow flow;

    public <T> T instantiateInjecting(Class<T> toInstantiate) throws InjectionException {
        T instance;
        try {
            instance = toInstantiate.newInstance();

            // inject dependencies
            for (Field field : toInstantiate.getFields()) {

                Object dependency = field.isAnnotationPresent(InjectService.class) ?
                    base.get((Class<Service>) field.getAnnotation(InjectService.class).value()) :
                    field.isAnnotationPresent(InjectRepository.class) ?
                        data.get((Class<Model>) field.getAnnotation(InjectRepository.class).value()) :
                        field.isAnnotationPresent(InjectProvider.class) ?
                            flow.get((Class<Component>) field.getAnnotation(InjectProvider.class).value()) :
                            null;

                if (dependency != null) {
                    field.setAccessible(true);
                    field.set(instance, dependency);
                    field.setAccessible(false);
                }
            }

        } catch (InstantiationException | IllegalAccessException e) {
            throw new InjectionException(e);
        }
        return instance;
    }


    private void execute(String[] args) throws ExecutionException {
        try {
            Producer<Task> tasks = flow.getProducer(Task.class);

            if (args.length == 0) {
                tasks.getComponent("help").execute(args);
                System.exit(0);
            }

            String taskName = args[0];
            Task taskToExecute = null;
            String[] declaredArguments = new String[0];
            for (Task task : tasks.getComponents()) {
                if (taskName.equals(task.getName())) {
                    taskToExecute = task;
                    declaredArguments = task.getArguments();
                    break;
                }
            }

            if (taskToExecute == null) {
                throw new TaskNotFoundException("No %s task found", taskName);
            }

            if (declaredArguments.length != args.length - 1) {
                throw new WrongUseOfTaskException("Wrong use of task %s, expected %s arguments, got %s",
                    taskToExecute.getName(),
                    declaredArguments.length,
                    args.length - 1
                );
            }

            String[] arguments = new String[declaredArguments.length];
            System.arraycopy(args, 1, arguments, 0, args.length - 1);
            taskToExecute.execute(arguments);

        } catch (TaskNotFoundException | WrongUseOfTaskException e) {
            throw new ExecutionException(e);
        }
    }


}
