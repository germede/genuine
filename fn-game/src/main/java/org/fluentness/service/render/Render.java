package org.fluentness.service.render;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;

@MultiService
public interface Render<O> extends Service {

    void render(O toRender);

}
