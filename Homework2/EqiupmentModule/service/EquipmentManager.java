package Homework2.EqiupmentModule.service;

import java.util.ArrayList;
import java.util.List;
import Homework1.EqiupmentModule.model.*;
import Homework1.LogingModule.LoggingManager;
import Homework1.LogingModule.LogLevel;

public class EquipmentManager {

    private List<Equipment> equipmentList = new ArrayList<>();
    private LoggingManager logger = LoggingManager.getInstance();

    public EquipmentManager() {
        logger.log("EquipmentManager initialized", LogLevel.INFO, "EquipmentManager");
    }

    public void addEquipment(Equipment e) {
        if (e != null && !equipmentList.contains(e)) {
            equipmentList.add(e);
        }
    }

    public List<Equipment> getAvailableEquipment() {
        List<Equipment> available = new ArrayList<>();
        for (Equipment e : equipmentList) {
            if (e.getState() == Equipment.EquipmentState.IDLE) {
                available.add(e);
            }
        }
        return available;
    }

    public void assignEquipment(Equipment e) {
        if (e != null && e.getState() == Equipment.EquipmentState.IDLE) {
            e.setState(Equipment.EquipmentState.BUSY);
            System.out.println("Assigned " + e.getId());
        } else {
            System.out.println("Cannot assign " + (e != null ? e.getId() : "null") + " (not available)");
        }
    }

    public void releaseEquipment(Equipment e) {
        if (e != null && e.getState() == Equipment.EquipmentState.BUSY) {
            e.setState(Equipment.EquipmentState.IDLE);
            System.out.println("Released " + e.getId());
        }
    }

    public void printEquipmentInfo() {
        System.out.println("\n=== EQUIPMENT INFO ===");
        for (Equipment e : equipmentList) {
            System.out.println(" " + e.getId()
                    + " | " + e.getClass().getSimpleName()
                    + " | State: " + e.getState()
                    + " | Battery: " + e.getBatteryLevel());
        }
    }
}
