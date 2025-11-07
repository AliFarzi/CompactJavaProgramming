package Homework3.TaskModule;

import Homework3.StorageModule.model.*;
import Homework3.StorageModule.service.StorageManager;
import Homework3.StorageModule.exceptions.*;
import Homework3.LogingModule.LoggingManager;
import Homework3.LogingModule.LogLevel;
import Homework3.EqiupmentModule.*;
import Homework3.EqiupmentModule.model.AGV;
import Homework3.EqiupmentModule.model.ChargingStation;
import Homework3.EqiupmentModule.model.Equipment;
import Homework3.EqiupmentModule.service.EquipmentManager;

public class TestStorageUsage {

    public static void main(String[] args) {

        LoggingManager logger = LoggingManager.getInstance();
        logger.log("Starting Testing task", LogLevel.INFO, "TestStorageUsage");

        logger.log("Initializing Equipment Manager", LogLevel.INFO, "TestStorageUsage");
        EquipmentManager equipmentManager = new EquipmentManager();

        logger.log("Added Charging Station", LogLevel.INFO, "TestStorageUsage");
        ChargingStation cs1 = new ChargingStation("CS001", new Position(5, 5, 0), 2);

        AGV eq1 = new AGV("AGV002", new Position(0, 0, 0), 30, 75, 110, 100, "CS001");

        AGV eq2 = new AGV("AGV003", new Position(1, 1, 0), 25, 60, 90, 80, "CS001");

        equipmentManager.addEquipment(eq1);
        equipmentManager.addEquipment(eq2);
        logger.log("Added AGVs to Equipment Manager", LogLevel.INFO, "TestStorageUsage");

        equipmentManager.printEquipmentInfo();


        Storage storage = new Storage("WH1", "Main Warehouse", 3, 3, 1); // 9 cells
        StorageManager warehouse = new StorageManager(storage);

        try {
            System.out.println("\n=== ADDING ITEMS ===");

            // Manual placement
            Item item1 = new Item("I001", "Laptop", 2.5, new Position(0, 0, 0));
            warehouse.addItem(item1, new Position(1, 1, 1));
            System.out.println(" Added Item I001 at (1,1,1)");

            // Automatic placement
            Item item2 = new Item("I002", "Monitor", 4.0, new Position(0, 0, 0));
            Item item3 = new Item("I003", "Keyboard", 1.0, new Position(0, 0, 0));
            warehouse.addItem(item2);
            warehouse.addItem(item3);
            System.out.println(" Added items I002 and I003 automatically");

            warehouse.printStorageInfo();

            // Move item
            System.out.println("\n=== MOVING ITEM ===");
            try {
                warehouse.moveItem(new Position(1, 1, 1), new Position(2, 2, 1));
                System.out.println("Moved I001 to (2,2,1)");
            } catch (CellNotFoundException | CellEmptyException | CellOccupiedException | CellLockedException e) {
                System.out.println("!!! " + e.getMessage());
            }
            warehouse.printStorageInfo();

            // Retrieve item
            System.out.println("\n=== RETRIEVING ITEM ===");
            try {
                Item retrieved = warehouse.retrieveItem(new Position(2, 2, 1));
                System.out.println(" Retrieved: " + retrieved);
            } catch (CellNotFoundException | CellEmptyException | CellLockedException e) {
                System.out.println("!!! " + e.getMessage());
            }
            warehouse.printStorageInfo();

            // Fill up storage
            System.out.println("\n=== FILLING STORAGE ===");
            for (int i = 4; i <= 10; i++) {
                try {
                    Item item = new Item("I00" + i, "Item" + i, 1.0, new Position(0, 0, 0));
                    warehouse.addItem(item);
                    System.out.println(" Added " + item.getId());
                } catch (StorageFullException | CellOccupiedException | CellLockedException | CellNotFoundException e) {
                    System.out.println("!!! " + e.getMessage());
                }
            }
            warehouse.printStorageInfo();

            // Try moving to occupied cell
            System.out.println("\n=== TESTING OCCUPIED CELL ===");
            try {
                warehouse.moveItem(new Position(1, 2, 1), new Position(1, 1, 1)); // occupied
            } catch (CellOccupiedException | CellEmptyException | CellLockedException | CellNotFoundException e) {
                System.out.println("!!! " + e.getMessage());
            }

            // Try moving non-existent item
            System.out.println("\n=== TESTING INVALID MOVE ===");
            try {
                warehouse.moveItem(new Position(3, 3, 1), new Position(2, 2, 1)); // source empty
            } catch (CellEmptyException | CellOccupiedException | CellLockedException | CellNotFoundException e) {
                System.out.println("!!! " + e.getMessage());
            }

            // Try retrieving from empty
            System.out.println("\n=== TESTING EMPTY RETRIEVE ===");
            try {
                warehouse.retrieveItem(new Position(3, 3, 1)); // empty
            } catch (CellEmptyException | CellLockedException | CellNotFoundException e) {
                System.out.println("!!! " + e.getMessage());
            }

            // Re-add after retrieve
            System.out.println("\n=== RE-ADDING AFTER RETRIEVE ===");
            try {
                Item item11 = new Item("I011", "Tablet", 2.2, new Position(0, 0, 0));
                warehouse.addItem(item11);
                System.out.println(" Re-added " + item11.getId());
            } catch (StorageFullException | CellOccupiedException | CellLockedException | CellNotFoundException e) {
                System.out.println("!!! " + e.getMessage());
            }

        } catch (Exception e) {
            // This should rarely trigger now
            System.out.println("Unexpected error: " + e.getMessage());
        }

        System.out.println("\n=== FINAL STORAGE STATE ===");
        warehouse.printStorageInfo();
        System.out.println("\n Simulation completed successfully.");
    }
}
