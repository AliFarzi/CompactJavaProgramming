package storage.exceptions;

import storage.constants.ExceptionMessages;
import storage.model.Position;

public class CellEmptyException extends Exception {
    public CellEmptyException(Position position) {
        super(ExceptionMessages.CELL_EMPTY + position);
    }

    public CellEmptyException() {
        super(ExceptionMessages.CELL_EMPTY_ID);
    }
}
