package storage.exceptions;

import org.junit.jupiter.api.Test;
import storage.model.Position;
import storage.constants.ExceptionMessages;
import static org.junit.jupiter.api.Assertions.*;

public class CellOccupiedExceptionTest {
    @Test
    void testPositionConstructor() {
        Position position = new Position(1, 2, 3);
        CellOccupiedException exception = new CellOccupiedException(position);
        String expectedMessage = ExceptionMessages.CELL_OCCUPIED + position.toString();
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testMessageContainsOccupied() {
        Position position = new Position(0, 0, 0);
        CellOccupiedException exception = new CellOccupiedException(position);
        String expectedMessage = ExceptionMessages.CELL_OCCUPIED + position.toString();
        assertEquals(expectedMessage, exception.getMessage());
        assertTrue(exception.getMessage().toLowerCase().contains("occupied"));
    }
}