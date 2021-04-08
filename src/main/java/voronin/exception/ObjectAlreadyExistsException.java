package voronin.exception;

import javassist.bytecode.stackmap.TypeData;

import java.util.NoSuchElementException;

public class ObjectAlreadyExistsException extends RuntimeException {

    public ObjectAlreadyExistsException(String className, String title) {
        super(className + " with name: " + title + "  already exists");
    }
    public ObjectAlreadyExistsException(String className, Long id) {
        super(className + " with " + id + " id already exists");
    }
}
