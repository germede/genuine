package com.sample;

import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Views;
import org.fluentness.Fluentness;
import org.fluentness.base.Base;
import org.fluentness.base.BaseBuilder;
import org.fluentness.base.common.exception.BuildException;
import org.fluentness.base.service.cacher.Cacher;
import org.fluentness.base.service.cacher.DefaultCacher;
import org.fluentness.base.service.config.Config;
import org.fluentness.base.service.config.DefaultConfig;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.base.service.server.Server;
import org.fluentness.data.Data;
import org.fluentness.data.DataBuilder;
import org.fluentness.flow.Flow;
import org.fluentness.flow.FlowBuilder;

public class SongLibraryApp extends Fluentness {

    public static void main(String[] args) {
        new SongLibraryApp(args);
    }

    private SongLibraryApp(String[] args) {
        super(args);
    }

    @Override
    protected Base buildBase(BaseBuilder builder) throws BuildException {
        return builder
            .add(Config.class, new DefaultConfig())
            .add(Logger.class, new DefaultLogger())
            .add(Server.class, new DefaultServer())
            .add(Cacher.class, new DefaultCacher())
            .build();
    }

    @Override
    protected Data buildData(DataBuilder builder) throws BuildException {
        return builder
            .add(SongRepository.class, new SongRepository())
            .build();
    }

    @Override
    protected Flow buildFlow(FlowBuilder builder) throws BuildException {
        return builder
            .add(Controllers.class, new Controllers())
            .set(Views.class, new Views())
            .build();
    }

}
