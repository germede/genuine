package org.fluentness.prototype.service;

import org.fluentness.service.configuration.AbstractMapConfiguration;
import org.fluentness.service.display.Display;

public class MapConfiguration extends AbstractMapConfiguration {

    public MapConfiguration() {
        set(Display.TITLE, "Forest");
        set(Display.WIDTH, 1800);
        set(Display.HEIGHT, 900);
        set(Display.FULLSCREEN, false);
    }

}
