package org.fluentness.repository;

import org.fluentness.ApplicationComponent;

import java.util.List;

public interface Repository<M extends Model> extends ApplicationComponent {

    Class<M> getModelClass();

    M select(int id);

    List<M> select();

    List<M> selectByField(String field, Object value);

    int insert(M model);

    int update(M model);

    int delete(M model);

    int delete(int id);
}
