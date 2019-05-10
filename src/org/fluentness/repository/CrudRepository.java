package org.fluentness.repository;

import org.fluentness.model.Model;
import org.fluentness.register.ModelRegister;

public class CrudRepository<T extends Model> implements Repository<T> {
    private final Class<T> model;

    public CrudRepository(Class<T> model) {
        this.model = model;
    }

    @Override
    public Class<T> getModel() {
        return model;
    }

    @Override
    public Model getModelInstance() {
        return ModelRegister.getModelInstance(model.getCanonicalName());
    }

    @Override
    public Model.Properties getModelPropertiesInstance() {
        return ModelRegister.getModelPropertiesInstance(model.getCanonicalName());
    }
}
