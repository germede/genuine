package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.view.DesktopView;
import org.fluentness.AbstractDesktop;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;
import org.fluentness.view.View;

public class Desktop extends AbstractDesktop {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(DesktopController.class)
            ;
    }

    @Override
    public Provider<View> views() {
        return super.views()
            .add(DesktopView.class)
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
