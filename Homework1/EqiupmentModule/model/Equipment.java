package com.compact.hw1.equipment;

import com.compact.hw1.equipment.events.EquipmentEventSink;

public abstract class Equipment {
    private final String id;
    private final String type;
    private Position position;
    private EquipmentState state;
    private double speed;
    private double batteryLevel;
    private String currentTaskId;

    // === new line added ===
    private EquipmentEventSink eventSink = EquipmentEventSink.NOOP;

    protected Equipment(String id, String type, Position position, double speed, double batteryLevel) {
        this.id = id;
        this.type = type;
        this.position = position;
        this.speed = speed;
        this.batteryLevel = batteryLevel;
        this.state = EquipmentState.IDLE;
        this.currentTaskId = null;
    }

    // === setter for the sink ===
    public void setEventSink(EquipmentEventSink sink) {
        this.eventSink = (sink == null) ? EquipmentEventSink.NOOP : sink;
    }

    // --- getters ---
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public String getCurrentTaskId() {
        return currentTaskId;
    }

    // --- core behaviors ---
    public void performTask(Task t) {
        currentTaskId = t.getId();
        EquipmentState old = state;
        state = EquipmentState.BUSY;
        eventSink.onStateChange(this, old, state);

        System.out.println("[EQUIP] " + id + " performing task " + t.getId() + " (" + t.getType() + ")");
        eventSink.onPerformTask(this, t);
    }

    public void moveTo(Position p) {
        if (p == null)
            throw new IllegalArgumentException("Position cannot be null");

        EquipmentState old = state;
        state = EquipmentState.MOVING;
        eventSink.onStateChange(this, old, state);

        Position from = position;
        double distance = position.manhattanDistanceTo(p);
        batteryLevel = Math.max(0, batteryLevel - distance * 0.2);
        position = p;

        System.out.println("[EQUIP] " + id + " moved to " + p + " | battery=" + batteryLevel);
        eventSink.onMove(this, from, p, batteryLevel);

        old = state;
        state = (currentTaskId == null) ? EquipmentState.IDLE : EquipmentState.BUSY;
        eventSink.onStateChange(this, old, state);
    }

    public void charge(ChargingStation c) {
        if (c == null)
            throw new IllegalArgumentException("ChargingStation cannot be null");

        if (c.startCharging(this)) {
            EquipmentState old = state;
            state = EquipmentState.CHARGING;
            eventSink.onStateChange(this, old, state);

            batteryLevel = 100.0;
            System.out.println("[EQUIP] " + id + " charged at station " + c.getId());
            eventSink.onCharge(this, c, batteryLevel);

            c.stopCharging();
            old = state;
            state = EquipmentState.IDLE;
            eventSink.onStateChange(this, old, state);
        } else {
            System.out.println("[EQUIP] " + id + " cannot charge; station occupied");
        }
    }

    public void stop() {
        EquipmentState old = state;
        state = EquipmentState.STOPPED;
        System.out.println("[EQUIP] " + id + " stopped");
        eventSink.onStop(this);
        eventSink.onStateChange(this, old, state);
    }
}
