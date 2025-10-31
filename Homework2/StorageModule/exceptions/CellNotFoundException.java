package Homework1.StorageModule.exceptions;

import Homework1.StorageModule.model.Position;
import Homework1.StorageModule.constants.ExceptionMessages;

public class CellNotFoundException extends Exception {

    public CellNotFoundException(Position position) {
        super(ExceptionMessages.CELL_NOT_FOUND + position);
    }

    public CellNotFoundException() {
        super(ExceptionMessages.CELL_NOT_FOUND);
    }
}
