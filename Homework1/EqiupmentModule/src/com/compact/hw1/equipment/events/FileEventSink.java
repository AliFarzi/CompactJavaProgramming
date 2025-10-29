package com.compact.hw1.equipment.events;

import com.compact.hw1.equipment.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FileEventSink implements EquipmentEventSink {
    private final LocalDate day;

    public FileEventSink() {
        this.day = LocalDate.now();
    }

    public FileEventSink(LocalDate fixedDay) {
        this.day = fixedDay;
    }

    // --- helpers ---
    private void appendLine(java.io.File file, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("[LOG][ERROR] " + e.getMessage());
        }
    }

    private String ts() {
        return LocalDateTime.now().toString();
    }

    private void writeSystem(String msg) {
        appendLine(LogPaths.systemLogFile(day), msg);
    }

    private void writeEquipment(String equipmentId, String msg) {
        appendLine(LogPaths.equipmentLogFile(equipmentId, day), msg);
    }

    // --- event handlers ---
    @Override
    public void onPerformTask(Equipment eq, Task task) {
        String line = ts() + " | " + eq.getId() + " | PERFORM_TASK | task=" + task.getId() + " type=" + task.getType();
        writeSystem(line);
        writeEquipment(eq.getId(), line);
    }

    @Override
    public void onMove(Equipment eq, Position from, Position to, double newBattery) {
        String line = ts() + " | " + eq.getId() + " | MOVE | " + from + " -> " + to + " | battery=" + newBattery;
        writeSystem(line);
        writeEquipment(eq.getId(), line);
    }

    @Override
    public void onCharge(Equipment eq, ChargingStation cs, double newBattery) {
        String line = ts() + " | " + eq.getId() + " | CHARGE | station=" + cs.getId() + " | battery=" + newBattery;
        writeSystem(line);
        writeEquipment(eq.getId(), line);
        // Optional: per-station file too
        appendLine(LogPaths.stationLogFile(cs.getId(), day), line);
    }

    @Override
    public void onStop(Equipment eq) {
        String line = ts() + " | " + eq.getId() + " | STOP";
        writeSystem(line);
        writeEquipment(eq.getId(), line);
    }

    @Override
    public void onStateChange(Equipment eq, EquipmentState oldS, EquipmentState newS) {
        String line = ts() + " | " + eq.getId() + " | STATE | " + oldS + " -> " + newS;
        writeSystem(line);
        writeEquipment(eq.getId(), line);
    }
}
