package org.fluentness.service.display;

import org.fluentness.service.Service;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.configuration.Setting;

public interface Display extends Service {

    Setting<String> TITLE = new Setting<>("MyGame");
    Setting<Integer> WIDTH = new Setting<>(1024);
    Setting<Integer> HEIGHT = new Setting<>(768);
    Setting<Boolean> FULLSCREEN = new Setting<>(false);

    int getFps();

    float getDelta();

    long getWindow();

    void clear(Vector3f background);

    void update();

    boolean shouldClose();

    void close();
}
