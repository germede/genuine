package com.sample.flow;

import org.fluentness.base.service.logger.Logger;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.provider.TaskProvider;

public class Tasks extends TaskProvider {

    private Logger logger;

    Task say_hello = does("Say hello to someone",
        arguments -> {
            System.out.println(String.format("Hello %s", arguments[0]));
            System.out.println("How are you?");
        },
        "name");


    Task say_bye = does("Say good bye to the world without using arguments",
        arguments -> System.out.println("Good bye world")
    );

    Task say = does("asdf",arguments -> System.out.println("tes"));

}
