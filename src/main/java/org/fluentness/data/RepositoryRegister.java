package org.fluentness.data;

import org.fluentness.common.generics.Register;

public enum RepositoryRegister implements Register<Class<? extends Model>, Repository<? extends Model>> {

    INSTANCE;

    public Repository<?> getRepository(Class<? extends Model> modelClass){
        if (containsKey(modelClass)) {
            return get(modelClass);
        }
        Repository<?> repository = new Repository<>(modelClass);
        put(modelClass, repository);
        return repository;
    }

}
