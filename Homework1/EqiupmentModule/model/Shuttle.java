package com.compact.hw1.equipment;

public class Shuttle extends Equipment {
    private final double maxLoadWeight;

    public Shuttle(String id, Position position, double speed, double batteryLevel, double maxLoadWeight) {
        super(id, "Shuttle", position, speed, batteryLevel);
        this.maxLoadWeight = maxLoadWeight;
    }

    public double getMaxLoadWeight() {
        return maxLoadWeight;
    }
}
