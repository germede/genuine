package com.sample;

import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;

class Tasks implements TaskProvider {

    Task song = commands(
        hello -> command(parameters("name"), "Say hello to someone",
            parameters -> {
                System.out.println(String.format("Hello %s", parameters[0]));
                System.out.println("How are you?");
            }
        ),

        good_bye -> command("Say good bye to the world without parameters",
            parameters -> System.out.println("Good bye world")
        )
    );

}
