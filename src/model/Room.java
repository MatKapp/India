package model;

import java.util.ArrayList;

public class Room extends Location {
    private float area;

    public Room(int id, String name, float area) {
        super(id, name);
        this.area = area;
    }

    @Override
    public float getArea() {
        return area;
    }
}
