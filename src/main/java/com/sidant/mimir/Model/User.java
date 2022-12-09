package com.sidant.mimir.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class User {

    private @Id @GeneratedValue Long id;
    private Integer user_id;

    private String firstName;

    private String username;
    private Boolean active;

    protected User() {
    }

    public User(Integer user_id, String firstName, String username, Boolean active) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.username = username;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", active=" + active +
                '}';
    }
}
