package org.fluentness.repository;

import org.fluentness.database.SqlConstraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.entity.Entity;
import org.fluentness.model.Model;
import org.fluentness.register.ModelRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Repository<T extends Model> {

    Class<T> getModel();

    default Model getModelInstance() {
        return ModelRegister.getModelInstance(getModel().getCanonicalName());
    }

    default Model.Properties getModelPropertiesInstance() {
        return ModelRegister.getModelPropertiesInstance(getModel().getCanonicalName());
    }

    default List<Entity<T>> entityListFrom(List<Map<String, Object>> resultList) {
        List<Entity<T>> entityList = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : resultList) {
            Entity<T> entity = new Entity<>(getModel());
            stringObjectMap.forEach(entity::set);
            entityList.add(entity);
        }
        return entityList;
    }

    default List<Entity<T>> list() {
        return entityListFrom(new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .execute()
                .resultList());
    }

    default Entity<T> find(Object primaryKey) {
        return entityListFrom(new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(primaryKey))
                .execute()
                .resultList()).get(0);
    }

    default int create(Entity<T> entity) {
        return new SqlQuery()
                .insert()
                .into(getModelInstance().getTable())
                .values(entity.getAll())
                .execute()
                .resultSize();
    }

    default int update(Entity<T> entity) {
        return new SqlQuery()
                .update(getModelInstance().getTable())
                .set(entity.getAll())
                .execute()
                .resultSize();
    }

    default int delete(Entity<T> entity) {
        return new SqlQuery()
                .delete()
                .from(getModelInstance().getTable())
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(entity.getPrimaryKey()))
                .execute()
                .resultSize();
    }
}
