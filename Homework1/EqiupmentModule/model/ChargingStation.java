package Homework1.EqiupmentModule.model;

import Homework1.StorageModule.model.Position;

public class ChargingStation {
    private final String id;
    private final Position position;
    private final double powerKW;
    private boolean occupied;
    private String equipmentId;

    public ChargingStation(String id, Position position, double powerKW) {
        this.id = id;
        this.position = position;
        this.powerKW = powerKW;
        this.occupied = false;
        this.equipmentId = null;
    }

    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public double getPowerKW() {
        return powerKW;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public boolean startCharging(Equipment e) {
        if (occupied)
            return false;
        occupied = true;
        equipmentId = e.getId();
        return true;
    }

    public void stopCharging() {
        occupied = false;
        equipmentId = null;
    }
}
