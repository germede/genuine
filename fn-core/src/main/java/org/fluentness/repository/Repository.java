package org.fluentness.repository;

import org.fluentness.model.Model;

import java.util.List;

public interface Repository<M extends Model> {

    List<M> selectAll();

}
