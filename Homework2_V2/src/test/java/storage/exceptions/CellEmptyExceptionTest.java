package storage.exceptions;

import org.junit.jupiter.api.Test;
import storage.model.Position;
import storage.constants.ExceptionMessages;
import static org.junit.jupiter.api.Assertions.*;

public class CellEmptyExceptionTest {
    @Test
    void testDefaultConstructor() {
        CellEmptyException exception = new CellEmptyException();
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().startsWith("Cell is empty at id"));
    }

    @Test
    void testPositionConstructor() {
        Position position = new Position(1, 2, 3);
        CellEmptyException exception = new CellEmptyException(position);
        String expectedMessage = ExceptionMessages.CELL_EMPTY + position.toString();
        assertEquals(expectedMessage, exception.getMessage());
    }
}