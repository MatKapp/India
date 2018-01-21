package server.model;  // package model

import java.util.ArrayList;

/**
 * Models location object, implementation of Composite design pattern Implement Visitable interface
 * @author Jakub Sztyma
 * @version 1.0
 */
public class Location implements Visitable{

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


    public ArrayList<Location> getChildren() {
        return this.children;
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

    /**
     * Sums up the cubage of children
     * @return Total cubage
     */
    public float getCube(){
        float totalCube = 0.0f;
        for(Location child : children){
            totalCube += child.getCube();
        }
        return totalCube;
    }

    /**
     * Counts avarage energy consumption on heating of children
     * @return Avarage energy consumption on heating
     */
    public float getHeating(){
        float totalCube = 0.0f;
        float totalHeating = 0.0f;
        for(Location child : children){
            totalCube += child.getCube();
            totalHeating += child.getHeating()*child.getCube();
        }
        return totalHeating/totalCube;
    }

    /**
     * Counts avarage illuminance per area unit of children
     * @return Avarage illuminance
     */
    public float getLight(){
        float totalArea = 0.0f;
        float totalLight = 0.0f;
        for(Location child : children){
            totalArea += child.getArea();
            totalLight += child.getLight()*child.getArea();
        }
        return totalLight/totalArea;
    }

    /**
     *Required method for Visitor design pattern
     * @param visitor  interface
     * @return  Heating od location
     */

    public double accept(Visitor visitor) {
        return this.getHeating();
    }
}
