package storage.exceptions;

import org.junit.jupiter.api.Test;
import storage.model.Position;
import storage.constants.ExceptionMessages;
import static org.junit.jupiter.api.Assertions.*;

public class CellLockedExceptionTest {
    @Test
    void testDefaultConstructor() {
        CellLockedException exception = new CellLockedException();
        assertNotNull(exception.getMessage());
        assertEquals(ExceptionMessages.CELL_LOCKED.trim(), exception.getMessage().trim());
    }

    @Test
    void testPositionConstructor() {
        Position position = new Position(1, 2, 3);
        CellLockedException exception = new CellLockedException(position);
        String expectedMessage = ExceptionMessages.CELL_LOCKED + position.toString();
        assertEquals(expectedMessage, exception.getMessage());
    }
}