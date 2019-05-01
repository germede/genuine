package org.fluentness.repository;

import org.fluentness.sql.Constraint;
import org.fluentness.sql.Query;
import org.fluentness.sql.Result;
import org.fluentness.logging.Log;
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
            Result queryResult =
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
            Log.error(this.getClass(), e);
        }
        return models;
    }

    @Override
    public T find(Object primaryKey) {
        T model = null;
        try {
            String table = RepositoryHelper.retrieveTable(modelClass);
            Result queryResult =
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
            Log.error(this.getClass(), e);
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
            Result queryResult =
                    new Query()
                            .insert()
                            .into(table, columnsValuesPairs.getColumns())
                            .values(columnsValuesPairs.getValues())
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException e) {
            Log.error(this.getClass(), e);
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
            Result queryResult =
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
            Log.error(this.getClass(), e);
        }
        return 0;
    }

    @Override
    public int delete(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            Result queryResult =
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
            Log.error(this.getClass(), e);
        }
        return 0;
    }

    // Static methods
    public static int create(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).create(model);
    }

    public static Model find(Object primaryKey, Class modelClass) {
        return new RepositoryImpl<>(modelClass).find(primaryKey);
    }

    public static int update(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).update(model);
    }

    public static int delete(Model model, Class modelClass) {
        return new RepositoryImpl<>(modelClass).delete(model);
    }
}
