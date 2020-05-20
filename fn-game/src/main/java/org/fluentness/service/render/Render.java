package org.fluentness.service.render;

import org.fluentness.service.Service;
import org.fluentness.view.scene.Scene;

public interface Render extends Service {

    void render(Scene scene);

}
