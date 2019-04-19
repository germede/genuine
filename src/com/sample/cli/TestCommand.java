package com.sample.cli;

import org.fwf.cli.Command;
import org.fwf.cnf.Configuration;

public class TestCommand implements Command {

    public String getName() {
        return "test";
    }

    public String getDescription() {
        return "Test command for development";
    }

    public void execute(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(Configuration.get("basePackage"));
        
    }
}
