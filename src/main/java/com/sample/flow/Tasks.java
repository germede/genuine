package com.sample.flow;

import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

public class Tasks extends TaskProvider {

    Task test = does("Simulates dialogue",
        hello -> step("Say hello to someone",
            arguments -> {
                System.out.println(String.format("Hello %s", arguments[0]));
                System.out.println("How are you?");
            }
        ),

        good_bye -> step("Say good bye to the world without using arguments",
            arguments -> System.out.println("Good bye world")
        )
    ).args("name");

}
