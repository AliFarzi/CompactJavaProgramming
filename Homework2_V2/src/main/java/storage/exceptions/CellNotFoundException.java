package storage.exceptions;

import storage.model.Position;
import storage.constants.ExceptionMessages;

public class CellNotFoundException extends Exception {

    public CellNotFoundException(Position position) {
        super(ExceptionMessages.CELL_NOT_FOUND + position);
    }

    public CellNotFoundException() {
        super(ExceptionMessages.CELL_NOT_FOUND);
    }
}
