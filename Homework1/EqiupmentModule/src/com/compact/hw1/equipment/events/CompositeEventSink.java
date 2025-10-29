package com.compact.hw1.equipment.events;

import com.compact.hw1.equipment.*;

import java.util.Arrays;
import java.util.List;

public class CompositeEventSink implements EquipmentEventSink {
    private final List<EquipmentEventSink> sinks;

    public CompositeEventSink(EquipmentEventSink... sinks) {
        this.sinks = Arrays.asList(sinks);
    }

    @Override
    public void onPerformTask(Equipment eq, Task task) {
        for (EquipmentEventSink s : sinks)
            s.onPerformTask(eq, task);
    }

    @Override
    public void onMove(Equipment eq, Position from, Position to, double newBattery) {
        for (EquipmentEventSink s : sinks)
            s.onMove(eq, from, to, newBattery);
    }

    @Override
    public void onCharge(Equipment eq, ChargingStation cs, double newBattery) {
        for (EquipmentEventSink s : sinks)
            s.onCharge(eq, cs, newBattery);
    }

    @Override
    public void onStop(Equipment eq) {
        for (EquipmentEventSink s : sinks)
            s.onStop(eq);
    }

    @Override
    public void onStateChange(Equipment eq, EquipmentState oldState, EquipmentState newState) {
        for (EquipmentEventSink s : sinks)
            s.onStateChange(eq, oldState, newState);
    }
}
