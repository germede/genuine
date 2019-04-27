package org.fluentness.repository;

import org.fluentness.database.Constraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.database.SqlQueryResult;
import org.fluentness.logging.Logger;
import org.fluentness.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fluentness.repository.RepositoryHelper.retrieveSetterMethod;

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
            SqlQueryResult queryResult =
                    new SqlQuery()
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
            Logger.error(this.getClass(), e);
        }
        return models;
    }

    @Override
    public T find(Object primaryKey) {
        T model = null;
        try {
            String table = RepositoryHelper.retrieveTable(modelClass);
            SqlQueryResult queryResult =
                    new SqlQuery()
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
            Logger.error(this.getClass(), e);
        } catch (ModelHasNoPrimaryKeyException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public int create(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            SqlQuery.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPair(model);
            SqlQueryResult queryResult =
                    new SqlQuery()
                            .insert()
                            .into(table, columnsValuesPairs.getColumns())
                            .values(columnsValuesPairs.getValues())
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Logger.error(this.getClass(), e);
        }
        return 0;
    }

    @Override
    public int update(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            T original = find(RepositoryHelper.retrievePrimaryKey(model));
            SqlQuery.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPairBasedOnDifferences(model,original);
            if (columnsValuesPairs.getColumns().isEmpty() || columnsValuesPairs.getValues().isEmpty()) {
                // nothing to update
                return 0;
            }
            SqlQueryResult queryResult =
                    new SqlQuery()
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
            Logger.error(this.getClass(), e);
        }
        return 0;
    }

    @Override
    public int delete(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            SqlQueryResult queryResult =
                    new SqlQuery()
                            .delete()
                            .from(table)
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model))
                            )
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.error(this.getClass(), e);
        }
        return 0;
    }

    // Static methods
    public static int create(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).create(model);
    }

    public static int update(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).update(model);
    }

    public static int delete(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).delete(model);
    }
}
