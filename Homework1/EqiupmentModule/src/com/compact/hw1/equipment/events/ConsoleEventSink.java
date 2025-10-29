package com.compact.hw1.equipment.events;

import com.compact.hw1.equipment.*;

public class ConsoleEventSink implements EquipmentEventSink {
    private final String systemName;

    public ConsoleEventSink(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public void onPerformTask(Equipment eq, Task task) {
        System.out.println("[LOG][" + systemName + "] " + eq.getId() + " performTask " + task.getId());
    }

    @Override
    public void onMove(Equipment eq, Position from, Position to, double newBattery) {
        System.out.println("[LOG][" + systemName + "] " + eq.getId() + " moved " + from + " -> " + to + " | battery="
                + newBattery);
    }

    @Override
    public void onCharge(Equipment eq, ChargingStation cs, double newBattery) {
        System.out.println(
                "[LOG][" + systemName + "] " + eq.getId() + " charged at " + cs.getId() + " | battery=" + newBattery);
    }

    @Override
    public void onStop(Equipment eq) {
        System.out.println("[LOG][" + systemName + "] " + eq.getId() + " stopped");
    }

    @Override
    public void onStateChange(Equipment eq, EquipmentState oldS, EquipmentState newS) {
        System.out.println("[LOG][" + systemName + "] " + eq.getId() + " state " + oldS + " -> " + newS);
    }
}
