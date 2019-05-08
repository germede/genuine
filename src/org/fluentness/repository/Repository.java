package org.fluentness.repository;

import org.fluentness.database.SqlConstraint;
import org.fluentness.database.SqlQuery;
import org.fluentness.database.SqlResult;
import org.fluentness.logging.Logger;
import org.fluentness.entity.Entity;
import org.fluentness.model.Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Repository<T extends Model> {

    default Model getModel() {
        try {
            return (Model) this.getClass().getGenericSuperclass().getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    default List<Entity<T>> resultSetToEntityList(ResultSet resultSet) {
        List<Entity<T>> entityList = new ArrayList<>();
        try {
            ResultSetMetaData meta = resultSet.getMetaData();
            int numColumns = meta.getColumnCount();
            while (resultSet.next()) {
                Entity entity = new Entity();
                for (int i = 1; i <= numColumns; ++i) {
                    String name = meta.getColumnName(i);
                    Object value = resultSet.getObject(i);
                    entity.set(name, value);
                }
                entityList.add(entity);
            }
        } catch (SQLException e) {
            Logger.error(Repository.class, e);
        }
        return entityList;
    }

    default List<Entity<T>> list() {
        SqlResult result = new SqlQuery()
                .select()
                .from(getModel().getTable())
                .execute();
        return resultSetToEntityList(result.set);
    }

    default Entity<T> find(Object primaryKey) {
        SqlResult result = new SqlQuery()
                .select()
                .from(getModel().getTable())
                .where(new SqlConstraint(getModel().getPrimaryKey()).isEqualTo(primaryKey))
                .execute();
        return resultSetToEntityList(result.set).get(0);
    }

    default int create(Entity<T> entity) {
        SqlResult result = new SqlQuery()
                .insert()
                .into(getModel().getTable())
                .values(entity.getAll())
                .execute();
        return result.size;
    }

    default int update(Entity<T> entity) {
        SqlResult result = new SqlQuery()
                .update(getModel().getTable())
                .set(entity.getAll())
                .execute();
        return result.size;
    }

    default int delete(Entity<T> entity) {
        SqlResult result = new SqlQuery()
                .delete()
                .from(getModel().getTable())
                .where(new SqlConstraint(getModel().getPrimaryKey()).isEqualTo(entity.getPrimaryKey()))
                .execute();
        return result.size;
    }
}
