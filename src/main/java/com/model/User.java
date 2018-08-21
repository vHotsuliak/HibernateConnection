package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Hibernate")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "native")
    private int id;

    @Column (name = "user_nic")
    private String userName;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}
