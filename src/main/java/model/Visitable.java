package model;

public interface Visitable {
    public double accept(Visitor visitor);
}
