package org.fluentness.repository;

import org.fluentness.model.Model;

import java.util.List;

public interface CrudRepository<M extends Model> extends Repository<M> {
    M select(long id);

    List<M> selectAll();

    List<M> selectByField(String field, Object value);

    int insert(M entity);

    int update(M entity);

    int delete(M entity);

    int delete(long id);
}
