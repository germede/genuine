package com.sample;

import com.sample.controller.WebController;
import com.sample.controller.WebEventsController;
import com.sample.controller.WebNotesController;
import com.sample.controller.WebUsersController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import org.fluentness.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class WebApplication extends AbstractWebApplication {

    WebApplication() {
        super(
            services -> services
                .add(JdbcPersistence.class)
                .add(Authentication.class),
            repositories -> repositories
                .add(NoteRepository.class)
                .add(UserRepository.class),
            controllers -> controllers
                .add(WebController.class)
                .add(WebEventsController.class)
                .add(WebNotesController.class)
                .add(WebUsersController.class),
            configuration -> configuration
                .set(Server.PORT, 8000)
                .set(Server.HOST, "0.0.0.0")
                .set(Router.SINGLE_PAGE_MODE, false)
                .set(Log.LEVEL, LogLevel.DEBUG)
                .set(Log.CONSOLE, true)
                .set(JdbcPersistence.URL_PARAMETER_QUERY, "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .set(JdbcPersistence.DATABASE, "workstation")
                .set(JdbcPersistence.USERNAME, "workstation")
                .set(JdbcPersistence.PASSWORD, "workstation")
        );
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WebApplication(), args);
    }
}
