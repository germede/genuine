package org.fluentness.service.persistence;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.logger.Logger;
import org.fluentness.repository.Model;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SqlPersistence implements Persistence {

    private final Injector injector;
    private final Logger logger;

    private Connection connection;

    public SqlPersistence(Injector injector, Configuration configuration, Logger logger) throws SQLException {
        this.injector = injector;
        this.logger = logger;
        if (configuration.has(JDBC_URL) && configuration.has(USERNAME) && configuration.has(PASSWORD)) {
            connection = DriverManager.getConnection(
                configuration.get(JDBC_URL),
                configuration.get(USERNAME),
                configuration.get(PASSWORD)
            );
        }
    }

    @Override
    public <M extends Model> List<M> select(Class<M> model, String query, Object... parameters) {
        List<M> result = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            for (Object parameter : parameters) {
                query = query.replace("?", parameter.toString());
            }
            ResultSet resultSet = statement.executeQuery(query);
            Method[] setters = injector.getInstance(model).getSetters();
            String[] columns = methodsToColumns(setters);

            // call setters for each result
            while (resultSet.next()) {
                M instance = model.newInstance();
                for (int i = 0; i < setters.length; i++) {
                    Method setter = setters[i];
                    Class<?> type = setter.getParameterTypes()[0];
                    Object value = null;
                    if (type.equals(String.class)) {
                        value = resultSet.getString(columns[i]);
                    } else if (type.equals(Integer.class) || type.equals(int.class)) {
                        value = resultSet.getInt(columns[i]);
                    } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                        value = resultSet.getBoolean(columns[i]);
                    } else if (type.equals(Date.class)) {
                        value = resultSet.getDate(columns[i]);
                    }
                    setter.invoke(instance, value);
                }
                result.add(instance);
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }

    @Override
    public <M extends Model> boolean insert(M model) {
        try (Statement statement = connection.createStatement()) {
            Method[] getters = model.getGetters();
            String[] columns = methodsToColumns(getters);
            String[] hiddenValues = new String[getters.length];
            String[] values = new String[getters.length];
            for (int i = 0; i < getters.length; i++) {
                hiddenValues[i] = "?";
                values[i] = getters[i].invoke(model).toString();
            }

            return statement.executeUpdate(
                "INSERT INTO " + model.getClass().getSimpleName() +
                    " (" + String.join(",", columns) +
                    ") VALUES (" + String.join(",", hiddenValues) + ")", values
            ) > 0;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public <M extends Model> boolean update(M model) {
        try (Statement statement = connection.createStatement()) {
            Method[] getters = model.getGetters();
            String[] columns = methodsToColumns(getters);
            String[] hiddenValues = new String[getters.length];
            String[] values = new String[getters.length + 1];
            for (int i = 0; i < getters.length; i++) {
                hiddenValues[i] = "?";
                values[i] = columns[i] + " = " + getters[i].invoke(model);
            }
            values[getters.length] = String.valueOf(model.getId());

            return statement.executeUpdate(
                "UPDATE " + model.getClass().getSimpleName() +
                    " SET " + String.join(",", hiddenValues) +
                    " WHERE id = ?", values
            ) > 0;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public <M extends Model> boolean delete(M model) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(
                "DELETE FROM " + model.getClass().getSimpleName() + " WHERE id = ?", new int[]{model.getId()}
            ) > 0;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    private String[] methodsToColumns(Method[] methods) {
        String[] columns = new String[methods.length];
        for (int i = 0; i < methods.length; i++) {
            columns[i] = methodToColumn(methods[i]);
        }
        return columns;
    }

    private String methodToColumn(Method method) {
        String name = method.getName();
        return
            name.startsWith("get") ? name.replace("get", "").toLowerCase() :
                name.startsWith("is") ? name.replace("is", "").toLowerCase() :
                    name.startsWith("set") ? name.replace("set", "").toLowerCase() :
                        name;
    }
}
