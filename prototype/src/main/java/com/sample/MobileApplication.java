package com.sample;

import com.sample.controller.*;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import org.fluentness.AbstractMobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.injection.Provider;

public class MobileApplication extends AbstractMobileApplication {

    @Override
    public void provide(Provider provider) {
        super.provide(provider);
        provider
            .repository(NoteRepository.class)
            .repository(UserRepository.class)
            .controller(WebController.class)
            .controller(WebEmailController.class)
            .controller(WebCalendarController.class)
            .controller(WebNotesController.class)
            .controller(WebSettingsController.class)
            .controller(MobileController.class)
        ;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new MobileApplication(), args);
    }
}
