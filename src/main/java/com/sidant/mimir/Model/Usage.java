package com.sidant.mimir.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usage {

    private @Id @GeneratedValue @Column Long id;
    private @Column Long userId;
    private @Column String firstName;
    private @Column String prompt;

    public Usage() {

    }
    public Usage(Long userId, String firstName, String prompt) {
        this.userId = userId;
        this.firstName = firstName;
        this.prompt = prompt;
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

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
