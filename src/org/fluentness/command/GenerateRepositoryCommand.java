package org.fluentness.command;

import org.fluentness.common.PackageNames;
import org.fluentness.common.Utils;
import org.fluentness.configuration.Configuration;
import org.fluentness.generator.ClassGenerator;
import org.fluentness.generator.MethodGenerator;
import org.fluentness.repository.Repository;

import java.lang.reflect.Modifier;

public class GenerateRepositoryCommand implements Command {

    @Override
    public String getName() {
        return "generate:repository";
    }

    @Override
    public String getDescription() {
        return "Creates a new repository class within the repository package";
    }

    @Override
    public String[] getParameters() {
        return new String[]{"name"};
    }

    @Override
    public void execute(String... parameters) {
        String name = parameters[0];

        new ClassGenerator(Utils.toTitelCase(name) + Utils.toTitelCase(PackageNames.REPOSITORY))
                .setPackage(Configuration.getString(Configuration.APP_PACKAGE) + "." + PackageNames.REPOSITORY)
                .addModifier(Modifier.PUBLIC)
                .addInterface(Repository.class)
                .addMethod(
                        new MethodGenerator(Class.class, "getModel")
                                .addAnnotation(Override.class)
                                .addModifier(Modifier.PUBLIC)
                                .setImplementationLines(
                                        "// todo implement",
                                        "return null;"
                                )
                                .generate()
                )
                .generate()
                .writeToFile()
        ;
    }
}
