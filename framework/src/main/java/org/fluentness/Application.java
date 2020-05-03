package org.fluentness;

import org.fluentness.service.configuration.Setting;
import org.fluentness.service.injection.initer.Controllers;
import org.fluentness.service.injection.initer.Repositories;
import org.fluentness.service.injection.initer.Services;

public interface Application {

    Platform init(Services services, Repositories repositories, Controllers controllers);

    enum Platform {
        CONSOLE,
        DESKTOP,
        MOBILE,
        WEB
    }

    Setting<String> NAME = new Setting<>("Fluentness application");


}
