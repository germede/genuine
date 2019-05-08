package org.fluentness.repository;

import org.fluentness.database.SqlConstraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.database.SqlResult;
import org.fluentness.logging.Logger;
import org.fluentness.entity.Entity;
import org.fluentness.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.fluentness.repository.RepositoryHelper.retrieveSetterMethod;

public class BasicRepository<T extends Model> implements Repository<T> {

    private Class<T> modelClass;

    public BasicRepository(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public List<Entity<T>> list() {


    }



    @Override
    public int create(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            SqlQuery.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPair(model);
            SqlResult queryResult =
                    new SqlQuery()
                            .insert()
                            .into(table)
                            .values(columnsValuesPairs.getValues())
                            .execute();
            return queryResult.size;
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
            SqlResult queryResult =
                    new SqlQuery()
                            .update(table)
                            .set(columnsValuesPairs.getColumns(), columnsValuesPairs.getValues())
                            .where(
                                    new SqlConstraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model))
                            )
                            .orderBy(columnsValuesPairs.getColumns())
                            .execute();

            return queryResult.size;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.error(this.getClass(), e);
        }
        return 0;
    }

    @Override
    public int delete(T model) {
        try {
            String table = RepositoryHelper.retrieveTable(model.getClass());
            SqlResult queryResult =
                    new SqlQuery()
                            .delete()
                            .from(table)
                            .where(
                                    new SqlConstraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model))
                            )
                            .execute();
            return queryResult.size;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException e) {
            Logger.error(this.getClass(), e);
        }
        return 0;
    }

    // Static methods
    public static int create(Model model, Class modelClass) {
        return new BasicRepository<>(modelClass).create(model);
    }

    public static Model find(Object primaryKey, Class modelClass) {
        return new BasicRepository<>(modelClass).find(primaryKey);
    }

    public static int update(Model model, Class modelClass) {
        return new BasicRepository<>(modelClass).update(model);
    }

    public static int delete(Model model, Class modelClass) {
        return new BasicRepository<>(modelClass).delete(model);
    }
}
