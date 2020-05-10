package org.fluentness.service.render;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.view.AbstractGameView;

@MultiService
public interface Render extends Service {

    void render(AbstractGameView scene);

}
