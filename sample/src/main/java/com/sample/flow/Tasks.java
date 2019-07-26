package com.sample.flow;

import org.fluentness.flow.producer.task.Task;
import org.fluentness.flow.producer.task.TaskProducer;

public class Tasks extends TaskProducer {

    Task say_hello = does("Say hello to someone",
        arguments -> {
            System.out.println(String.format("Hello %s", arguments[0]));
            System.out.println("How are you?");
        },
        "name");

    Task say_bye = does("Say good bye to the world without using arguments",
        arguments -> System.out.println("Good bye world")
    );

}
