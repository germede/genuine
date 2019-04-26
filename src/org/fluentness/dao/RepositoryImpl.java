package org.fluentness.dao;

import org.fluentness.dba.Constraint;
import org.fluentness.dba.Query;
import org.fluentness.dba.QueryResult;
import org.fluentness.exc.MethodIsAbsentOrInaccessibleException;
import org.fluentness.exc.ModelHasNoMappedTableException;
import org.fluentness.exc.ModelHasNoPrimaryKeyException;
import org.fluentness.log.Logger;
import org.fluentness.mvc.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fluentness.dao.RepositoryHelper.retrieveSetterMethod;

public class RepositoryImpl<T extends Model> implements Repository<T> {

    private Class<T> modelClass;

    public RepositoryImpl(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public List<T> list() {


        List<T> models = new ArrayList<>();
        try {
            String table = RepositoryHelper.retrieveTable(modelClass);
            QueryResult queryResult =
                    new Query()
                            .select()
                            .from(table)
                            .execute();

            for (Map<String, Object> objectMap : queryResult.resultList) {
                T model = modelClass.newInstance();
                for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                    Method setter = retrieveSetterMethod(modelClass, entry.getKey());
                    setter.invoke(model, entry.getValue());
                }
                models.add(model);
            }
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InstantiationException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Logger.e(e);
        }
        return models;
    }

    @Override
    public T find(Object primaryKey) {
        T model = null;
        try {
            String table = RepositoryHelper.retrieveTable(modelClass);
            QueryResult queryResult =
                    new Query()
                            .select()
                            .from(table)
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(modelClass)).isEqualTo(primaryKey)
                            )
                            .execute();

            if (queryResult.resultList.size() > 0) {
                model = modelClass.newInstance();
                for (Map.Entry<String, Object> entry : queryResult.resultList.get(0).entrySet()) {
                    Method setter = retrieveSetterMethod(modelClass, entry.getKey());
                    setter.invoke(model, entry.getValue());
                }
            }
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InstantiationException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Logger.e(e);
        } catch (ModelHasNoPrimaryKeyException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public int create(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            Query.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPair(model);
            QueryResult queryResult =
                    new Query()
                            .insert()
                            .into(table, columnsValuesPairs.getColumns())
                            .values(columnsValuesPairs.getValues())
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Logger.e(e);
        }
        return 0;
    }

    @Override
    public int update(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            T original = find(RepositoryHelper.retrievePrimaryKey(model));
            Query.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPairBasedOnDifferences(model,original);
            if (columnsValuesPairs.getColumns().isEmpty() || columnsValuesPairs.getValues().isEmpty()) {
                // nothing to update
                return 0;
            }
            QueryResult queryResult =
                    new Query()
                            .update(table)
                            .set(columnsValuesPairs.getColumns(), columnsValuesPairs.getValues())
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model))
                            )
                            .orderBy(columnsValuesPairs.getColumns())
                            .execute();

            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.e(e);
        }
        return 0;
    }

    @Override
    public int delete(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            QueryResult queryResult =
                    new Query()
                            .delete()
                            .from(table)
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model))
                            )
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.e(e);
        }
        return 0;
    }

}
