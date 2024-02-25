package com.example.demoapi.exceptions;

public class NoAnyContentException extends RuntimeException{
    public NoAnyContentException() {
        super("No any content");
    }

    public NoAnyContentException(String message) {
        super(message);
    }
}
