package com.compact.hw1.equipment.events;

import com.compact.hw1.equipment.*;

public interface EquipmentEventSink {
    // A NOOP sink so you never need null checks
    EquipmentEventSink NOOP = new EquipmentEventSink() {
    };

    default void onPerformTask(Equipment eq, Task task) {
    }

    default void onMove(Equipment eq, Position from, Position to, double newBattery) {
    }

    default void onCharge(Equipment eq, ChargingStation cs, double newBattery) {
    }

    default void onStop(Equipment eq) {
    }

    default void onStateChange(Equipment eq, EquipmentState oldState, EquipmentState newState) {
    }
}
