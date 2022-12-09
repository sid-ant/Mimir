package com.sidant.mimir;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mimir.telegram")
public class ConfigurationMimir {
    private String key;

    public ConfigurationMimir(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
