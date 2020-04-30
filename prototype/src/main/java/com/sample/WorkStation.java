package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.controller.DesktopController;
import com.sample.controller.WebController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Authentication;
import com.sample.service.Configuration;
import com.sample.service.Translator;
import com.sample.service.calendar.CalendarServiceImpl;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;

public class WorkStation implements Application {

    @Override
    public Class<? extends Service>[] getServices() {
        return services(
            Configuration.class,
            Translator.class,
            Authentication.class,
            CalendarServiceImpl.class
        );
    }

    @Override
    public Class<? extends Repository>[] getRepositories() {
        return repositories(
            NoteRepository.class,
            UserRepository.class
        );
    }

    @Override
    public Class<? extends Controller>[] getControllers() {
        return controllers(
            ConsoleController.class,
            DesktopController.class,
            WebController.class
        );
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WorkStation()).web();
    }
}
