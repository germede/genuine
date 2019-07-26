package com.sample;

import com.sample.base.DevEnvironment;
import com.sample.data.Song;
import com.sample.data.SongRepository;
import com.sample.flow.Controllers;
import com.sample.flow.Forms;
import org.fluentness.Fluentness;
import org.fluentness.base.Base;
import org.fluentness.base.common.environment.Environment;
import org.fluentness.base.service.cacher.Cacher;
import org.fluentness.base.service.cacher.DefaultCacher;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.base.service.server.Server;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;
import org.fluentness.flow.producer.controller.Controller;
import org.fluentness.flow.producer.form.Form;

public class SongLibraryApp extends Fluentness {

    @Override
    protected void define(Base base) {

    }

    @Override
    protected void define(Data data) {
        data.forModel(Song.class).useRepository(SongRepository.class);
    }

    @Override
    protected void define(Flow flow) {
        flow.forComponent(Controller.class).useProducer(new Controllers())
            .forComponent(Form.class).useProducer(new Forms());
    }

    public static void main(String[] args) {
        bootstrap(new SongLibraryApp(), new DevEnvironment(), args);
    }
}
