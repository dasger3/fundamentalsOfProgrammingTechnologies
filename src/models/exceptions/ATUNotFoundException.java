package models.exceptions;

import java.util.NoSuchElementException;

public class ATUNotFoundException extends NoSuchElementException {

    public ATUNotFoundException(String title) {
        super("No ATU with " + title + " found");
    }
}
