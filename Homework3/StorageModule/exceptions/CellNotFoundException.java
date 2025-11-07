package Homework3.StorageModule.exceptions;

import Homework3.StorageModule.model.Position;
import Homework3.StorageModule.constants.ExceptionMessages;

public class CellNotFoundException extends Exception {

    public CellNotFoundException(Position position) {
        super(ExceptionMessages.CELL_NOT_FOUND + position);
    }

    public CellNotFoundException() {
        super(ExceptionMessages.CELL_NOT_FOUND);
    }
}
