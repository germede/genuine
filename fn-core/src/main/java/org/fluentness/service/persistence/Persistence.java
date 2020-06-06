package org.fluentness.service.persistence;

import org.fluentness.model.Model;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

import java.util.List;

public interface Persistence extends Service {

    Setting<String> DRIVER = new Setting<>();
    Setting<String> HOST = new Setting<>();
    Setting<Integer> PORT = new Setting<>();
    Setting<String> DATABASE = new Setting<>();
    Setting<String> URL_PARAMETER_QUERY = new Setting<>("");
    Setting<String> USERNAME = new Setting<>();
    Setting<String> PASSWORD = new Setting<>();

    <M extends Model> M retrieve(Class<M> modelClass, long id);

    <M extends Model> List<M> retrieve(Class<M> modelClass, String... conditions);

    int persist(Model model);

    int remove(Model model);
}
