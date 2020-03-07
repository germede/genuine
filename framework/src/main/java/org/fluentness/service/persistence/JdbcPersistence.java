package org.fluentness.service.persistence;

import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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
    public <M> List<M> select(Class<M> model, String sql) {
        List<M> result = new LinkedList<>();
        Field[] fields = model.getDeclaredFields();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                M instance = model.newInstance();
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

    @Override
    public int persist(String sql) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            logger.error(e);
        }
        return 0;
    }

}
