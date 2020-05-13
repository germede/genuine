package org.fluentness.repository;

import java.util.List;

public interface CrudRepository<M extends CrudModel> extends Repository {
    M select(int id);

    List<M> select();

    List<M> selectByField(String field, Object value);

    int insert(M model);

    int update(M model);

    int delete(M model);

    int delete(int id);
}
