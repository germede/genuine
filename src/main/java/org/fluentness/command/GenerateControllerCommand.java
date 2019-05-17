package org.fluentness.command;

import org.fluentness.common.PackageNames;
import org.fluentness.common.Utils;
import org.fluentness.configuration.Configuration;
import org.fluentness.controller.Controller;
import org.fluentness.generator.ClassGenerator;
import org.fluentness.generator.FieldGenerator;
import org.fluentness.generator.MethodGenerator;
import org.fluentness.controller.Request;
import org.fluentness.controller.Response;
import org.fluentness.repository.Repository;

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
    public String[] getParameters() {
        return new String[]{"name"};
    }

    @Override
    public void execute(String... parameters) {
        String name = parameters[0];

        new ClassGenerator(Utils.toTitelCase(name) + Utils.toTitelCase(PackageNames.CONTROLLER))
                .setPackage(Configuration.getString(Configuration.APP_PACKAGE) + "." + PackageNames.CONTROLLER)
                .addModifier(Modifier.PUBLIC)
                .addAnnotation(Controller.Route.class, "\"/" + name.toLowerCase() + "\"")
                .addInterface(Controller.class)
                .addField(
                        new FieldGenerator(Repository.class, "repository")
                                .addModifier(Modifier.PRIVATE)
                                .setDefaultValue("new ServerStartCommand()")
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Response.class, "list")
                                .addAnnotation(Controller.Route.class, "\"/list\"")
                                .addModifier(Modifier.PUBLIC)
                                .addParameter(Request.class, "request")
                                .setImplementationLines(
                                        "// todo implement list " + name,
                                        "return redirect(\"/\");"
                                )
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Response.class, "find")
                                .addAnnotation(Controller.Route.class, "\"/find/{id}\"")
                                .addModifier(Modifier.PUBLIC)
                                .addParameter(Request.class, "request")
                                .setImplementationLines(
                                        "// todo implement list " + name,
                                        "return redirect(\"/\");"
                                )
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Response.class, "create")
                                .addAnnotation(Controller.Route.class, "\"/create\"")
                                .addModifier(Modifier.PUBLIC)
                                .addParameter(Request.class, "request")
                                .setImplementationLines(
                                        "// todo implement create " + name,
                                        "return redirect(\"/\");"
                                )
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Response.class, "update")
                                .addAnnotation(Controller.Route.class, "\"/update/{id}\"")
                                .addModifier(Modifier.PUBLIC)
                                .addParameter(Request.class, "request")
                                .setImplementationLines(
                                        "// todo implement update " + name,
                                        "return redirect(\"/\");"
                                )
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Response.class, "delete")
                                .addAnnotation(Controller.Route.class, "\"/delete\"")
                                .addModifier(Modifier.PUBLIC)
                                .addParameter(Request.class, "request")
                                .setImplementationLines(
                                        "// todo implement delete " + name,
                                        "return redirect(\"/\");"
                                )
                                .generate()
                )
                .generate()
                .writeToFile()
        ;
    }
}
