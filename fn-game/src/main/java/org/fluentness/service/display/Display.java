package org.fluentness.service.display;

import org.fluentness.service.Service;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.configuration.Setting;

public interface Display extends Service {

    Setting<String> TITLE = new Setting<>("MyGame");
    Setting<Integer> WIDTH = new Setting<>(720);
    Setting<Integer> HEIGHT = new Setting<>(480);

    int getFps();

    long getWindow();

    void clear(Vector3f background);

    void update();

    boolean shouldClose();

    void close();
}
