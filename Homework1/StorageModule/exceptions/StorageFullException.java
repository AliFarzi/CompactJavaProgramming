package Homework1.StorageModule.exceptions;

/**
 * Thrown when a storage operation cannot proceed because the warehouse is full.
 */
public class StorageFullException extends Exception {

    public StorageFullException() {
        super();
    }

    public StorageFullException(String message) {
        super(message);
    }

    public StorageFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
