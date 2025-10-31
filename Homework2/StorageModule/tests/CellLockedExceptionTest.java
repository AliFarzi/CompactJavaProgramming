package Homework2.StorageModule.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellLockedExceptionTest {

    @Test
    void testExceptionMessage() {
        CellLockedException ex = new CellLockedException("Cell is locked!");
        assertEquals("Cell is locked!", ex.getMessage());
    }

    @Test
    void testExceptionInheritance() {
        CellLockedException ex = new CellLockedException("Locked");
        assertTrue(ex instanceof Exception);
    }

    @Test
    void testThrowAndCatch() {
        Exception thrown = assertThrows(CellLockedException.class, () -> {
            throw new CellLockedException("Locked cell");
        });
        assertEquals("Locked cell", thrown.getMessage());
    }

    @Test
    void testConstructorWithPosition() {
        Position pos = new Position(1, 1, 1);
        CellLockedException ex = new CellLockedException(pos);
        assertTrue(ex.getMessage().contains("1")); // optional check for pos in message
    }

    @Test
    void testChaining() {
        Throwable cause = new RuntimeException("Cause");
        CellLockedException ex = new CellLockedException("Locked", cause);
        assertEquals("Locked", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
