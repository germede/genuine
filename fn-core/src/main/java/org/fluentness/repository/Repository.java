package org.fluentness.repository;

import org.fluentness.model.Model;

import java.util.Collection;

public interface Repository<M extends Model> {

    Collection<M> selectAll();

}
