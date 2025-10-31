
package Homework2.StorageModule.tests;

import Homework2.StorageModule.model.*;
import Homework2.StorageModule.service.StorageManager;
import Homework2.StorageModule.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellEmptyExceptionTest {

    private Storage storage;
    private StorageManager manager;
    private Position pos;

    @BeforeEach
    void setup() {
        storage = new Storage("WH1", "Warehouse", 2, 2, 1);
        manager = new StorageManager(storage);
        pos = new Position(1,1,1);
    }

    @Test
    void testRetrieveFromEmptyCell() {
        assertThrows(CellEmptyException.class, () -> manager.retrieveItem(pos));
    }

    @Test
    void testRetrieveAfterAddThenRemove() throws Exception {
        Item item = new Item("I001", "Laptop", 2.5, new Position(0,0,0));
        manager.addItem(item, pos);
        manager.retrieveItem(pos);
        assertThrows(CellEmptyException.class, () -> manager.retrieveItem(pos));
    }

    @Test
    void testEmptyCellIsEmptyFlag() {
        Cell cell = storage.getCell(pos);
        assertTrue(cell.isEmpty());
    }

    @Test
    void testRetrieveEmptyCellDirect() {
        Cell cell = storage.getCell(pos);
        assertThrows(CellEmptyException.class, cell::retrieve);
    }

    @Test
    void testEmptyAfterMoveItem() throws Exception {
        Item item = new Item("I002", "Monitor", 1.0, new Position(0,0,0));
        manager.addItem(item, pos);
        Position newPos = new Position(2,1,1);
        manager.moveItem(pos, newPos);
        assertThrows(CellEmptyException.class, () -> manager.retrieveItem(pos));
    }
}
