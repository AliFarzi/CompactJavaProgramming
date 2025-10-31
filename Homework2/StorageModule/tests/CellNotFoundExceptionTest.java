package Homework2.StorageModule.tests;

import Homework2.StorageModule.model.*;
import Homework2.StorageModule.service.StorageManager;
import Homework2.StorageModule.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellNotFoundExceptionTest {

    private Storage storage;
    private StorageManager manager;

    @BeforeEach
    void setup() {
        storage = new Storage("WH1", "Warehouse", 2, 2, 1);
        manager = new StorageManager(storage);
    }

    @Test
    void testAddItemInvalidPosition() {
        Position invalid = new Position(5,5,5);
        Item item = new Item("I003", "Keyboard", 1.0, new Position(0,0,0));
        assertThrows(CellNotFoundException.class, () -> manager.addItem(item, invalid));
    }

    @Test
    void testRetrieveItemInvalidPosition() {
        Position invalid = new Position(3,3,1);
        assertThrows(CellNotFoundException.class, () -> manager.retrieveItem(invalid));
    }

    @Test
    void testMoveFromInvalidPosition() {
        Position invalid = new Position(3,1,1);
        Position to = new Position(1,1,1);
        assertThrows(CellNotFoundException.class, () -> manager.moveItem(invalid, to));
    }

    @Test
    void testMoveToInvalidPosition() throws Exception {
        Item item = new Item("I004", "Mouse", 0.5, new Position(0,0,0));
        Position valid = new Position(1,1,1);
        Position invalid = new Position(4,4,1);
        manager.addItem(item, valid);
        assertThrows(CellNotFoundException.class, () -> manager.moveItem(valid, invalid));
    }

    @Test
    void testDirectGetCellInvalid() {
        Position invalid = new Position(5,5,1);
        assertThrows(CellNotFoundException.class, () -> storage.getCell(invalid));
    }
}
