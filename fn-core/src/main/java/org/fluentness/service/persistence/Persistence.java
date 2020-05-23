package org.fluentness.service.persistence;

import com.j256.ormlite.support.ConnectionSource;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Persistence extends Service {

    Setting<String> DRIVER = new Setting<>();
    Setting<String> HOST = new Setting<>();
    Setting<Integer> PORT = new Setting<>();
    Setting<String> DATABASE = new Setting<>();
    Setting<String> URL_PARAMETER_QUERY = new Setting<>("");
    Setting<String> USERNAME = new Setting<>();
    Setting<String> PASSWORD = new Setting<>();

    ConnectionSource getConnectionSource();
}
