package exceptions;

import java.util.NoSuchElementException;

public class ATUNotFoundException extends NoSuchElementException {

    public ATUNotFoundException(String title) {
        super("No ATU with " + title + " found");
    }
    public ATUNotFoundException(Long id) {
        super("No ATU with " + id + "id found");
    }
}
