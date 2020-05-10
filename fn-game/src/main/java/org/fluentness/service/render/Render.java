package org.fluentness.service.render;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.view.scene.Scene;

@MultiService
public interface Render extends Service {

    void render(Scene scene);

}
