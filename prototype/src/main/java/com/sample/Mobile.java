package com.sample;

import com.sample.controller.MobileController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.view.MobileView;
import org.fluentness.AbstractMobile;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;
import org.fluentness.view.View;

public class Mobile extends AbstractMobile {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(MobileController.class)
            ;
    }

    @Override
    public Provider<View> views() {
        return super.views()
            .add(MobileView.class)
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
        Fluentness.launch(new Mobile(), args);
    }
}
