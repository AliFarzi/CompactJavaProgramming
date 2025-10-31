package storage.exceptions;

import storage.constants.ExceptionMessages;
import storage.model.Position;

public class CellLockedException extends Exception {
    public CellLockedException(Position position) {
        super(ExceptionMessages.CELL_LOCKED + position);
    }

    public CellLockedException() {
        super(ExceptionMessages.CELL_LOCKED);
    }
}
