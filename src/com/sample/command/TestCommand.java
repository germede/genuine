package com.sample.command;

import org.fluentness.Fluentness;
import org.fluentness.command.Command;
import org.fluentness.generator.JavaGenerator;

import java.lang.reflect.Modifier;

public class TestCommand implements Command {

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "Test command for development";
    }

    @Override
    public void execute(String[] args) {
//        HttpServer.start();

        new JavaGenerator("tmp","Test")
                .setPackage("com.sample")
                .addModifiers(Modifier.PUBLIC)
                .setParent(Fluentness.class)
                .addInterfaces(Command.class)
                .generate()
        ;
    }
}
