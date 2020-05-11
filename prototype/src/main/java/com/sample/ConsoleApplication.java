package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractConsoleApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.persistence.JdbcPersistence;

public class ConsoleApplication extends AbstractConsoleApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .service(JdbcPersistence.class)
            .repository(NoteRepository.class)
            .repository(UserRepository.class)
            .controller(ConsoleController.class)
        ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new ConsoleApplication(), args);
    }
}
