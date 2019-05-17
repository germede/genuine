package org.fluentness.repository;

import org.fluentness.database.SqlConstraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.entity.Entity;
import org.fluentness.model.Model;
import org.fluentness.register.ModelRegister;

import java.util.List;

public interface Repository<T extends Model> {

    Class<T> getModel();

    default Model getModelInstance() {
        return ModelRegister.getModelInstance(getModel().getCanonicalName());
    }

    default Model.Properties getModelPropertiesInstance() {
        return ModelRegister.getModelPropertiesInstance(getModel().getCanonicalName());
    }

    default List<Entity<T>> list() {
        return new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .execute()
                .entityList(getModel());
    }

    default Entity<T> findById(int id) {
        return (Entity<T>) new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(id))
                .execute()
                .entityList(getModel())
                .get(0);
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
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(entity.getId()))
                .execute()
                .resultSize();
    }
}
