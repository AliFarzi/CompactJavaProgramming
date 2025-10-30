package Homework1.StorageModule.service;

import Homework1.StorageModule.model.*;
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
}
