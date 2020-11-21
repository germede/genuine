package org.fluentness.service.persistence;

import org.fluentness.model.PersistableModel;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcPersistence implements Persistence {

    private final Log log;

    private Connection connection;

    public JdbcPersistence(Configuration configuration, Log log) throws SQLException {
        this.log = log;
        if (configuration.has(DATABASE) && configuration.has(USERNAME) && configuration.has(PASSWORD)) {
            String url = "jdbc:" + configuration.get(DRIVER) + "://" + configuration.get(HOST) + ":" + configuration.get(PORT) + "/" + configuration.get(DATABASE) + configuration.get(URL_PARAMETER_QUERY);
            connection = DriverManager.getConnection(
                url,
                configuration.get(USERNAME),
                configuration.get(PASSWORD)
            );
        } else {
            log.warning("No database connection initialized due to lacking configuration");
        }
    }

    @Override
    public <M extends PersistableModel> M retrieve(Class<M> modelClass, long id) {
        List<M> retrieve = retrieve(
            modelClass,
            "SELECT * FROM " + getPersistenceNameFor(modelClass) + " WHERE " + PersistableModel.ID_FIELD_NAME + " = " + id
        );
        return retrieve.size() > 0 ? retrieve.get(0) : null;
    }

    @Override
    public <M extends PersistableModel> List<M> retrieve(Class<M> modelClass, String... conditions) {
        return retrieve(
            modelClass,
            conditions.length > 0 ?
                "SELECT * FROM " + getPersistenceNameFor(modelClass) + " WHERE " + String.join(" AND ", conditions) :
                "SELECT * FROM " + getPersistenceNameFor(modelClass)
        );
    }

    @Override
    public int persist(PersistableModel persistableModel) {
        // pre-build sql
        String into = Arrays.stream(persistableModel.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining(","));
        StringBuilder update = new StringBuilder();
        StringBuilder insert = new StringBuilder();
        Field[] declaredFields = persistableModel.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                insert.append(i == 0 ? "'" : ", '").append(field.get(persistableModel)).append("'");
                update.append(i == 0 ? "" : ", ").append(field.getName()).append(" = '").append(field.get(persistableModel)).append("'");
            }

            String sql = "INSERT INTO " + getPersistenceNameFor(persistableModel.getClass()) + "(" + into + ") " +
                "VALUES (" + insert + ") " +
                "ON DUPLICATE KEY UPDATE " + update;
            log.debug(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public <M extends PersistableModel> int remove(Class<M> modelClass, long id) {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM " + getPersistenceNameFor(modelClass) + " WHERE " + PersistableModel.ID_FIELD_NAME + " = " + id;
            log.debug(sql);
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public int remove(PersistableModel persistableModel) {
        try {
            return remove(persistableModel.getClass(), (Long) persistableModel.getClass().getField(PersistableModel.ID_FIELD_NAME).get(persistableModel));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.error(e);
        }
        return 0;
    }

    private <M extends PersistableModel> List<M> retrieve(Class<M> modelClass, String sql) {
        List<M> result = new LinkedList<>();
        ResultSet resultSet = null;
        try {
            log.debug(sql);
            resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                result.add(instantiate(modelClass, resultSet));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return result;
    }

    private <M extends PersistableModel> M instantiate(Class<M> modelClass, ResultSet resultSet) {
        try {
            Constructor constructor = modelClass.getConstructors()[0];
            Parameter[] parameters = constructor.getParameters();
            Object[] preparedParameters = new Object[constructor.getParameterCount()];
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String name = parameter.getName();
                Class<?> type = parameter.getType();
                if (type.equals(String.class)) {
                    preparedParameters[i] = resultSet.getString(name);
                } else if (int.class.isAssignableFrom(type)) {
                    preparedParameters[i] = resultSet.getInt(name);
                } else if (float.class.isAssignableFrom(type)) {
                    preparedParameters[i] = resultSet.getFloat(name);
                } else if (boolean.class.isAssignableFrom(type)) {
                    preparedParameters[i] = resultSet.getBoolean(name);
                } else if (Date.class.isAssignableFrom(type)) {
                    preparedParameters[i] = resultSet.getDate(name);
                }
            }
            M model = (M) constructor.newInstance(preparedParameters);
            Field field = modelClass.getDeclaredField(PersistableModel.ID_FIELD_NAME);
            field.setAccessible(true);
            field.set(model, resultSet.getLong(PersistableModel.ID_FIELD_NAME));
            return model;
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            log.error(e);
        }
        return null;
    }
}
