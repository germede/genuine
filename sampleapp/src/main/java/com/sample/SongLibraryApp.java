package com.sample;

import com.sample.base.DevConfiguration;
import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import com.sample.flow.Styles;
import com.sample.flow.Views;
import org.fluentness.Fluentness;
import org.fluentness.base.service.logger.JulLogger;
import org.fluentness.base.service.persistence.OpenJpaPersistence;
import org.fluentness.base.service.server.TomcatServer;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.define((base, data, flow) -> {
            base.add(DevConfiguration.class)
                .add(TomcatServer.class)
                .add(JulLogger.class)
                .add(OpenJpaPersistence.class);
            data.add(SongRepository.class);
            flow.add(Styles.class)
                .add(Forms.class)
                .add(Views.class)
                .add(Controllers.class);
        });
        Fluentness.invoke(args);
    }
}
