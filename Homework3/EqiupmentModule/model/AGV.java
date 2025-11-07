package Homework3.EqiupmentModule.model;

import Homework3.StorageModule.model.Position;
import Homework3.LogingModule.LoggingManager;
import Homework3.LogingModule.LogLevel;

public class AGV extends Equipment {
    private final double maxLoadWeight;
    private final double range; // abstract range units
    private String chargingStationId; // associated station
    private LoggingManager logger = LoggingManager.getInstance();

    public AGV(String id, Position position, double speed, double batteryLevel,
            double maxLoadWeight, double range, String chargingStationId) {
        super(id, position, speed, batteryLevel);
        this.maxLoadWeight = maxLoadWeight;
        this.range = range;
        this.chargingStationId = chargingStationId;
        logger.log(id + " created at position " + position, LogLevel.INFO, id);
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

    // needs to be changed later
    @Override
    public void charge(ChargingStation c) {
        if (c.startCharging(this)) {
            this.setState(EquipmentState.CHARGING);
        }
    }
}
