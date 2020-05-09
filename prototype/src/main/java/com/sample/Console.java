package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractConsole;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.persistence.JdbcPersistence;

public class Console extends AbstractConsole {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(ConsoleController.class)
            ;
    }

    @Override
    public Provider<Repository> repositories() {
        return super.repositories()
            .add(NoteRepository.class)
            .add(UserRepository.class)
            ;
    }

    @Override
    public Provider<Service> services() {
        return super.services()
            .add(JdbcPersistence.class)
            ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Console(), args);
    }
}
