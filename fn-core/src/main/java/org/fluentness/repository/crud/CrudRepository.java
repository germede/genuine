package org.fluentness.repository.crud;

import org.fluentness.model.Model;
import org.fluentness.repository.Repository;

import java.util.List;

public interface CrudRepository<M extends Model> extends Repository {
    M select(long id);

    List<M> selectAll();

    List<M> selectByField(String field, Object value);

    int insert(M model);

    int update(M model);

    int delete(M model);

    int delete(long id);
}
