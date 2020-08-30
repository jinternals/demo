package com.example.demo.routes;

public class CaptivaMessage {
    private String value;

    public CaptivaMessage() {
    }

    public CaptivaMessage(String value) {
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
        return "Message{" +
                "value='" + value + '\'' +
                '}';
    }
}
