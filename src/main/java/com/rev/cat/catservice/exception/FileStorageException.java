package com.rev.cat.catservice.exception;

/**
 * @author rveizaga
 */
public class FileStorageException extends RuntimeException{

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
