package com.compact.hw1.equipment;

public class Task {
    private final String id;
    private final String type;

    public Task(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
