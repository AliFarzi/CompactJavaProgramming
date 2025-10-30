package Homework1.StorageModule;

import Homework1.StorageModule.model.*;
import Homework1.StorageModule.service.*;
import Homework1.StorageModule.exceptions.*;
import Homework1.StorageModule.utils.*;

//   Facade API for other submodules (Task, Equipment, HMI)
//   to interact with the warehouse storage.
public class StorageSubmodule {

    private final Storage storage;
    private final StorageManager storageManager;
    private final CellAllocator cellAllocator;

    public StorageSubmodule(Storage storage) {
        this.storage = storage;
        this.storageManager = new StorageManager(storage);
        this.cellAllocator = new CellAllocator(storage);
    }

    //  Add an item at a specific position in the warehouse.
    public void addItem(Item item, Position position)
            throws IllegalArgumentException, CellOccupiedException, CellLockedException, CellNotFoundException {

        if (!PositionUtils.isValid(position, storage.getRows(), storage.getColumns(), storage.getLevels())) {
            throw new IllegalArgumentException("Invalid position: " + PositionUtils.toReadableString(position));
        }

        storageManager.addItem(item, position);
    }

    //  Add an item to the first available cell in the warehouse.
    public void addItem(Item item)
            throws StorageFullException, CellOccupiedException, CellLockedException, CellNotFoundException {

        Cell cell = cellAllocator.findFirstAvailableCell();
        if (cell == null) {
            throw new StorageFullException("No empty cells available!");
        }

        storageManager.addItem(item, cell.getPosition());
    }

    //  Retrieve an item from a specific position.
    public Item retrieveItem(Position position)
            throws IllegalArgumentException, CellEmptyException, CellLockedException, CellNotFoundException {

        if (!PositionUtils.isValid(position, storage.getRows(), storage.getColumns(), storage.getLevels())) {
            throw new IllegalArgumentException("Invalid position: " + PositionUtils.toReadableString(position));
        }

        return storageManager.retrieveItem(position);
    }

    //  Move an item from one position to another.
    public void moveItem(Position from, Position to)
            throws CellLockedException, CellOccupiedException, CellEmptyException, CellNotFoundException {

        storageManager.moveItem(from, to);
    }

    //   Get the number of available cells in the warehouse.
    public int getAvailableCells() {
        return cellAllocator.countAvailableCells();
    }

    //  Print storage info (for debugging).
    public void printStorageInfo() {
        System.out.println("Storage: " + storage.getName());
        System.out.println("Total cells: " + storage.getCells().size());
        System.out.println("Available cells: " + getAvailableCells());
    }
}
