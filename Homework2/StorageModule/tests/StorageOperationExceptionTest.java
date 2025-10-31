package Homework2.StorageModule.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StorageOperationExceptionTest {

    @Test
    void testChaining() {
        Throwable cause = new RuntimeException("Original cause");
        StorageOperationException ex = new StorageOperationException("Operation failed", cause);
        assertEquals("Operation failed", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testThrowAndCatch() {
        Exception thrown = assertThrows(StorageOperationException.class, () -> {
            throw new StorageOperationException("Failed", new RuntimeException("Cause"));
        });
        assertEquals("Failed", thrown.getMessage());
    }

    @Test
    void testInheritance() {
        StorageOperationException ex = new StorageOperationException("Op fail", null);
        assertTrue(ex instanceof Exception);
    }

    @Test
    void testNullCause() {
        StorageOperationException ex = new StorageOperationException("Fail", null);
        assertNull(ex.getCause());
        assertEquals("Fail", ex.getMessage());
    }

    @Test
    void testNonNullCause() {
        Throwable cause = new IllegalArgumentException("Bad arg");
        StorageOperationException ex = new StorageOperationException("Fail", cause);
        assertEquals(cause, ex.getCause());
    }
}
