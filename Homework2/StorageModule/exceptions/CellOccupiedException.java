package Homework2.StorageModule.exceptions;

import Homework2.StorageModule.constants.ExceptionMessages;
import Homework2.StorageModule.model.Position;

public class CellOccupiedException extends Exception {
    public CellOccupiedException(Position position) {
        super(ExceptionMessages.CELL_OCCUPIED + position);
    }
}
