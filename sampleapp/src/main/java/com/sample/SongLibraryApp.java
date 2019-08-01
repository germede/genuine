package sample;

import org.fluentness.Fluentness;
import org.fluentness.base.service.logger.JulLogger;
import org.fluentness.base.service.persistence.OpenJpaPersistence;
import org.fluentness.base.service.server.TomcatServer;
import sample.base.DevConfiguration;
import sample.data.SongRepository;
import sample.flow.Controllers;
import sample.flow.Forms;
import sample.flow.Styles;
import sample.flow.Views;

public class SongLibraryApp {

    public static void main(String[] args) {
        Fluentness.define(
                base -> base
                        .add(DevConfiguration.class, )
                        .add(TomcatServer.class)
                        .add(JulLogger.class)
                        .add(OpenJpaPersistence.class),
                data -> data
                        .add(SongRepository.class),
                flow -> flow
                        .add(Styles.class)
                        .add(Forms.class)
                        .add(Views.class)
                        .add(Controllers.class)
        );
        Fluentness.invoke(args);
    }
}
