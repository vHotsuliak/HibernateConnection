package com;

import com.store.UserStore;


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
