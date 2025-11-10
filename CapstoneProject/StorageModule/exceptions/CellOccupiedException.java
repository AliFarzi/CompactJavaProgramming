package CapstoneProject.StorageModule.exceptions;

import CapstoneProject.StorageModule.constants.ExceptionMessages;
import CapstoneProject.StorageModule.model.Position;

public class CellOccupiedException extends Exception {
    public CellOccupiedException(Position position) {
        super(ExceptionMessages.CELL_OCCUPIED + position);
    }
}
