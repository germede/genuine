package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;
import org.fluentness.controller.View;

public class DesktopApplication extends AbstractDesktopApplication {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(DesktopController.class)
            ;
    }

    @Override
    public Provider<View> views() {
        return super.views()
            .add(com.sample.controller.Desktop.class)
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
        Fluentness.launch(new DesktopApplication(), args);
    }
}
