package com.sample.flow;

import com.sample.data.Song;
import org.fluentness.base.common.injection.InjectProvider;
import org.fluentness.base.common.injection.InjectRepository;
import org.fluentness.base.common.injection.InjectService;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.provider.TaskProvider;

public class Tasks extends TaskProvider {

    @InjectService(Logger.class)

    // todo MAKE FLuentness and all providers an interface!!!!!!!!!!,
    // remove consumers and use only dependency injection
    // injector as singleton in common package
    // provider -> provider
    // provider and component split


    private Logger logger;


    Task say_hello = does("Say hello to someone",
        arguments -> {
            System.out.println(String.format("Hello %s", arguments[0]));
            System.out.println("How are you?");
        },
        "name");


    @InjectProvider(Task.class)
    Task say_bye = does("Say good bye to the world without using arguments",
        arguments -> System.out.println("Good bye world")
    );

    @InjectRepository(Song.class)
    Task say = does("asdf",arguments -> System.out.println("tes"));

}
