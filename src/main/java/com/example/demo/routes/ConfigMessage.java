package com.example.demo.routes;

public class ConfigMessage {
    private String value;

    public ConfigMessage() {
    }

    public ConfigMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigMessage{" +
                "value='" + value + '\'' +
                '}';
    }
}
