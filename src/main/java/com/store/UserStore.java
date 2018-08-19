package com.store;

import java.util.Collection;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserStore {

    private  final SessionFactory sessionFactory;

    public UserStore() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @SuppressWarnings("JpaQlInspection")
    public Collection<User> value() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            return session.createQuery("from Hibernate").list();
        } finally {
            session.close();
            transaction.commit();
        }
    }
}
