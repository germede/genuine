package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.Service;

import java.util.List;

public interface Persistence extends Service {

    default String getTableName(Model model) {
        return getTableName(model.getClass());
    }

    default String getTableName(Class<? extends Model> modelClass) {
        return modelClass.getSimpleName().toLowerCase();
    }

    default String getIdName() {
        return "id";
    }

    <M extends Model> M retrieve(Class<M> modelClass, int id);

    <M extends Model> List<M> retrieve(Class<M> modelClass, Condition... conditions);

    int persist(Model model);

    <M extends Model> int remove(Class<M> modelClass, int id);

    default int remove(Model model) {
        return remove(model.getClass(), model.getId());
    }
}
