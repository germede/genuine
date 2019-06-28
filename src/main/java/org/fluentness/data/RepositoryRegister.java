package org.fluentness.data;

import org.fluentness.base.generics.Register;

public enum RepositoryRegister implements Register<RepositoryRegister, Class<? extends Model>, Repository<? extends Model>> {

    call;

    public Repository<?> getRepository(Class<? extends Model> modelClass){
        if (containsKey(modelClass)) {
            return get(modelClass);
        }
        Repository<?> repository = new Repository<>(modelClass);
        put(modelClass, repository);
        return repository;
    }

}
