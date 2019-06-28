package org.fluentness.data;

import org.fluentness.base.logging.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface Model {

    default void create(){
        Transaction transaction = null;
        try {
            Session session = Data.call.openSession();
            transaction = session.beginTransaction();
            session.save(this);
            transaction.commit();
            Log.call.debug("%s record inserted successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.call.error(e);
        }
    }

    default void update(){
        Transaction transaction = null;
        try {
            Session session = Data.call.openSession();
            transaction = session.beginTransaction();
            session.update(this);
            transaction.commit();
            Log.call.debug("%s record updated successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.call.error(e);
        }
    }

    default void delete(){
        Transaction transaction = null;
        try {
            Session session = Data.call.openSession();
            transaction = session.beginTransaction();
            session.delete(this);
            transaction.commit();
            Log.call.debug("%s record deleted successfully", this.getClass().getSimpleName());
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Log.call.error(e);
        }
    }

}
