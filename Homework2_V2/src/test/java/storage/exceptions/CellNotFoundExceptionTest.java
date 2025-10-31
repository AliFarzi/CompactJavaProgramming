package storage.exceptions;

import org.junit.jupiter.api.Test;
import storage.model.Position;
import storage.constants.ExceptionMessages;
import static org.junit.jupiter.api.Assertions.*;

public class CellNotFoundExceptionTest {
    @Test
    void testDefaultConstructor() {
        CellNotFoundException exception = new CellNotFoundException();
        assertNotNull(exception.getMessage());
        assertEquals(ExceptionMessages.CELL_NOT_FOUND.trim(), exception.getMessage().trim());
    }

    @Test
    void testPositionConstructor() {
        Position position = new Position(1, 2, 3);
        CellNotFoundException exception = new CellNotFoundException(position);
        String expectedMessage = ExceptionMessages.CELL_NOT_FOUND + position.toString();
        assertEquals(expectedMessage, exception.getMessage());
    }
}