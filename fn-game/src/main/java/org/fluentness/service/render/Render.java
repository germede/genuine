package org.fluentness.service.render;

import org.fluentness.service.Service;
import org.fluentness.view.AbstractGameView;

@Service.MultiService
public interface Render extends Service {

    void render(AbstractGameView view);

}
