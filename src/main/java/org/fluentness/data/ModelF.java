package org.fluentness.data;

import org.fluentness.common.logging.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface ModelF {
    
    default void create(){
        Transaction transaction = null;
        try {
            Session session = SessionFactoryWrapper.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(this);
            transaction.commit();
            Log.INSTANCE.debug("%s record inserted successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.INSTANCE.error(e);
        }
    }

    default void update(){
        Transaction transaction = null;
        try {
            Session session = SessionFactoryWrapper.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(this);
            transaction.commit();
            Log.INSTANCE.debug("%s record updated successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.INSTANCE.error(e);
        }
    }

    default void delete(){
        Transaction transaction = null;
        try {
            Session session = SessionFactoryWrapper.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(this);
            transaction.commit();
            Log.INSTANCE.debug("%s record deleted successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.INSTANCE.error(e);
        }
    }

}
