package Homework1.StorageModule.test;

import Homework1.StorageModule.*;
import Homework1.StorageModule.model.*;
import Homework1.StorageModule.exceptions.*;

public class StorageTest {
    public static void main(String[] args) {

        // 1. Create warehouse storage (with 5x5x3 grid)
        Storage storage = new Storage("S001", "Warehouse1", 5, 5, 3);

        // 2. Initialize the submodule
        StorageSubmodule storageSubmodule = new StorageSubmodule(storage);

        try {
            // 3. Create items with initial positions
            Item item1 = new Item("I001", "Lunch Box 1", 1.2, new Position(1,1,1));
            Item item2 = new Item("I002", "Lunch Box 2", 1.5, null); // no initial position

            // 4. Add items
            storageSubmodule.addItem(item1, item1.getPosition()); // add at specific position
            storageSubmodule.addItem(item2); // auto-place in first available cell

            // 5. Print storage info
            storageSubmodule.printStorageInfo();

            // 6. Move an item
            storageSubmodule.moveItem(new Position(1,1,1), new Position(2,2,1));

            // 7. Retrieve an item
            Item retrieved = storageSubmodule.retrieveItem(new Position(2,2,1));
            System.out.println("Retrieved: " + retrieved);

            // 8. Print storage info again
            storageSubmodule.printStorageInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
