package server.model;

/**
 * Allows the Visitor to pass the object so the right operations occur on the righttype of object.
 * @author Mateusz Kapiszewski
 * @version 1.0
 */

public interface Visitable {

    /**
     *accept() is passed the same visitor object but then the method visit() is called using the visitor object. The right version of visit() is called because of method overloading
     * @param visitor the corresponding object implementing the Visitor interface
     * @return
     */
    public double accept(Visitor visitor);
}
