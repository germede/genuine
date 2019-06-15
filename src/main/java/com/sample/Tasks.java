package com.sample;

import org.fluentness.task.Task;
import org.fluentness.task.TaskProducer;

public class Tasks extends TaskProducer {

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
