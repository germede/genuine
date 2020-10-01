package org.fluentness.prototype.service;

import org.fluentness.service.configuration.AbstractConfiguration;
import org.fluentness.service.display.Display;

public class Configuration extends AbstractConfiguration {


    @Override
    protected void configure() {
        set(Display.WIDTH, 1800);
        set(Display.HEIGHT, 900);
        set(Display.FULLSCREEN, false);

    }

}
