package org.fluentness.flow.repository;

import org.fluentness.base.generics.Component;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.logging.Log;
import org.fluentness.data.Data;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T> extends Component {

    private Map<String, String> queries;
    private Class<T> ec;
    private EntityManager em;

    Repository(Class<T> ec, KeyValuePair<String>[] queries) {
        this.queries = new HashMap<>();
        Arrays.stream(queries).forEach(query -> this.queries.put(query.getKey(), query.getValue()));
        this.ec = ec;
        this.em = Data.instance.getEntityManager();
    }

    public boolean isTransactionActive() {
        return em.getTransaction().isActive();
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }

    public void rollbackTransaction() {
        em.getTransaction().rollback();
    }

    public boolean create(T entity) {
        if (!em.contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            em.persist(entity);
            em.flush();
            commitTransaction();
            Log.instance.debug("%s record created successfully", ec.getSimpleName());
            return true;
        }
        Log.instance.debug("%s record already exists, cannot create", ec.getSimpleName());
        return false;
    }

    public boolean update(T entity) {
        if (em.contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            em.persist(entity);
            em.flush();
            commitTransaction();
            Log.instance.debug("%s record updated successfully", ec.getSimpleName());
            return true;
        }
        Log.instance.debug("%s record doesn't exists, cannot update", ec.getSimpleName());
        return false;
    }

    public boolean delete(T entity) {
        if (em.contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            em.remove(entity);
            em.flush();
            commitTransaction();
            Log.instance.debug("%s record deleted successfully", ec.getSimpleName());
            return true;
        }
        Log.instance.debug("%s record doesn't exists, cannot delete", ec.getSimpleName());
        return false;
    }

    public List<T> findAll() {
        Query query = em.createQuery("SELECT e FROM " + ec.getSimpleName() + " e");
        Log.instance.debug("Retrieving all %s records", ec.getSimpleName());
        return query.getResultList();
    }

    public T findById(int id) {
        Log.instance.debug("Retrieving %s record by ID %s", ec.getSimpleName(), id);
        return em.find(ec, id);
    }

    public List<T> find(String queryName, KeyValuePair<Object>... parameters) {
        String rawQuery = queries.get(queryName);
        Query query = em.createQuery(rawQuery);
        for (KeyValuePair<Object> parameter : parameters) {
            query.setParameter(parameter.getKey(), parameter.getValue());
        }
        Log.instance.debug("Retrieving %s records using custom query '%s'",
            ec.getSimpleName(),
            queryName
        );
        return (List<T>) query.getResultList();
    }


}
