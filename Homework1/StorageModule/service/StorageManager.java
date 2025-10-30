package Homework1.StorageModule.service;

import Homework1.StorageModule.model.*;

import java.util.List;

import Homework1.StorageModule.exceptions.*;

public class StorageManager {

    private Storage storage;

    public StorageManager(Storage storage) {
        this.storage = storage;
    }

    public void addItem(Item item, Position position)
            throws CellOccupiedException, CellLockedException, CellNotFoundException {

        Cell cell = storage.getCell(position);
        if (cell == null) throw new CellNotFoundException("Cell not found at " + position);
        if (cell.isLocked()) throw new CellLockedException("Cell is locked at " + position);
        if (!cell.isEmpty()) throw new CellOccupiedException("Cell already occupied at " + position);

        cell.store(item);
        item.moveTo(position); 
    }

      //  Add an item to the first available cell in the warehouse.
    public void addItem(Item item)
            throws StorageFullException, CellOccupiedException, CellLockedException, CellNotFoundException {

        Cell cell = findFirstAvailableCell();
        if (cell == null) {
            throw new StorageFullException("No empty cells available!");
        }

        addItem(item, cell.getPosition());
    }




    public Item retrieveItem(Position position)
            throws CellEmptyException, CellLockedException, CellNotFoundException {

        Cell cell = storage.getCell(position);
        if (cell == null) throw new CellNotFoundException("Cell not found at " + position);
        if (cell.isLocked()) throw new CellLockedException("Cell is locked at " + position);
        if (cell.isEmpty()) throw new CellEmptyException("Cell is empty at " + position);

        Item item = cell.retrieve();
        item.updateStatus(Item.Status.RETRIEVED);
        return item;
    }

    public void moveItem(Position from, Position to)
            throws CellEmptyException, CellOccupiedException, CellLockedException, CellNotFoundException {

        Cell fromCell = storage.getCell(from);
        Cell toCell = storage.getCell(to);

        if (fromCell == null || toCell == null)
            throw new CellNotFoundException("Invalid source or destination cell");

        if (fromCell.isEmpty()) throw new CellEmptyException("Source cell is empty: " + from);
        if (!toCell.isEmpty()) throw new CellOccupiedException("Destination cell occupied: " + to);
        if (fromCell.isLocked() || toCell.isLocked()) throw new CellLockedException("Cell is locked");

        Item item = fromCell.retrieve();
        toCell.store(item);
        item.moveTo(to); 
    }


     //  Find the first available empty cell (default strategy: first-fit)
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

     //  Print storage info (for debugging).
    public void printStorageInfo() {
        System.out.println("Storage: " + storage.getName());
        System.out.println("Total cells: " + storage.getCells().size());
        System.out.println("Available cells: " + countAvailableCells());
    }
}
