package com.sample.base;

import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import com.sample.flow.Styles;
import com.sample.flow.Views;
import org.fluentness.base.common.Environment;
import org.fluentness.base.Base;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.BasicConfiguration;
import org.fluentness.base.service.logger.JulLogger;
import org.fluentness.base.service.server.TomcatServer;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

import static org.fluentness.base.service.configuration.Key.Integer.APP_PORT;
import static org.fluentness.base.service.configuration.Key.String.APP_HOSTNAME;
import static org.fluentness.base.service.configuration.Key.String.PERSISTENCE_UNIT;

public class DevEnvironment implements Environment {

    @Override
    public void define(Base base) throws DefinitionException {
        base.define(new BasicConfiguration(conf -> conf
            .set(APP_PORT, 8000)
            .set(APP_HOSTNAME, "localhost")
            .set(PERSISTENCE_UNIT, "songLibraryPU")))
            .define(new TomcatServer())
            .define(new JulLogger());
    }

    @Override
    public void define(Data data) throws DefinitionException {
        data.define(new SongRepository());
    }

    @Override
    public void define(Flow flow) throws DefinitionException {
        flow.define(new Styles())
            .define(new Forms())
            .define(new Views())
            .define(new Controllers());
    }
}
