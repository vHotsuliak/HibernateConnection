package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleHibernateConnection {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateConnection");

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            for (Object user : entityManager.createQuery(" from  User").getResultList()) {
                System.out.println("args = [" + user + "]");
            }
        } finally {
            entityManagerFactory.close();
        }
    }
}
