package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlPersistence implements Persistence {

    private final Logger logger;

    private final Connection connection;

    public SqlPersistence(Configurator configurator, Logger logger) throws SQLException {
        this.logger = logger;
        //            String myDriver = "org.gjt.mm.mysql.Driver";
//            Class.forName(myDriver);
        connection = DriverManager.getConnection(
            configurator.get(JDBC_URL),
            configurator.get(USERNAME),
            configurator.get(PASSWORD)
        );
    }

    @Override
    public <M extends Model> List<M> findAll(Class<M> model) {
        List<M> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + model.getSimpleName());

            Method[] setters = Model.getSetters(model);
            String[] fieldNames = Arrays.stream(setters)
                .map(method -> method.getName().replace("set","").toLowerCase())
                .toArray(String[]::new);

            while (resultSet.next()) {
                M instance = model.newInstance();
                for (int i = 0; i < setters.length; i++) {
                    Method setter = setters[i];
                    Class<?> type = setter.getParameterTypes()[0];
                    Object value = null;
                    if (type.equals(String.class)) {
                        value = resultSet.getString(fieldNames[i]);
                    } else if (type.equals(Integer.class) || type.equals(int.class)) {
                        value = resultSet.getInt(fieldNames[i]);
                    } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                        value = resultSet.getBoolean(fieldNames[i]);
                    } else if (type.equals(Date.class)) {
                        value = resultSet.getDate(fieldNames[i]);
                    }
                    setter.invoke(instance, value);
                }

                result.add(instance);
            }
            statement.close();
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }

//    @Override
//    public boolean persist(Object model) {
//        if (!entityManager.contains(model)) {
//            if (!isActive()) {
//                begin();
//            }
//            entityManager.persist(model);
//            entityManager.flush();
//            commit();
//            logger.debug("%s record created successfully", model.getClass().getSimpleName());
//            return true;
//        }
//        logger.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
//        return false;
//    }
//
//    @Override
//    public boolean remove(Object model) {
//        if (entityManager.contains(model)) {
//            if (!isActive()) {
//                begin();
//            }
//            entityManager.remove(model);
//            entityManager.flush();
//            commit();
//            logger.debug("%s record deleted successfully", model.getClass().getSimpleName());
//            return true;
//        }
//        logger.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
//        return false;
//    }
//
//    @Override
//    public <M> M find(Class<M> modelClass, int id) {

//
//        logger.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
//        return entityManager.find(modelClass, id);
//    }
//
//    @Override
//    public Query query(String query) {
//        return entityManager.createQuery(query);
//    }
//
//    @Override
//    public boolean isActive() {
//        return entityManager.getTransaction().isActive();
//    }
//
//    @Override
//    public void begin() {
//        entityManager.getTransaction().begin();
//    }
//
//    @Override
//    public void commit() {
//        entityManager.getTransaction().commit();
//    }
//
//    @Override
//    public void rollback() {
//        entityManager.getTransaction().rollback();
//    }

}























