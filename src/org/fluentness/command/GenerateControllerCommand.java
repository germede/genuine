package org.fluentness.command;

import org.fluentness.Fluentness;
import org.fluentness.common.ClassRegister;
import org.fluentness.common.Configuration;
import org.fluentness.controller.BaseRoute;
import org.fluentness.controller.Controller;
import org.fluentness.generator.ClassGenerator;
import org.fluentness.generator.FieldGenerator;
import org.fluentness.view.Template;

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
        new ClassGenerator(parameters.get("name") + "Controller")
                .setPackage(Configuration.getString(Configuration.APP_PACKAGE) + "." + ClassRegister.CONTROLLER)
                .addModifier(Modifier.PUBLIC)
                .addAnnotation(BaseRoute.class, "\"" + parameters.get("name").toLowerCase() + "\"")
                .addInterface(Controller.class)
                .addField(
                        new FieldGenerator(ServerStartCommand.class, "serverStartCommand")
                                .addAnnotation(Template.class, "test")
                                .addModifier(Modifier.STATIC)
                                .addModifier(Modifier.PRIVATE)
                                .setDefaultValue("new ServerStartCommand()")
                )
                .addField(
                        new FieldGenerator(Fluentness.class, "fluentness")
                                .addAnnotation(Template.class, "")
                                .addAnnotation(Template.class, "")
                                .addModifier(Modifier.PUBLIC)
                                .setDefaultValue("3")
                )
                .generate()
                .writeToFile()
        ;
    }
}
