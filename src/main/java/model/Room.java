package model;  // package model

/**
 * Models room object extends Location class, implementation of Composite design pattern
 * @author Jakub Sztyma
 * @version 1.0
 */
public class Room extends Location {

    /**
     * Room's area
     */
    private float area;

    /**
     *
     * @param id    id of the new room object
     * @param name  name of the new room object
     * @param area  area of the new room object
     */
    public Room(int id, String name, float area) {
        super(id, name);
        this.area = area;
    }

    /**
     * Overrides getArea method from Location class, getter for area value
     * @return Area value of Room object
     */
    @Override
    public float getArea() {
        return area;
    }
}
