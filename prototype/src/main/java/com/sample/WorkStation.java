package com.sample;

import com.sample.controller.*;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import com.sample.service.CalendarImpl;
import com.sample.service.Configuration;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.injection.initer.Controllers;
import org.fluentness.service.injection.initer.Repositories;
import org.fluentness.service.injection.initer.Services;
import org.fluentness.service.persistence.JdbcPersistence;

import static org.fluentness.Application.Platform.WEB;

public class WorkStation implements Application {

    @Override
    public Platform init(Services services, Repositories repositories, Controllers controllers) {
        services.set(
            JdbcPersistence.class,
            Authentication.class, Configuration.class,
            CalendarImpl.class
        );
        repositories.set(
            NoteRepository.class,
            UserRepository.class
        );
        controllers.set(
            ConsoleController.class,
            DesktopController.class,
            MobileController.class,
            WebController.class, WebEventsController.class, WebNotesController.class, WebUsersController.class
        );
        return WEB;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WorkStation(), args);
    }
}
