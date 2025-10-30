package com.compact.hw1.equipment;

import com.compact.hw1.equipment.events.CompositeEventSink;
import com.compact.hw1.equipment.events.ConsoleEventSink;
import com.compact.hw1.equipment.events.EquipmentEventSink;
import com.compact.hw1.equipment.events.FileEventSink;

public class Main {
    public static void main(String[] args) {

        // Send events to console AND to files
        EquipmentEventSink sink = new CompositeEventSink(new ConsoleEventSink("System"), new FileEventSink());

        // === Create equipment instances ===
        AGV agv = new AGV("AGV01", new Position(2, 4, 0), 1.5, 88.5, 200.0, 500.0, "CS01");
        agv.setEventSink(sink);

        ChargingStation cs = new ChargingStation("CS01", new Position(0, 0, 0), 22.0);

        Task t = new Task("T001", "MoveItem");
        agv.performTask(t);
        agv.moveTo(new Position(3, 5, 0));
        agv.charge(cs);
        agv.stop();

        Shuttle shuttle = new Shuttle("SH01", new Position(1, 1, 0), 1.2, 70.0, 300.0);
        shuttle.setEventSink(sink);
        shuttle.moveTo(new Position(2, 2, 0));

        Crane crane = new Crane("CR01", new Position(0, 0, 1), 0.5, 95.0, 500.0);
        crane.setEventSink(sink);
        crane.performTask(new Task("T002", "Lift"));

        System.out.println("Logs written under ./logs/ (system/, equipment/, stations/)");
    }
}
