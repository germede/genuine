package org.fluentness.repository.crud;

import org.fluentness.Fluentness;
import org.fluentness.repository.Repository;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M extends CrudModel> implements Repository<M> {

    protected final Persistence persistence;
    protected final Logger logger;
    protected final Class<M> modelClass;

    protected CrudRepository() {
        this.persistence = Fluentness.getInstance(Persistence.class);
        this.logger = Fluentness.getInstance(Logger.class);
        Class<M> modelClass = null;
        try {
            modelClass = (Class<M>) Class.forName(getClass().getCanonicalName().replace("Repository", ""));
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        this.modelClass = modelClass;
    }

    @Override
    public M select(long id) {
        return persistence.retrieve(modelClass, id);
    }

    @Override
    public List<M> select() {
        return persistence.retrieve(modelClass);
    }

    @Override
    public List<M> selectByField(String field, Object value) {
        return persistence.retrieve(modelClass, field + " = " + "'" + value + "'");
    }

    @Override
    public int insert(M model) {
        return persistence.persist(model);
    }

    @Override
    public int update(M model) {
        return persistence.persist(model);
    }

    @Override
    public int delete(M model) {
        return persistence.remove(model);
    }


}
