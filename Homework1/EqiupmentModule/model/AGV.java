package Homework1.EqiupmentModule.model;

import Homework1.StorageModule.model.Position;

public class AGV extends Equipment {
    private final double maxLoadWeight;
    private final double range; // abstract range units
    private String chargingStationId; // associated station

    public AGV(String id, Position position, double speed, double batteryLevel,
            double maxLoadWeight, double range, String chargingStationId) {
        super(id, position, speed, batteryLevel);
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

    //needs to be changed later
    @Override
    public void charge(ChargingStation c) {
        if (c.startCharging(this)) {
            this.setState(EquipmentState.CHARGING);
        }
    }
}
