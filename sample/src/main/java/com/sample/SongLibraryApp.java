package com.sample;

import com.sample.base.DevEnvironment;
import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import com.sample.flow.Styles;
import com.sample.flow.Views;
import org.fluentness.Fluentness;
import org.fluentness.base.Base;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.DefaultConfigService;
import org.fluentness.base.service.logger.DefaultLoggerService;
import org.fluentness.base.service.resourceHandler.DefaultResourceHandlerService;
import org.fluentness.base.service.server.DefaultServerService;
import org.fluentness.base.service.viewCache.DefaultViewCacheService;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

public class SongLibraryApp extends Fluentness {

    public static void main(String[] args) {
        new SongLibraryApp(args);
    }

    private SongLibraryApp(String[] args) {
        super(args);
    }

    @Override
    protected void define(Base base) throws DefinitionException {
        base
            .add(new DefaultConfigService().within(new DevEnvironment()))
            .add(new DefaultLoggerService())
            .add(new DefaultServerService())
            .add(new DefaultResourceHandlerService())
            .add(new DefaultViewCacheService())
        ;
//            .add(new DefaultEntityManagerService());
    }

    @Override
    protected void define(Data data) throws DefinitionException {
        data
            .add(new SongRepository());
    }

    @Override
    protected void define(Flow flow) throws DefinitionException {
        flow
            .add(new Styles())
            .add(new Forms())
            .add(new Views())
            .add(new Controllers())
        ;
    }

}
