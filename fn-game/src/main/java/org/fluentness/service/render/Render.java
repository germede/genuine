package org.fluentness.service.render;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.controller.AbstractGame;

@MultiService
public interface Render extends Service {

    void render(AbstractGame scene);

}
