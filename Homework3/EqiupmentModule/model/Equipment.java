package Homework2.EqiupmentModule.model;

import Homework1.StorageModule.model.Position;

public abstract class Equipment {

    public enum EquipmentState {
        IDLE, MOVING, BUSY, CHARGING, STOPPED, ERROR
    }

    private final String id;
    private Position position;
    private EquipmentState state;
    private double speed;
    private double batteryLevel;

    protected Equipment(String id, Position position, double speed, double batteryLevel) {
        this.id = id;
        this.position = position;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
        this.state = EquipmentState.IDLE;
    }

    // --- getters ---
    public String getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public EquipmentState getState() {
        return state;
    }

    public double getSpeed() {
        return speed;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setState(EquipmentState state) {
        this.state = state;
    }

    public abstract void charge(ChargingStation c);
}
