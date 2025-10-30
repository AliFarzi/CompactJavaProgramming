package Homework1.TaskModule;

import Homework1.StorageModule.model.*;
import Homework1.StorageModule.service.StorageManager;
import Homework1.StorageModule.exceptions.*;

public class TestStorageUsage {

    public static void main(String[] args) {
        Storage storage = new Storage("WH1", "Main Warehouse", 3, 3, 1); // 9 cells
        //StorageSubmodule warehouse = new StorageSubmodule(storage);
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
            warehouse.moveItem(new Position(1, 1, 1), new Position(2, 2, 1));
            System.out.println("Moved I001 to (2,2,1)");
            warehouse.printStorageInfo();

            // Retrieve item
            System.out.println("\n=== RETRIEVING ITEM ===");
            Item retrieved = warehouse.retrieveItem(new Position(2, 2, 1));
            System.out.println(" Retrieved: " + retrieved);
            warehouse.printStorageInfo();

            // Fill up storage
            System.out.println("\n=== FILLING STORAGE ===");
            for (int i = 4; i <= 10; i++) {
                Item item = new Item("I00" + i, "Item" + i, 1.0, new Position(0, 0, 0));
                warehouse.addItem(item);
                System.out.println(" Added " + item.getId());
            }

            warehouse.printStorageInfo();

            // Try moving to occupied cell
            System.out.println("\n=== TESTING OCCUPIED CELL ===");
            try {
                warehouse.moveItem(new Position(1, 2, 1), new Position(1, 1, 1)); // occupied
            } catch (CellOccupiedException e) {
                System.out.println("!!! " + e.getMessage());
            }

            // Try moving non-existent item
            System.out.println("\n=== TESTING INVALID MOVE ===");
            try {
                warehouse.moveItem(new Position(3, 3, 1), new Position(2, 2, 1)); // source empty
            } catch (CellEmptyException e) {
                System.out.println("!!! " + e.getMessage());
            }

            // Try retrieving from empty
            System.out.println("\n=== TESTING EMPTY RETRIEVE ===");
            try {
                warehouse.retrieveItem(new Position(3, 3, 1)); // empty
            } catch (CellEmptyException e) {
                System.out.println("!!! " + e.getMessage());
            }

        } catch (StorageFullException e) {
            System.out.println("Storage full: " + e.getMessage());

        } catch (CellOccupiedException | CellLockedException | CellNotFoundException |
                 CellEmptyException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== FINAL STORAGE STATE ===");
        warehouse.printStorageInfo();

        System.out.println("\n=== RE-ADDING AFTER RETRIEVE ===");
        try {
            Item item11 = new Item("I011", "Tablet", 2.2, new Position(0, 0, 0));
            warehouse.addItem(item11);
            System.out.println("Re-added " + item11.getId());
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!" + e.getMessage());
        }

        warehouse.printStorageInfo();

        System.out.println("\n Simulation completed successfully.");
    }
}
