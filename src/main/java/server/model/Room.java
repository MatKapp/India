package server.model;  // package model

/**
 * Models room object extends Location class, implementation of Composite design pattern
 * @author Jakub Sztyma
 * @version 1.0
 */
public class Room extends Location{

    /**
     * Room's area
     */
    private float area;

    /**
     * Room's cubage in m^3
     */
    private float cube;

    /**
     * Energy consumption on heating per cubage unit in room
     */
    private float heating;

    /**
     * Illuminance per area unit in room
     */
    private float light;

    /**
     *
     * @param id    id of the new room object
     * @param name  name of the new room object
     * @param area  area of the new room object
     * @param cube  cubage of the new room object
     * @param heating  energy consumption on heating per cubage unit in the new room object
     * @param light  illuminance per area unit in the new room object
     */
    public Room(int id, String name, float area, float cube, float heating, float light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Overrides getArea method from Location class, getter for area value
     * @return Area value of Room object
     */
    @Override
    public float getArea() {
        return area;
    }

    /**
     * Overrides getCube method from Location class, getter for cube value
     * @return Cubage value of Room object
     */
    @Override
    public float getCube() {
        return cube;
    }

    /**
     * Overrides getHeating method from Location class, getter for heating per cubage unit value
     * @return Energy consumption on heating per cubage unit in Room object
     */
    @Override
    public float getHeating() {
        return heating;
    }

    /**
     * Overrides getLight method from Location class, getter for lighting per area unit value
     * @return Illuminance per area unit in Room object
     */
    @Override
    public float getLight() {
        return light;
    }
}
