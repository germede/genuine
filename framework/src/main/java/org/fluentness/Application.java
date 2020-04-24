package org.fluentness;

import org.fluentness.controller.web.Controller;
import org.fluentness.repository.crud.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configurator.Setting;

public interface Application {

    Setting<String> NAME = new Setting<>("Fluentness application");

    Class<? extends Service>[] getServices();

    Class<? extends Repository>[] getRepositories();

    Class<? extends Controller>[] getControllers();

}
