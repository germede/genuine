package org.fluentness.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum SessionFactoryWrapper {

    INSTANCE;

    static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
