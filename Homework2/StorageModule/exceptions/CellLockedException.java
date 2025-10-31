package Homework2.StorageModule.exceptions;

import Homework1.StorageModule.constants.ExceptionMessages;
import Homework1.StorageModule.model.Position;

public class CellLockedException extends Exception {
    public CellLockedException(Position position) {
        super(ExceptionMessages.CELL_LOCKED + position);
    }

    public CellLockedException() {
        super(ExceptionMessages.CELL_LOCKED);
    }
}
