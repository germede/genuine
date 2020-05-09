package com.sample;

import com.sample.controller.*;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import com.sample.service.Configuration;
import com.sample.service.calendar.CalendarImpl;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.injection.Injection;
import org.fluentness.service.injection.initer.Controllers;
import org.fluentness.service.injection.initer.Repositories;
import org.fluentness.service.injection.initer.Services;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.server.Server;

import java.io.IOException;

import static org.fluentness.Application.Platform.WEB;

public class WorkStation implements Application {

    @Override
    public Platform init(Services services, Repositories repositories, Controllers controllers) {
        services.set(
            FilePersistence.class,
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

    public static void main(String[] args) throws FluentnessException, IOException {
        Fluentness.launch(new WorkStation(), args);
        Injection.getInstance(Server.class).start();
    }
}
