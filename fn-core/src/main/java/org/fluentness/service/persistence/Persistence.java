package org.fluentness.service.persistence;

import org.fluentness.model.CrudModel;
import org.fluentness.service.Service;

import java.util.List;

public interface Persistence extends Service {

    default String getTableName(CrudModel crudModel) {
        return getTableName(crudModel.getClass());
    }

    default String getTableName(Class<? extends CrudModel> modelClass) {
        return modelClass.getSimpleName().toLowerCase();
    }

    <M extends CrudModel> M retrieve(Class<M> modelClass, int id);

    <M extends CrudModel> List<M> retrieve(Class<M> modelClass, Condition... conditions);

    int persist(CrudModel crudModel);

    <M extends CrudModel> int remove(Class<M> modelClass, int id);

    default int remove(CrudModel crudModel) {
        return remove(crudModel.getClass(), crudModel.getId());
    }
}
