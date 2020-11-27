package com.company;

public class WrongInputException extends RuntimeException {

    WrongInputException (String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Own exception: " + super.getMessage();
    }
}
