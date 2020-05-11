package com.sample;

import com.sample.controller.MobileController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractMobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.injection.Provider;
import org.fluentness.controller.Template;

public class MobileApplication extends AbstractMobileApplication {

    @Override
    public Provider<Controller> controllers() {
        return super.controllers()
            .add(MobileController.class)
            ;
    }

    @Override
    public Provider<Template> views() {
        return super.views()
            .add(com.sample.controller.Mobile.class)
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
        Fluentness.launch(new MobileApplication(), args);
    }
}
