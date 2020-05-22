package org.fluentness.repository;

import java.util.List;

public interface Repository<M> {
    M select(long id);

    List<M> selectAll();

    List<M> selectByField(String field, Object value);

    int insert(M model);

    int update(M model);

    int delete(M model);

    int delete(long id);
}
