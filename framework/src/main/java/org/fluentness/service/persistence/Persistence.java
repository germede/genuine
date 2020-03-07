package org.fluentness.service.persistence;

import org.fluentness.service.Service;
import org.fluentness.service.configurator.Setting;

import java.util.List;

public interface Persistence extends Service {

    Setting<String> JDBC_URL = new Setting<>();
    Setting<String> USERNAME = new Setting<>();
    Setting<String> PASSWORD = new Setting<>();


    <M> List<M> select(Class<M> aClass, String sql);

    int persist(String sql);
}
