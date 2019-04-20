package org.fwf.dto;

import org.fwf.dba.*;
import org.fwf.exc.MethodIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.log.Log;
import org.fwf.mvc.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrudRepository<T extends Model<T>> implements Repository<T> {

    public CrudRepository() {

    }

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
            Log.e(e.getMessage(), e);
        }
        return 0;
    }

    public List<T> findAll(Class<T> modelClass) {
        List<T> result = new ArrayList<>();
        try {
            String table = QueryHelper.retrieveTable(modelClass);
            QueryResult queryResult =
                    new Query()
                            .select()
                            .from(table)
                            .execute();

            for (Map<String, Object> objectMap : queryResult.resultList) {
                T record = modelClass.newInstance();
                for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                    Method setter = QueryHelper.retrieveSetterMethod(modelClass, entry.getKey());
                    setter.invoke(record, entry.getValue());
                }
                result.add(record);
            }
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InstantiationException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Log.e(e.getMessage(), e);
        }
        return result;
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
                                    new Constraint("id").isEqualTo(model.getId())
                                            .and(new Constraint("1").isEqualTo("1")
                                                    .or(new Constraint("true").isEqualTo("true"))
                                            )
                                            .and(new Constraint("2").isEqualTo(2))
                            )
                            .orderBy(columnsValuesPairs.columns)
                            .execute();


            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Log.e(e.getMessage(), e);
        }
        return 0;
    }

}
