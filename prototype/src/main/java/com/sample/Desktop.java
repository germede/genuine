package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Configuration;
import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.persistence.FilePersistence;

public class Desktop extends AbstractDesktopApplication {

    @Override
    public Provider<Service> services() {
        return super.services()
            .add(FilePersistence.class)
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
            .add(DesktopController.class)
            ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Desktop(), args);
    }
}
