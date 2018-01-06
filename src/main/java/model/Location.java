package model;

import java.util.ArrayList;

public class Location {
    private int id;
    private String Name;
    private ArrayList<Location> children;


    public Location(int id, String name) {
        this.id = id;
        Name = name;
        this.children = new ArrayList<Location>();
    }

    public void addChild(Location child){
        this.children.add(child);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public float getArea(){
        float totalArea = 0.0f;
        for(Location child : children){
            totalArea += child.getArea();
        }
        return totalArea;
    }
}
