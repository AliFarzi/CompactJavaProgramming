package com.compact.hw1.equipment.events;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

final class LogPaths {
    private static final DateTimeFormatter DAY = DateTimeFormatter.ofPattern("yyyyMMdd");

    static File systemLogFile(LocalDate day) {
        File dir = new File("logs/system");
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, "system_" + DAY.format(day) + ".log");
    }

    static File equipmentLogFile(String equipmentId, LocalDate day) {
        File dir = new File("logs/equipment/" + equipmentId);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, equipmentId + "_" + DAY.format(day) + ".log");
    }

    static File stationLogFile(String stationId, LocalDate day) {
        File dir = new File("logs/stations/" + stationId);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, stationId + "_" + DAY.format(day) + ".log");
    }

    private LogPaths() {
    }
}
