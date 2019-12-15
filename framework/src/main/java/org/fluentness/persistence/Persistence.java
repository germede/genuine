package org.fluentness.persistence;

import org.fluentness.ApplicationComponent;
import org.fluentness.configuration.Key;
import org.fluentness.model.Model;

import java.util.List;

public interface Persistence extends ApplicationComponent {

    Key<String> JDBC_URL = new Key<>();
    Key<String> USERNAME = new Key<>();
    Key<String> PASSWORD = new Key<>();

    <M extends Model> List<M> select(Class<M> mClass, String query, Object... parameters);

    <M extends Model> boolean insert(M model);

    <M extends Model> boolean update(M model);

    <M extends Model> boolean delete(M model);

}
