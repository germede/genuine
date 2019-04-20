package org.fwf.dto;

import org.fwf.mvc.Model;

import java.util.List;

public interface Repository<T extends Model<T>>{
    int create(T model);
    List<T> findAll(Class<T> modelClass);
    int update(T model);

}
