package com.compact.hw1.equipment;

public class Crane extends Equipment {
    private final double maxLoadWeight;

    public Crane(String id, Position position, double speed, double batteryLevel, double maxLoadWeight) {
        super(id, "Crane", position, speed, batteryLevel);
        this.maxLoadWeight = maxLoadWeight;
    }

    public double getMaxLoadWeight() {
        return maxLoadWeight;
    }
}
