package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.Setting;
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

    public static final Setting<String> DRIVER = new Setting<>("mysql");
    public static final Setting<String> HOST = new Setting<>("localhost");
    public static final Setting<Integer> PORT = new Setting<>(3306);
    public static final Setting<String> URL_PARAMETER_QUERY = new Setting<>("");
    public static final Setting<String> DATABASE = new Setting<>();
    public static final Setting<String> USERNAME = new Setting<>();
    public static final Setting<String> PASSWORD = new Setting<>();

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
    public <M extends Model> M retrieve(Class<M> modelClass, int id) {
        List<M> retrieve = retrieve(
            modelClass,
            "SELECT * FROM " + getTableName(modelClass) + " WHERE " + getIdName() + " = " + id
        );
        return retrieve.size() > 0 ? retrieve.get(0) : null;
    }

    @Override
    public <M extends Model> List<M> retrieve(Class<M> modelClass, Condition... conditions) {
        return retrieve(
            modelClass,
            conditions.length > 0 ?
                "SELECT * FROM " + getTableName(modelClass) + " WHERE " +
                    Arrays.stream(conditions).map(Condition::toString).collect(Collectors.joining(" AND ")) :
                "SELECT * FROM " + getTableName(modelClass)
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
                insert.append(i == 0 ? "'" : ", '").append(field.get(model)).append("'");
                update.append(i == 0 ? "" : ", ").append(field.getName()).append(" = '").append(field.get(model)).append("'");
            }

            String sql = "INSERT INTO " + getTableName(model) + "(" + into + ") " +
                "VALUES (" + insert + ") " +
                "ON DUPLICATE KEY UPDATE " + update;
            log.debug(sql);
            try (Statement statement = connection.createStatement()) {
                return statement.executeUpdate(sql);
            } catch (Exception e) {
                log.error(e);
            }
        } catch (IllegalAccessException e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public <M extends Model> int remove(Class<M> modelClass, int id) {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM " + getTableName(modelClass) + " WHERE " + getIdName() + " = " + id;
            log.debug(sql);
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            log.error(e);
        }
        return 0;
    }

    private <M extends Model> List<M> retrieve(Class<M> modelClass, String sql) {
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

    private <M extends Model> M instantiate(Class<M> modelClass, ResultSet resultSet) {
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
                } else if (type.equals(Integer.class) || type.equals(int.class)) {
                    preparedParameters[i] = resultSet.getInt(name);
                } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                    preparedParameters[i] = resultSet.getBoolean(name);
                } else if (type.equals(Date.class)) {
                    preparedParameters[i] = resultSet.getDate(name);
                }
            }
            M m = (M) constructor.newInstance(preparedParameters);
            m.setId(resultSet.getInt(getIdName()));
            return m;
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            log.error(e);
        }
        return null;
    }
}
