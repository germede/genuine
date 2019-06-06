package org.fluentness.repository;

import org.fluentness.entity.Entity;
import org.fluentness.model.Model;
import org.fluentness.register.ModelRegister;

import java.util.List;

public interface Repository<T extends Model> {

    Class<T> getModelClass();

    default Model getModelInstance() {
        return ModelRegister.getModelInstance(getModelClass().getCanonicalName());
    }

    default Model.Properties getModelPropertiesInstance() {
        return ModelRegister.getModelPropertiesInstance(getModelClass().getCanonicalName());
    }

    default List<Entity<T>> list() {

//        return select(
//                columns -> "*",
//                from -> getModelInstance().getTable()
//        );

        return new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .execute()
                .entityList(getModelClass());
    }

    default Entity<T> findById(int id) {
//        return select(
//                columns -> "*"
//
//        )

        return (Entity<T>) new SqlQuery()
                .select()
                .from(getModelInstance().getTable())
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(id))
                .execute()
                .entityList(getModelClass())
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

//        return delete(
//                from -> getModelInstance().getTable(),
//                where ->
//        )

        return new SqlQuery()
                .delete()
                .from(getModelInstance().getTable())
                .where(new SqlConstraint(getModelInstance().getPrimaryKey()).isEqualTo(entity.getId()))
                .execute()
                .resultSize();
    }
}
