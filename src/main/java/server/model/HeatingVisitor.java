package server.model;

public class HeatingVisitor implements Visitor {

    public double visit(Location location) {
        return location.getHeating();
    }
}
