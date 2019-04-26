package org.fluentworkflow.dao;

import org.fluentworkflow.mvc.Model;

import java.util.List;

public interface Repository<T extends Model> {
    List<T> list();

    T find(Object primaryKey);

    int create(T model);

    int update(T model);

    int delete(T model);
}
