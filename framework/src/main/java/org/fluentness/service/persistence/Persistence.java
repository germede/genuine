package org.fluentness.service.persistence;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.configuration.Key;

import java.util.List;

public interface Persistence extends ApplicationComponent {

    Key<String> JDBC_URL = new Key<>();
    Key<String> USERNAME = new Key<>();
    Key<String> PASSWORD = new Key<>();


    <M> List<M> select(Class<M> aClass, String sql);

    int persist(String sql);
}
