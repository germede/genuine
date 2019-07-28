package com.sample.base;

import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import com.sample.flow.Styles;
import com.sample.flow.Views;
import org.fluentness.base.common.Environment;
import org.fluentness.base.Base;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.DefaultConfig;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

import static org.fluentness.base.service.config.Key.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.Key.StringKey.APP_HOSTNAME;
import static org.fluentness.base.service.config.Key.StringKey.PERSISTENCE_UNIT;

public class DevEnvironment implements Environment {

    @Override
    public void define(Base base) throws DefinitionException {
        base
            .add(new DefaultConfig(conf ->
                conf.set(APP_PORT, 8000)
                    .set(APP_HOSTNAME, "localhost")
                    .set(PERSISTENCE_UNIT, "songLibraryPU")
            ))
            .add(new DefaultLogger())
            .add(new DefaultServer())
        ;
    }

    @Override
    public void define(Data data) throws DefinitionException {
        data
            .add(new SongRepository());
    }

    @Override
    public void define(Flow flow) throws DefinitionException {
        flow
            .add(new Styles())
            .add(new Forms())
            .add(new Views())
            .add(new Controllers())
        ;
    }
}
