package Homework1.StorageModule.service;

import Homework1.StorageModule.model.*;
import Homework1.StorageModule.exceptions.*;

import java.util.List;

// logic for Storage operations
public class StorageManager {

    private Storage storage;

    public StorageManager(Storage storage) {
        this.storage = storage;
    }

    // Add an item to a specific position
    public void addItem(Item item, Position position) throws CellOccupiedException, CellLockedException, CellNotFoundException {
        Cell cell = storage.getCell(position);
        if (cell == null) {
            throw new CellNotFoundException("No cell found at position " + position);
        }
        if (cell.isLocked()) {
            throw new CellLockedException("Cell " + cell.getId() + " is locked!");
        }
        if (!cell.isEmpty()) {
            throw new CellOccupiedException("Cell " + cell.getId() + " is already occupied!");
        }

        cell.store(item);
    }

    // Retrieve an item from a specific position
    public Item retrieveItem(Position position) throws CellEmptyException, CellLockedException, CellNotFoundException {
        Cell cell = storage.getCell(position);
        if (cell == null) {
            throw new CellNotFoundException("No cell found at position " + position);
        }
        if (cell.isLocked()) {
            throw new CellLockedException("Cell " + cell.getId() + " is locked!");
        }
        if (cell.isEmpty()) {
            throw new CellEmptyException("Cell " + cell.getId() + " is empty!");
        }

        return cell.retrieve();
    }

    // Find the first available empty cell
    public Cell findEmptyCell() {
        List<Cell> cells = storage.getCells();
        for (Cell cell : cells) {
            if (cell.isAvailable()) {
                return cell;
            }
        }
        return null;
    }

    // Lock a cell
    public void lockCell(Position position) throws CellNotFoundException {
        Cell cell = storage.getCell(position);
        if (cell == null) throw new CellNotFoundException("No cell found at position " + position);
        cell.lock();
    }

    // Unlock a cell
    public void unlockCell(Position position) throws CellNotFoundException {
        Cell cell = storage.getCell(position);
        if (cell == null) throw new CellNotFoundException("No cell found at position " + position);
        cell.unlock();
    }

    // Move an item from one cell to another
    public void moveItem(Position from, Position to) throws CellNotFoundException, CellLockedException, CellOccupiedException, CellEmptyException {
        Item item = retrieveItem(from); 
        addItem(item, to);            
    }

    public Storage getStorage() {
        return storage;
    }
}
