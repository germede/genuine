package org.fluentness.service.persistence;

import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class OpenJpaPersistence implements Persistence {

    private final Logger logger;
    protected EntityManager entityManager;

    public OpenJpaPersistence(Configurator configurator, Logger logger) {
        this.logger = logger;

        String myUrl = "jdbc:mysql://localhost:3306/party";
        Connection conn = DriverManager.getConnection(myUrl, "party", "party");


    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean persist(Object model) {
        if (!entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.persist(model);
            entityManager.flush();
            commit();
            logger.debug("%s record created successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean remove(Object model) {
        if (entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.remove(model);
            entityManager.flush();
            commit();
            logger.debug("%s record deleted successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public <M> M find(Class<M> modelClass, int id) {


        try {
            // create our mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            Class.forName(myDriver);







            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dateCreated = rs.getDate("date_created");
                boolean isAdmin = rs.getBoolean("is_admin");
                int numPoints = rs.getInt("num_points");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }


        logger.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
        return entityManager.find(modelClass, id);
    }

    @Override
    public Query query(String query) {
        return entityManager.createQuery(query);
    }

    @Override
    public boolean isActive() {
        return entityManager.getTransaction().isActive();
    }

    @Override
    public void begin() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollback() {
        entityManager.getTransaction().rollback();
    }

}























