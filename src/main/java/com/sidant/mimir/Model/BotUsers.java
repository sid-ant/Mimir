package com.sidant.mimir.Model;

import jakarta.persistence.*;

@Entity
public class BotUsers {

    private @Id @GeneratedValue @Column Long id;
    private @Column(unique = true)Long userId;
    private @Column String firstName;

    private @Column String username;
    private @Column Boolean active;

    public BotUsers() {

    }

    public BotUsers(Long userId, String firstName, String username, Boolean active) {
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", active=" + active +
                '}';
    }
}
