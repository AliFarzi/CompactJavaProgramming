package Homework2.StorageModule.exceptions;

import Homework2.StorageModule.constants.ExceptionMessages;
import Homework2.StorageModule.model.Position;

public class CellLockedException extends Exception {
    public CellLockedException(Position position) {
        super(ExceptionMessages.CELL_LOCKED + position);
    }

    public CellLockedException() {
        super(ExceptionMessages.CELL_LOCKED);
    }
}
