package Homework2.StorageModule.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StorageFullExceptionTest {

    @Test
    void testDefaultConstructor() {
        StorageFullException ex = new StorageFullException();
        assertNotNull(ex.getMessage()); 
    }

    @Test
    void testMessageConstructor() {
        StorageFullException ex = new StorageFullException("Storage full!");
        assertEquals("Storage full!", ex.getMessage());
    }

    @Test
    void testChainingConstructor() {
        Throwable cause = new RuntimeException("Cause");
        StorageFullException ex = new StorageFullException("Storage full!", cause);
        assertEquals("Storage full!", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testThrowAndCatch() {
        Exception thrown = assertThrows(StorageFullException.class, () -> {
            throw new StorageFullException("Full");
        });
        assertEquals("Full", thrown.getMessage());
    }

    @Test
    void testInheritance() {
        StorageFullException ex = new StorageFullException();
        assertTrue(ex instanceof Exception);
    }
}
