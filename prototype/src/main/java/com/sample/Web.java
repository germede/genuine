package com.sample;

import com.sample.controller.WebController;
import com.sample.controller.WebEventsController;
import com.sample.controller.WebNotesController;
import com.sample.controller.WebUsersController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import org.fluentness.AbstractWeb;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class Web extends AbstractWeb {

    @Override
    public void configure(Configuration configuration) {
        configuration
            .set(Server.PORT, 8000)
            .set(Server.HOST, "0.0.0.0")
            .set(Router.SINGLE_PAGE_MODE, false)
            .set(Log.LEVEL, LogLevel.DEBUG)
            .set(Log.CONSOLE, true)
            .set(JdbcPersistence.URL_PARAMETER_QUERY, "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
            .set(JdbcPersistence.DATABASE, "workstation")
            .set(JdbcPersistence.USERNAME, "workstation")
            .set(JdbcPersistence.PASSWORD, "workstation");
    }

    @Override
    public Provider<Service> services() {
        return super.services()
            .add(JdbcPersistence.class)
            .add(Authentication.class)
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
