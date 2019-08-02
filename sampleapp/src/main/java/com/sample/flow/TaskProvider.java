package com.sample.flow;

import org.fluentness.flow.component.task.Args;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.provider.Provider;

public class TaskProvider implements Provider<Task> {

    @Args({"name",""})
    Task say_hello = does("Say hello to someone",
        arguments -> {
            System.out.println(String.format("Hello %s", arguments[0]));
            System.out.println("How are you?");
        }
    ).withArguments("someone");


    Task say_bye = does("Say good bye to the world without using arguments",
        arguments -> System.out.println("Good bye world")
    );

    Task say = does(@Args({"name"}) "asdf", arguments -> System.out.println("tes"));

}
