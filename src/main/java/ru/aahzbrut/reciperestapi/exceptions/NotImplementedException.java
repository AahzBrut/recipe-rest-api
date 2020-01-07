package ru.aahzbrut.reciperestapi.exceptions;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException() {
        super("This feature is not implemented yet.");
    }
}
