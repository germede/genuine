package com.sample;

import com.sample.controller.WebController;
import com.sample.controller.WebEventsController;
import com.sample.controller.WebNotesController;
import com.sample.controller.WebUsersController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import com.sample.service.Configuration;
import org.fluentness.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.persistence.JdbcPersistence;

public class Web extends AbstractWebApplication {

    @Override
    public Provider<Service> services() {
        return super.services()
            .add(JdbcPersistence.class)
            .add(Authentication.class)
            .add(Configuration.class)
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
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(WebController.class)
            .add(WebEventsController.class)
            .add(WebNotesController.class)
            .add(WebUsersController.class)
            ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Web(), args);
    }
}
