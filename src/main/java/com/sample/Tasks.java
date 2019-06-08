package com.sample;

import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;

public class Tasks implements TaskProvider {

    Task song = steps(parameters("name"),

        hello -> step("Say hello to someone",
            parameters -> {
                System.out.println(String.format("Hello %s", parameters[0]));
                System.out.println("How are you?");
            }
        ),

        good_bye -> step("Say good bye to the world without parameters",
            parameters -> System.out.println("Good bye world")
        )
    );

}
