package com.stepit.lecture.genericshop.exception;

public class UserNotFoundException extends RuntimeException {

    private final String MESSAGE = "API not able to find a user, reason: %s";
    private String custom_message;

    public UserNotFoundException(String message) {
        super(message);
        custom_message = message;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, custom_message);
    }
}
