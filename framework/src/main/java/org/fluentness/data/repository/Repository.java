package org.fluentness.data.repository;

import org.fluentness.data.model.Model;

public interface Repository<M extends Model> {

    Class<M> getModelClass();

}
