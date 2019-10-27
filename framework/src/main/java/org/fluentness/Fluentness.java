package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.DefaultAbstractConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.logger.JulLoggerService;
import org.fluentness.service.persistence.OpenJpaPersistenceService;
import org.fluentness.service.server.TomcatServerService;

import java.lang.reflect.Method;
import java.util.List;

public enum Fluentness {
    does;

    public void inject(String appPackage) {
        try {
            // services
            List<Class> sClasses = ClassLoader.does.load(appPackage + ".service", Service.class);
            sClasses.add(JulLoggerService.class);
            sClasses.add(OpenJpaPersistenceService.class);
            sClasses.add(TomcatServerService.class);
            ClassRegister.does.inject(sClasses);

            // repositories
            List<Class> rClasses = ClassLoader.does.load(appPackage + ".repository", Repository.class);
            ClassRegister.does.inject(rClasses);

            // controllers
            List<Class> cClasses = ClassLoader.does.load(appPackage + ".controller", Controller.class);
            cClasses.add(DefaultAbstractConsoleController.class);
            ClassRegister.does.inject(cClasses);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invoke(String[] args) {
        try {
            String name = args.length == 0 ? "help" : args[0];
            Method toExecute = Controller.getAllActions(ClassRegister.does.getInstances(AbstractConsoleController.class))
                    .stream()
                    .filter(method -> method.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
            toExecute.invoke(ClassRegister.does.getInstance(toExecute.getDeclaringClass()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ConsoleException extends AbstractException {
        ConsoleException(String stringToFormat, Object... parameters) {
            super(stringToFormat, parameters);
        }
    }
}