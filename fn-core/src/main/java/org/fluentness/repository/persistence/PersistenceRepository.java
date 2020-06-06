package org.fluentness.repository.persistence;

import org.fluentness.model.Model;
import org.fluentness.repository.Repository;

import java.util.List;

public interface PersistenceRepository<M extends Model> extends Repository {
    M select(long id);

    List<M> selectByField(String field, Object value);

    int insert(M model);

    int update(M model);

    int delete(M model);
}
