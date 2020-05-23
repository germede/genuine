package org.fluentness.service.manager;

import org.fluentness.controller.AbstractGameController;
import org.fluentness.service.Service;

public interface Manager extends Service {

    void manage(AbstractGameController controller);
}
