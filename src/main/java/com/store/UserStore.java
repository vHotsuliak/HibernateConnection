package com.store;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class UserStore {

    private  final EntityManagerFactory managerFactory;

    public UserStore() {
        this.managerFactory = Persistence.createEntityManagerFactory("HibernateConnection");
    }

    @SuppressWarnings("JpaQlInspection")
    public Collection<User> value() {
        Session session = managerFactory.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        try {
            return session.createQuery("from Hibernate").list();
        } finally {
            session.close();
            transaction.commit();
        }
    }

    public void close() {
        this.managerFactory.close();
    }
}
