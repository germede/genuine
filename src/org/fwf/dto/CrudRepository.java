package org.fwf.dto;

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

    public boolean create(T model) {
        try {
            String table = QueryHelper.retrieveTable(model.getClass());
            QueryHelper.ColumnValueListsPair columnValueListsPair = QueryHelper.generateColumnValueListPair(model);
            new Query()
                    .insert()
                    .into(table, columnValueListsPair.columns)
                    .values(columnValueListsPair.values)
                    .execute();

            return true;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Log.e(e.getMessage(), e);
        }
        return false;
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

            for (Map<String, Object> objectMap : queryResult.resultMap) {
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

}
