package org.fluentness.service.display;

import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.Service;

public interface Display extends Service {

    long getWindow();

    void clear(Vector3f background);

    void update();

    boolean shouldClose();

    void close();
}
