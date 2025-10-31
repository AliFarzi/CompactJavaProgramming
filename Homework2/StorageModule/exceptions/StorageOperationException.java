package Homework2.StorageModule.exceptions;

public class StorageOperationException extends Exception {
    public StorageOperationException(String message, Throwable cause) {
        super(message, cause); // <- chaining
    }
}
