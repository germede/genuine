package com.sample;

import org.fluentness.task.Task;
import org.fluentness.task.TaskProducer;

public class Tasks extends TaskProducer {

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
