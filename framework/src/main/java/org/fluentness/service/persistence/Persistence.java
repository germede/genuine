package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.Service;
import org.fluentness.service.configurator.Setting;

import java.util.List;

public interface Persistence extends Service {

    Setting<String> JDBC_URL = new Setting<>();
    Setting<String> USERNAME = new Setting<>();
    Setting<String> PASSWORD = new Setting<>();


    <M extends Model> M retrieve(Class<M> modelClass, long id);

    <M extends Model> List<M> retrieve(Class<M> aClass, String... conditions);

    int persist(Model model);

    int remove(Model model);


}
