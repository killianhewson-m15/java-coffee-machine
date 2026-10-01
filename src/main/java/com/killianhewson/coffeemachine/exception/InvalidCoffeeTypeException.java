package com.killianhewson.coffeemachine.exception;

/** Thrown when the user enters a coffee type that is not available. */
public class InvalidCoffeeTypeException extends Exception {

    public InvalidCoffeeTypeException(String message) {
        super(message);
    }
}

