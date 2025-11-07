package Homework3.StorageModule.exceptions;

import Homework3.StorageModule.constants.ExceptionMessages;
import Homework3.StorageModule.model.Position;

public class CellLockedException extends Exception {
    public CellLockedException(Position position) {
        super(ExceptionMessages.CELL_LOCKED + position);
    }

    public CellLockedException() {
        super(ExceptionMessages.CELL_LOCKED);
    }
}
