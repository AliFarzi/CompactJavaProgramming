package storage.exceptions;

import storage.constants.ExceptionMessages;
import storage.model.Position;

public class CellOccupiedException extends Exception {
    public CellOccupiedException(Position position) {
        super(ExceptionMessages.CELL_OCCUPIED + position);
    }
}
