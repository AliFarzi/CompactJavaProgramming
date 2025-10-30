package Homework1.StorageModule.test;

import Homework1.StorageModule.*;
import Homework1.StorageModule.model.*;
import Homework1.StorageModule.exceptions.*;

public class StorageSimulation {

    public static void main(String[] args) {

        Storage storage = new Storage("WH1", "Main Warehouse", 3, 3, 2); // smaller grid
        StorageSubmodule warehouse = new StorageSubmodule(storage);

        try {
            // Create multiple items
            Item[] items = new Item[5];
            for (int i = 0; i < items.length; i++) {
                items[i] = new Item("I00" + (i + 1), "Item" + (i + 1), 1.0 + i, new Position(0,0,0));
            }

            // Add items automatically
            System.out.println("\n--- Adding Items Automatically ---");
            for (Item item : items) {
                warehouse.addItem(item); // auto-place
                warehouse.printStorageInfo();
                printOccupiedCells(storage);
                Thread.sleep(500);
            }

            // Move first item (I001) to first available cell
            System.out.println("\n--- Moving Item I001 ---");
            Item itemToMove = items[0];
            // Find a free cell manually by scanning storage
            Position currentPos = itemToMove.getPosition();
            Position newPos = null;
            for (Cell cell : storage.getCells()) {
                if (cell.isAvailable()) {
                    newPos = cell.getPosition();
                    break;
                }
            }
            if (newPos != null) {
                warehouse.moveItem(currentPos, newPos);
                System.out.println("Moved Item " + itemToMove.getId() + " from " + currentPos + " to " + newPos);
            }
            warehouse.printStorageInfo();
            printOccupiedCells(storage);
            Thread.sleep(500);

            // Retrieve an item
            System.out.println("\n--- Retrieving Item I001 ---");
            Item retrieved = warehouse.retrieveItem(itemToMove.getPosition());
            System.out.println("Retrieved: " + retrieved);
            warehouse.printStorageInfo();
            printOccupiedCells(storage);

            //  Add another item (simulate new task)
            System.out.println("\n--- Adding a new Item I006 ---");
            Item newItem = new Item("I006", "NewItem", 2.0, new Position(0,0,0));
            warehouse.addItem(newItem);
            warehouse.printStorageInfo();
            printOccupiedCells(storage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper to print all occupied cells
    private static void printOccupiedCells(Storage storage) {
        System.out.println("--- Occupied Cells ---");
        for (Cell cell : storage.getCells()) {
            if (!cell.isEmpty()) {
                System.out.println(cell.getPosition() + " -> " + cell.getContent().getId() +
                                   " [" + cell.getContent().getDescription() + "]");
            }
        }
    }
}
