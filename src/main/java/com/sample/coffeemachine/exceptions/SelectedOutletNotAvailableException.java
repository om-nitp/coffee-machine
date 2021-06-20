package com.sample.coffeemachine.exceptions;

public class SelectedOutletNotAvailableException extends RuntimeException {
    private static final String message = " is not available.";

    public SelectedOutletNotAvailableException(String name) {
        super(name + message);
    }
}
