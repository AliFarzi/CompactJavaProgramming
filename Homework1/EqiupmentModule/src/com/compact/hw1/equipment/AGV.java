package com.compact.hw1.equipment;

public class AGV extends Equipment {
    private final double maxLoadWeight;
    private final double range; // abstract range units
    private String chargingStationId; // associated station

    public AGV(String id, Position position, double speed, double batteryLevel,
            double maxLoadWeight, double range, String chargingStationId) {
        super(id, "AGV", position, speed, batteryLevel);
        this.maxLoadWeight = maxLoadWeight;
        this.range = range;
        this.chargingStationId = chargingStationId;
    }

    public double getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public double getRange() {
        return range;
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String id) {
        this.chargingStationId = id;
    }
}
