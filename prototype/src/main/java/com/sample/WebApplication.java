package com.sample;

import com.sample.controller.WebController;
import com.sample.controller.WebEventsController;
import com.sample.controller.WebNotesController;
import com.sample.controller.WebUsersController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.BasicAuthentication;
import com.sample.service.StringTranslator;
import org.fluentness.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class WebApplication extends AbstractWebApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .service(JdbcPersistence.class)
            .service(BasicAuthentication.class)
            .service(StringTranslator.class)
            .repository(NoteRepository.class)
            .repository(UserRepository.class)
            .controller(WebController.class)
            .controller(WebEventsController.class)
            .controller(WebNotesController.class)
            .controller(WebUsersController.class)
        ;
    }

    @Override
    public void configure(Configuration configuration) {
        super.configure(configuration);
        configuration
            .set(Server.PORT, 8000)
            .set(Server.HOST, "0.0.0.0")
            .set(Router.SINGLE_PAGE_MODE, false)
            .set(Log.LEVEL, LogLevel.DEBUG)
            .set(Log.CONSOLE, true)
            .set(
                JdbcPersistence.URL_PARAMETER_QUERY,
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
            )
            .set(JdbcPersistence.DATABASE, "workstation")
            .set(JdbcPersistence.USERNAME, "workstation")
            .set(JdbcPersistence.PASSWORD, "workstation")
        ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WebApplication(), args);
    }
}
