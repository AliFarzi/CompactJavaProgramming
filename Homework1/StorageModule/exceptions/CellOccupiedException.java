package Homework1.StorageModule.exceptions;

import Homework1.StorageModule.constants.ExceptionMessages;
import Homework1.StorageModule.model.Position;

public class CellOccupiedException extends Exception {
    public CellOccupiedException(Position position) {
        super(ExceptionMessages.CELL_OCCUPIED + position);
    }
}
