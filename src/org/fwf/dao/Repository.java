package org.fwf.dao;

import org.fwf.mvc.Model;

import java.util.List;

public interface Repository<T extends Model> {
    List<T> list();

    T find(Object primaryKey);

    int create(T model);

    int update(T model);

    int delete(T model);
}
