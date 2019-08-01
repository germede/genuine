package com.sample;

import com.sample.base.ConfigurationService;
import com.sample.base.LocalizationService;
import com.sample.flow.ControllerProvider;
import org.fluentness.Fluentness;
import org.fluentness.base.service.logger.JulLogger;
import org.fluentness.base.service.persistence.OpenJpaPersistence;
import org.fluentness.base.service.server.TomcatServer;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.define(
                base -> base
                        .add(ConfigurationService.class)
                        .add(LocalizationService.class)
                        .add(TomcatServer.class)
                        .add(JulLogger.class)
                        .add(OpenJpaPersistence.class),
                data -> data
                        .add(SongRepository.class),
                flow -> flow
                        .add(ControllerProvider.class)
                        .add(Forms.class)
                        .add(Views.class)
                        .add(Controllers.class)
        );
        Fluentness.invoke(args);
    }
}
