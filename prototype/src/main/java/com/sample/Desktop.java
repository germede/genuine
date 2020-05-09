package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractDesktop;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;

public class Desktop extends AbstractDesktop {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(DesktopController.class)
            ;
    }

    @Override
    public Provider<Repository> repositories() {
        return super.repositories()
            .add(NoteRepository.class)
            .add(UserRepository.class)
            ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new Desktop(), args);
    }
}
