package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.persistence.JdbcPersistence;

public class DesktopApplication extends AbstractDesktopApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .service(JdbcPersistence.class)
            .repository(UserRepository.class)
            .repository(NoteRepository.class)
            .controller(DesktopController.class)
        ;
    }

    @Override
    public void configure(Configuration configuration) {
        super.configure(configuration);
        configuration
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
        Fluentness.launch(new DesktopApplication(), args);
    }
}
