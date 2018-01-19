package model;

public class HeatingVisitor implements Visitor {

    public double visit(Location location) {
        return location.getHeating();
    }
}
