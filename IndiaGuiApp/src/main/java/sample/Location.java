package sample;

/**
 * Models location object
 * @author Piotr Gorny
 * @version 1.0
 */

public class Location {

    /**
     * Location's id
     */
    public int id;

    /**
     * Location's name
     */
    public String name;

    /**
     * Location object's constructor
     * @param id location's id
     * @param name location's name
     */
    Location(int id, String name){
        this.id = id;
        this.name = name;
    }
}
