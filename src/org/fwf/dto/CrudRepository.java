package org.fwf.dto;

import org.fwf.dba.*;
import org.fwf.exc.MethodIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.exc.ModelHasNoPrimaryKeyException;
import org.fwf.log.Logger;
import org.fwf.mvc.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrudRepository<T extends Model<T>> implements Repository<T> {

    public int create(T model) {
        try {
            String table = QueryHelper.retrieveTable(model.getClass());
            Query.ColumnsValuesPairs columnsValuesPairs = QueryHelper.retrieveColumnsValuesPair(model);
            QueryResult queryResult =
                    new Query()
                            .insert()
                            .into(table, columnsValuesPairs.columns)
                            .values(columnsValuesPairs.values)
                            .execute();

            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Logger.e(e.getMessage(), e);
        }
        return 0;
    }

    public List<T> findAll(Class<T> modelClass) {
        List<T> models = new ArrayList<>();
        try {
            String table = QueryHelper.retrieveTable(modelClass);
            QueryResult queryResult =
                    new Query()
                            .select()
                            .from(table)
                            .execute();

            for (Map<String, Object> objectMap : queryResult.resultList) {
                T model = modelClass.newInstance();
                for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                    Method setter = QueryHelper.retrieveSetterMethod(modelClass, entry.getKey());
                    setter.invoke(model, entry.getValue());
                }
                model.setSavedPrimaryKey(QueryHelper.retrievePrimaryKey(model));
                models.add(model);
            }
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InstantiationException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.e(e.getMessage(), e);
        }
        return models;
    }

    public int update(T model) {
        try {
            String table = QueryHelper.retrieveTable(model.getClass());
            Query.ColumnsValuesPairs columnsValuesPairs = QueryHelper.retrieveColumnsValuesPair(model);
            QueryResult queryResult =
                    new Query()
                            .update(table)
                            .set(columnsValuesPairs.columns, columnsValuesPairs.values)
                            .where(
                                    new Constraint(QueryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(model.getSavedPrimaryKey()))
                            .orderBy(columnsValuesPairs.columns)
                            .execute();
            model.setSavedPrimaryKey(QueryHelper.retrievePrimaryKey(model));

            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.e(e.getMessage(), e);
        }
        return 0;
    }

}
