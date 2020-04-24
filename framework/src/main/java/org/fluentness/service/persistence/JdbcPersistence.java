package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcPersistence implements Persistence {

    private final Logger logger;

    private Connection connection;

    public JdbcPersistence(Configurator configurator, Logger logger) throws SQLException {
        this.logger = logger;
        if (configurator.has(JDBC_URL) && configurator.has(USERNAME) && configurator.has(PASSWORD)) {
            connection = DriverManager.getConnection(
                configurator.get(JDBC_URL),
                configurator.get(USERNAME),
                configurator.get(PASSWORD)
            );
        } else {
            logger.warning("No database connection initialized due to lacking configuration");
        }
    }

    @Override
    public <M extends Model> M retrieve(Class<M> modelClass, long id) {
        List<M> retrieve = retrieve(
            modelClass,
            "SELECT * FROM " + modelClass.getSimpleName().toLowerCase() + " WHERE id = " + id
        );
        return retrieve.size() > 0 ? retrieve.get(0) : null;
    }

    @Override
    public <M extends Model> List<M> retrieve(Class<M> modelClass, String... conditions) {
        return retrieve(
            modelClass,
            conditions.length > 0 ?
                "SELECT * FROM " + modelClass.getSimpleName().toLowerCase() + " WHERE " + String.join(" AND ", conditions) :
                "SELECT * FROM " + modelClass.getSimpleName().toLowerCase()
        );
    }

    @Override
    public int persist(Model model) {
        // pre-build sql
        String into = Arrays.stream(model.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining(","));
        StringBuilder update = new StringBuilder();
        StringBuilder insert = new StringBuilder();
        Field[] declaredFields = model.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                insert.append(i == 0 ? "" : ", ").append(field.get(model));
                update.append(i == 0 ? "" : ", ").append(field.getName()).append(" = ").append(field.get(model));
            }

            String sql = "INSERT INTO " + model.getTableName() + "(" + into + ") " +
                "VALUES (" + insert + ") " +
                "ON DUPLICATE KEY UPDATE " + update;

            try (Statement statement = connection.createStatement()) {
                return statement.executeUpdate(sql);
            } catch (Exception e) {
                logger.error(e);
            }
        } catch (IllegalAccessException e) {
            logger.error(e);
        }
        return 0;
    }

    @Override
    public int remove(Model model) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate("DELETE FROM " + model.getTableName() + " WHERE id = " + model.getId());
        } catch (Exception e) {
            logger.error(e);
        }
        return 0;
    }

    private <M extends Model> List<M> retrieve(Class<M> modelClass, String sql) {
        List<M> result = new LinkedList<>();
        Field[] fields = modelClass.getDeclaredFields();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                M instance = modelClass.newInstance();
                for (Field field : fields) {
                    String name = field.getName();
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    Object value = null;
                    if (type.equals(String.class)) {
                        value = resultSet.getString(name);
                    } else if (type.equals(Integer.class) || type.equals(int.class)) {
                        value = resultSet.getInt(name);
                    } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                        value = resultSet.getBoolean(name);
                    } else if (type.equals(Date.class)) {
                        value = resultSet.getDate(name);
                    }
                    field.set(instance, value);
                }
                result.add(instance);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return result;
    }
}
