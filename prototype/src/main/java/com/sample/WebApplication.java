package com.sample;

import com.sample.controller.*;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.BasicAuthentication;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractWebApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.Src;
import org.fluentness.service.persistence.JdbcPersistence;

@Src(
    services = {
        JdbcPersistence.class,
        BasicAuthentication.class,
        MapConfiguration.class,
    },
    repositories = {
        NoteRepository.class,
        UserRepository.class,
    },
    controllers = {
        WebController.class,
        WebEmailController.class,
        WebCalendarController.class,
        WebNotesController.class,
        WebSettingsController.class,
    }
)
public class WebApplication extends AbstractWebApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WebApplication(), args);
    }
}
