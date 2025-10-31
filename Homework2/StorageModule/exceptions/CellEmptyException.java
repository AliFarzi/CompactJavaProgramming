package Homework2.StorageModule.exceptions;

import Homework1.StorageModule.constants.ExceptionMessages;
import Homework1.StorageModule.model.Position;

public class CellEmptyException extends Exception {
    public CellEmptyException(Position position) {
        super(ExceptionMessages.CELL_EMPTY + position);
    }

    public CellEmptyException() {
        super(ExceptionMessages.CELL_EMPTY_ID);
    }
}
