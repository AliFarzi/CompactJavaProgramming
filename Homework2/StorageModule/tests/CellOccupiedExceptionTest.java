package Homework2.StorageModule.tests;

import Homework2.StorageModule.model.*;
import Homework2.StorageModule.service.StorageManager;
import Homework2.StorageModule.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellOccupiedExceptionTest {

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
    void testAddItemOccupied() throws Exception {
        Item item1 = new Item("I001", "Laptop", 2.5, new Position(0,0,0));
        Item item2 = new Item("I002", "Monitor", 1.0, new Position(0,0,0));
        manager.addItem(item1, pos);
        assertThrows(CellOccupiedException.class, () -> manager.addItem(item2, pos));
    }

    @Test
    void testMoveToOccupiedCell() throws Exception {
        Item item1 = new Item("I003", "Keyboard", 1.0, new Position(0,0,0));
        Item item2 = new Item("I004", "Mouse", 0.5, new Position(0,0,0));
        Position pos2 = new Position(1,2,1);
        manager.addItem(item1, pos);
        manager.addItem(item2, pos2);
        assertThrows(CellOccupiedException.class, () -> manager.moveItem(pos, pos2));
    }

    @Test
    void testStoreDirectIllegalState() throws Exception {
        Cell cell = storage.getCell(pos);
        Item item1 = new Item("I005", "Tablet", 1.2, new Position(0,0,0));
        cell.store(item1);
        Item item2 = new Item("I006", "Phone", 0.8, new Position(0,0,0));
        assertThrows(IllegalStateException.class, () -> cell.store(item2));
    }

    @Test
    void testAddMultipleItems() throws Exception {
        Item item1 = new Item("I007", "Item7", 1.0, new Position(0,0,0));
        Item item2 = new Item("I008", "Item8", 1.0, new Position(0,0,0));
        manager.addItem(item1, pos);
        assertThrows(CellOccupiedException.class, () -> manager.addItem(item2, pos));
    }

    @Test
    void testMoveItemTwice() throws Exception {
        Item item = new Item("I009", "Item9", 1.0, new Position(0,0,0));
        manager.addItem(item, pos);
        Position newPos = new Position(1,2,1);
        manager.moveItem(pos, newPos);
        assertThrows(CellOccupiedException.class, () -> manager.moveItem(newPos, newPos));
    }
}
