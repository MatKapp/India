package server.model;

/**
 * One of the implementations of the Visitor interface
 * @author Mateusz Kapiszewski
 * @version 1.0
 */

public class HeatingVisitor implements Visitor {

    /**
     *
     * @param location Location to check heating value
     * @return
     */
    public double visit(Location location) {
        return location.getHeating();
    }
}
