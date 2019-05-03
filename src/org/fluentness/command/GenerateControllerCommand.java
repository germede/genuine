package org.fluentness.command;

import org.fluentness.common.ClassRegister;
import org.fluentness.common.Configuration;
import org.fluentness.controller.BaseRoute;
import org.fluentness.controller.Controller;
import org.fluentness.generator.JavaGenerator;

import java.lang.reflect.Modifier;

public class GenerateControllerCommand implements Command {

    @Override
    public String getName() {
        return "generate:controller";
    }

    @Override
    public String getDescription() {
        return "Creates a new controller class within the controller package";
    }

    @Override
    public Parameters getParameters() {
        return new Parameters()
                .add("name");
    }

    @Override
    public void execute(Parameters parameters) {
        new JavaGenerator(parameters.get("name") + "Controller")
                .setPackage(Configuration.getString(Configuration.APP_PACKAGE) + "." + ClassRegister.CONTROLLER)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(BaseRoute.class, "\"" + parameters.get("name").toLowerCase() + "\"")
                .addInterfaces(Controller.class)
                .generate()
        ;
    }
}
