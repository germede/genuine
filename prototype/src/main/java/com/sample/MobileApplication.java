package com.sample;

import com.sample.controller.MobileController;
import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractMobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.Src;

@Src(
    services = MapConfiguration.class,
    repositories = {
        NoteRepository.class,
        UserRepository.class
    },
    controllers = MobileController.class
)
public class MobileApplication extends AbstractMobileApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new MobileApplication(), args);
    }
}
