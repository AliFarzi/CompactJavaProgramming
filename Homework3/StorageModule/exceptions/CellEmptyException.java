package Homework3.StorageModule.exceptions;

import Homework3.StorageModule.constants.ExceptionMessages;
import Homework3.StorageModule.model.Position;

public class CellEmptyException extends Exception {
    public CellEmptyException(Position position) {
        super(ExceptionMessages.CELL_EMPTY + position);
    }

    public CellEmptyException() {
        super(ExceptionMessages.CELL_EMPTY_ID);
    }
}
