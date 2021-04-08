package voronin.exception;

import java.util.NoSuchElementException;

public class ObjectNotFoundException extends NoSuchElementException {

    public ObjectNotFoundException(String className, String title) {
        super("No " + className + " with " + title + " name found");
    }
    public ObjectNotFoundException(String className, Long id) {
        super("No " + className + " with " + id + " id found");
    }
}
