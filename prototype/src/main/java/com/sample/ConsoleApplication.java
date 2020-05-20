package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractConsoleApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.Src;
import org.fluentness.service.persistence.JdbcPersistence;

@Src(
    services = {
        JdbcPersistence.class,
        MapConfiguration.class,
    },
    repositories = {
        NoteRepository.class,
        UserRepository.class,
    },
    controllers = ConsoleController.class
)
public class ConsoleApplication extends AbstractConsoleApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new ConsoleApplication(), args);
    }
}
