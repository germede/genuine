package org.fluentness.repository;

    import com.j256.ormlite.dao.Dao;
    import com.j256.ormlite.dao.DaoManager;
    import org.fluentness.model.Model;
    import org.fluentness.service.log.Log;
    import org.fluentness.service.persistence.Persistence;

    import java.sql.SQLException;
    import java.util.List;

public abstract class AbstractCrudRepository<M extends Model> implements CrudRepository<M> {

    protected final Dao<M, Long> dao;
    protected final Log log;

    public AbstractCrudRepository(Persistence persistence, Log log, Class<M> modelClass) throws SQLException {
        this.log = log;
        this.dao = DaoManager.createDao(persistence.getConnectionSource(), modelClass);
    }

    @Override
    public M select(long id) {
        try {
            log.debug("Selecting %s by id %s", dao.getDataClass().getSimpleName(), id);
            return dao.queryForId(id);
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public List<M> selectAll() {
        try {
            log.debug("Selecting all %s", dao.getDataClass().getSimpleName());
            return dao.queryForAll();
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public List<M> selectByField(String field, Object value) {
        try {
            log.debug("Selecting %s by field %s equals '%s'", dao.getDataClass().getSimpleName(), field, value);
            return dao.queryForEq(field, value);
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public int insert(M entity) {
        try {
            log.debug("Inserting %s", entity);
            return dao.create(entity);
        } catch (SQLException e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public int update(M entity) {
        try {
            log.debug("Updating %s", entity);
            return dao.update(entity);
        } catch (SQLException e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public int delete(M entity) {
        try {
            log.debug("Deleging %s", entity);
            return dao.delete(entity);
        } catch (SQLException e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public int delete(long id) {
        try {
            log.debug("Deleting %s by id", dao.getDataClass().getSimpleName(), id);
            return dao.deleteById(id);
        } catch (SQLException e) {
            log.error(e);
        }
        return 0;
    }
}
