package CapstoneProject.StorageModule.exceptions;

import CapstoneProject.StorageModule.model.Position;
import CapstoneProject.StorageModule.constants.ExceptionMessages;

public class CellNotFoundException extends Exception {

    public CellNotFoundException(Position position) {
        super(ExceptionMessages.CELL_NOT_FOUND + position);
    }

    public CellNotFoundException() {
        super(ExceptionMessages.CELL_NOT_FOUND);
    }
}
