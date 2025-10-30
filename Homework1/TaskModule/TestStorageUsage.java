package Homework1.TaskModule;


import Homework1.StorageModule.*;
import Homework1.StorageModule.model.*;
import Homework1.StorageModule.exceptions.*;

public class TestStorageUsage {
    public static void main(String[] args) {

        Storage storage = new Storage("WH1", "Main Warehouse", 5, 5, 3); // 5x5x3 grid
        StorageSubmodule warehouse = new StorageSubmodule(storage);

        try {
            //  Create items
            Item item1 = new Item("I001", "Laptop", 2.5, new Position(1,1,1));
            Item item2 = new Item("I002", "Monitor", 4.0, new Position(0,0,0)); // initial position doesn't matter if auto-placed

            // Add items
            warehouse.addItem(item1, new Position(1,1,1)); // explicit position
            warehouse.addItem(item2); // auto-place in first available cell

            // Move item
            warehouse.moveItem(new Position(1,1,1), new Position(2,2,1));

            // Retrieve item
            Item retrieved = warehouse.retrieveItem(new Position(2,2,1));
            System.out.println("Retrieved item: " + retrieved);

            //  Print storage info
            warehouse.printStorageInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
