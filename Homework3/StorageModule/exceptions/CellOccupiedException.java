package Homework3.StorageModule.exceptions;

import Homework3.StorageModule.constants.ExceptionMessages;
import Homework3.StorageModule.model.Position;

public class CellOccupiedException extends Exception {
    public CellOccupiedException(Position position) {
        super(ExceptionMessages.CELL_OCCUPIED + position);
    }
}
