package org.fluentness.data;

public interface Repository<M extends Model> {

    Class<M> getModelClass();

}
