package com.store;


import com.model.User;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;

public class UserStore {

    private  final EntityManagerFactory entityManagerFactory;

    public UserStore() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("HibernateConnection");
    }

    @SuppressWarnings("JpaQlInspection")
    public Collection<User> value() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            return entityManager.createQuery("FROM  User").getResultList();
        } finally {
            transaction.commit();
        }
    }

    public void close() {
        this.entityManagerFactory.close();
    }
}
