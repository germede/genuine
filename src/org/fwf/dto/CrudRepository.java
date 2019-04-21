package org.fwf.dto;

import org.fwf.mvc.Model;

import java.util.List;

public interface CrudRepository<T extends Model<T>> {
    List<T> list(Class<T> modelClass);

    T find(Class<T> personClass, Object pk);

    int create(T model);

    int update(T model);

    int delete(T model);
}
