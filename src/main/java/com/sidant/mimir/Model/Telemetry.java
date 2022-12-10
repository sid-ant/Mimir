package com.sidant.mimir.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Telemetry {

    private @Id @GeneratedValue @Column Long id;
    private @Column(unique = true) Long userId;
    private @Column Long textCount;
    private @Column Long imageCount;

    public Telemetry() {

    }

    public Telemetry(Long userId, Long textCount, Long imageCount) {
        this.userId = userId;
        this.textCount = textCount;
        this.imageCount = imageCount;
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

    public Long getTextCount() {
        return textCount;
    }

    public void setTextCount(Long textCount) {
        this.textCount = textCount;
    }

    public Long getImageCount() {
        return imageCount;
    }

    public void setImageCount(Long imageCount) {
        this.imageCount = imageCount;
    }
}
