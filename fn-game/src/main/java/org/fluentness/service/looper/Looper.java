package org.fluentness.service.looper;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.Service;

public interface Looper extends Service {

    void loop(AbstractGameController controller);
}
