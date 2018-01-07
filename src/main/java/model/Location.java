package model;  // package model

import java.util.ArrayList;

/**
 * Models location object, implementation of Composite design pattern
 * @author Jakub Sztyma
 * @version 1.0
 */
public class Location {

    /**
     * Location's Id
     */
    private int id;

    /**
     * Location's Name
     */
    private String Name;

    /**
     * Location's childred, the child's type is Location
     */
    private ArrayList<Location> children;

    /**
     * Constructor of the Location class
     * @param id    id of the new location object
     * @param name  name of the new location object
     */
    public Location(int id, String name) {
        this.id = id;
        Name = name;
        this.children = new ArrayList<Location>();
    }

    /**
     * Adds child to location object
     * @param child new child(Location) that will be added to children ArrayList
     */
    public void addChild(Location child){
        this.children.add(child);
    }

    /**
     * Id getter
     * @return Id of the location object
     */
    public int getId() {
        return id;
    }

    /**
     * Name getter
     * @return Name of the location object
     */
    public String getName() {
        return Name;
    }

    /**
     * Sums up the area of children
     * @return Total area
     */
    public float getArea(){
        float totalArea = 0.0f;
        for(Location child : children){
            totalArea += child.getArea();
        }
        return totalArea;
    }
}