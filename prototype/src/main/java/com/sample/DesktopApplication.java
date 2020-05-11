package com.sample;

import com.sample.controller.DesktopController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.injection.Provider;

public class DesktopApplication extends AbstractDesktopApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .repository(UserRepository.class)
            .repository(NoteRepository.class)
            .controller(DesktopController.class)
        ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new DesktopApplication(), args);
    }
}
