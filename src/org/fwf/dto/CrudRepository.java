package org.fwf.dto;

import org.fwf.dba.Constraint;
import org.fwf.dba.Query;
import org.fwf.dba.QueryResult;
import org.fwf.exc.MethodIsAbsentOrInaccessibleException;
import org.fwf.exc.ModelHasNoMappedTableException;
import org.fwf.exc.ModelHasNoPrimaryKeyException;
import org.fwf.exc.ModelMustBeCreatedBeforeBeingModifiedException;
import org.fwf.log.Logger;
import org.fwf.mvc.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fwf.dto.RepositoryHelper.retrieveSetterMethod;

public class CrudRepository<T extends Model<T>> implements Repository<T> {

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
            model.setOriginal(model.clone());
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | CloneNotSupportedException e) {
            Logger.e(e.getMessage(), e);
        }
        return 0;
    }

    public List<T> findAll(Class<T> modelClass) {
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
                model.setOriginal(model.clone());
                models.add(model);
            }
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InstantiationException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | CloneNotSupportedException e) {
            Logger.e(e.getMessage(), e);
        }
        return models;
    }

    public int update(T model) {
        try {
            if (model.getOriginal() == null) {
                throw new ModelMustBeCreatedBeforeBeingModifiedException(model.getClass().getCanonicalName());
            }
            String table = RepositoryHelper.retrieveTable(model.getClass());
            Query.ColumnsValuesPairs columnsValuesPairs = RepositoryHelper.retrieveColumnsValuesPairBasedOnDifferences(model);
            QueryResult queryResult =
                    new Query()
                            .update(table)
                            .set(columnsValuesPairs.getColumns(), columnsValuesPairs.getValues())
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model.getOriginal()))
                            )
                            .orderBy(columnsValuesPairs.getColumns())
                            .execute();

            model.setOriginal(model.clone());
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException | ModelMustBeCreatedBeforeBeingModifiedException | CloneNotSupportedException e) {
            Logger.e(e.getMessage(), e);
        }
        return 0;
    }

    public int delete(T model) {
        try {
            if (model.getOriginal() == null) {
                throw new ModelMustBeCreatedBeforeBeingModifiedException(model.getClass().getCanonicalName());
            }
            String table = RepositoryHelper.retrieveTable(model.getClass());
            QueryResult queryResult =
                    new Query()
                            .delete()
                            .from(table)
                            .where(
                                    new Constraint(RepositoryHelper.retrievePrimaryKeyColumnName(model.getClass()))
                                            .isEqualTo(RepositoryHelper.retrievePrimaryKey(model.getOriginal()))
                            )
                            .execute();
            return queryResult.resultSize;
        } catch (ModelHasNoMappedTableException | IllegalAccessException | InvocationTargetException | MethodIsAbsentOrInaccessibleException | ModelHasNoPrimaryKeyException | ModelMustBeCreatedBeforeBeingModifiedException e) {
            Logger.e(e.getMessage(), e);
        }
        return 0;
    }

}
