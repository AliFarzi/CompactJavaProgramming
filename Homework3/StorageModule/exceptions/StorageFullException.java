package Homework3.StorageModule.exceptions;

import Homework3.StorageModule.constants.ExceptionMessages;

public class StorageFullException extends Exception {
    public StorageFullException() {
        super(ExceptionMessages.STORAGE_FULL);
    }

    public StorageFullException(Throwable cause) {
        super(ExceptionMessages.STORAGE_FULL, cause);
    }
}
