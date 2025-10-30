package Homework2.StorageModule.service;

import Homework2.StorageModule.model.*;
import Homework2.StorageModule.exceptions.*;
import java.util.List;

public class StorageManager {

    private Storage storage;

    public StorageManager(Storage storage) {
        this.storage = storage;
    }

    public void addItem(Item item, Position position)
            throws CellOccupiedException, CellLockedException, CellNotFoundException {

        try {
            Cell cell = storage.getCell(position);
            if (cell.isLocked())
                throw new CellLockedException(position);
            if (!cell.isEmpty())
                throw new CellOccupiedException(position);

            cell.store(item);
            item.moveTo(position);
        } catch (CellNotFoundException | CellOccupiedException | CellLockedException e) {
            System.out.println("Failed to add item " + item.getId() + " at " + position);
            throw e; // re-throw for the caller to handle
        }
    }


    // Add an item to the first available cell in the warehouse.
    public void addItem(Item item)
            throws StorageFullException, CellOccupiedException, CellLockedException, CellNotFoundException {

        Cell cell = findFirstAvailableCell();
        if (cell == null) {
            throw new StorageFullException();
        }

        addItem(item, cell.getPosition());
    }

    public Item retrieveItem(Position position)
            throws CellEmptyException, CellLockedException, CellNotFoundException {

        Cell cell = storage.getCell(position);
        if (cell == null) throw new CellNotFoundException(position);
        if (cell.isLocked()) throw new CellLockedException(position);
        if (cell.isEmpty()) throw new CellEmptyException(position);

        Item item = cell.retrieve();
        item.updateStatus(Item.Status.RETRIEVED);
        return item;
    }

    public void moveItem(Position from, Position to)
            throws CellEmptyException, CellOccupiedException, CellLockedException, CellNotFoundException, StorageOperationException {

        try {
            Cell fromCell = storage.getCell(from);
            Cell toCell = storage.getCell(to);

            if (fromCell.isEmpty())
                throw new CellEmptyException(from);
            if (!toCell.isEmpty())
                throw new CellOccupiedException(to);
            if (fromCell.isLocked() || toCell.isLocked())
                throw new CellLockedException();

            Item item = fromCell.retrieve();
            toCell.store(item);
            item.moveTo(to);

        } catch (CellNotFoundException | CellEmptyException | CellOccupiedException | CellLockedException e) {
            System.out.println("Original exception: " + e.getClass().getSimpleName());
            throw new StorageOperationException("Failed to move item from " + from + " to " + to, e);
        }
    }


    // Find the first available empty cell (default strategy: first-fit)
    public Cell findFirstAvailableCell() {
        List<Cell> cells = storage.getCells();
        for (Cell cell : cells) {
            if (cell.isAvailable()) {
                return cell;
            }
        }
        return null; 
    }

    public int countAvailableCells() {
        int count = 0;
        for (Cell cell : storage.getCells()) {
            if (cell.isAvailable()) count++;
        }
        return count;
    }

    // Print storage info (for debugging)
    public void printStorageInfo() {
        System.out.println("Storage: " + storage.getName());
        System.out.println("Total cells: " + storage.getCells().size());
        System.out.println("Available cells: " + countAvailableCells());
    }
}
