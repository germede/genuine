package org.fluentness.service.looper;

import org.fluentness.controller.GameController;
import org.fluentness.service.Service;

public interface Looper extends Service {

    void loop(GameController controller);
}
