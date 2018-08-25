package com;

import com.store.UserStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleHibernateConnection {
    public static void main(String[] args) {
        final UserStore userStore = new UserStore();
        try {
            for (Object user : userStore.value()) {
                System.out.println("args = [" + user + "]");
            }
        } finally {
            userStore.close();
        }
    }
}
