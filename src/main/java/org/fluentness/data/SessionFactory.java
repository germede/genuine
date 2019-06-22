package org.fluentness.data;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public enum SessionFactory {
    INSTANCE;

    private final org.hibernate.SessionFactory sessionFactory
        = new Configuration().configure().buildSessionFactory();

    public Session openSession() {
        return sessionFactory.openSession();
    }
}
