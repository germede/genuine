package com.sample;

import com.sample.base.DevEnvironment;
import com.sample.data.Song;
import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import org.fluentness.Fluentness;
import org.fluentness.base.BaseDefinition;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.cacher.Cacher;
import org.fluentness.base.service.cacher.DefaultCacher;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.base.service.server.Server;
import org.fluentness.data.DataDefinition;
import org.fluentness.flow.FlowDefinition;
import org.fluentness.flow.producer.controller.Controller;
import org.fluentness.flow.producer.form.Form;

public class SongLibraryApp extends Fluentness {

    @Override
    protected void defineBase(BaseDefinition definition) throws DefinitionException {
        definition
            .forService(Logger.class).useImplementation(new DefaultLogger())
            .forService(Server.class).useImplementation(new DefaultServer())
            .forService(Cacher.class).useImplementation(new DefaultCacher());
    }

    @Override
    protected void defineData(DataDefinition definition) throws DefinitionException {
        definition
            .forModel(Song.class).useRepository(new SongRepository());
    }

    @Override
    protected void defineFlow(FlowDefinition definition) throws DefinitionException {
        definition
            .forComponent(Controller.class).useProducer(new Controllers())
            .forComponent(Form.class).useProducer(new Forms());
    }

    public static void main(String[] args) {
        bootstrap(new SongLibraryApp()).within(new DevEnvironment()).executing(args);
    }
}
