package server.database;   // package database


import server.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Database mock
 * @author Piotr Gorny
 * @version 1.0
 */
public class Database {

    private static float alertTreshold = 7.5f;

    /**
     * List of locations in our Database object
     */
    private static List<Location> locations;

    /**
     * Resets values in Database
     */
    public static void reset(){
        //Create all locations
        Location room1 = new Room(1, "Room1", 1.0f, 3.0f, 5.0f, 10.0f);
        Location room2 = new Room(2, "Room2", 2.0f, 6.0f, 10.0f, 11.0f);
        Location room3 = new Room(3, "Room3", 3.0f, 7.0f, 7.0f, 15.0f);
        Location floor1 = new Location(4, "Floor1");
        Location floor2 = new Location(5, "Floor2");
        Location building1 = new Location(6, "Building1");

        //Add adequate children to locations
        floor1.addChild(room1);
        floor1.addChild(room2);
        floor2.addChild(room3);
        building1.addChild(floor1);
        building1.addChild(floor2);

        //Add all locations to array
        locations = new ArrayList<Location>();
        locations.add(room1);
        locations.add(room2);
        locations.add(room3);
        locations.add(floor1);
        locations.add(floor2);
        locations.add(building1);
    }

    /**
     * Sets 'locations' field
     * @param locations list of locations for test
     */

    public static void setLocationsForTests(List<Location> locations){
        Database.locations = locations;
    }

    public static List<Location> getLocations(){
        return locations;
    }

    /**
     *Finds the area of a specific location
     * @param index The location Id we are looking for
     * @return Area of location we are looking for
     */
    public static float getArea(int index){
        for(Location location : locations){
            if(location.getId() == index){
                return location.getArea();
            }
        }
        return 0.0f;
    }
    public static float getCube(int index){
        for(Location location : locations){
            if(location.getId() == index){
                return location.getCube();
            }
        }
        return 0.0f;
    }
    public static float getHeating(int index){
        for(Location location : locations){
            if(location.getId() == index){
                return location.getHeating();
            }
        }
        return 0.0f;
    }

    /**
     * checks if location's children have heating values over alert treshold
     * @param index
     * @return
     */

    public static String checkHeatingAlert(int index){
        String stringResult = "";
        for(Location location : locations){
            if(location.getId() == index){
                HeatingVisitor visitor = new HeatingVisitor();
                for(Location room : location.getChildren()){
                    if(room.accept(visitor) >= alertTreshold){
                        stringResult += room.getName();
                        stringResult += String.format(",%n");;
                    }
                }
                break;
            }
        }
        return stringResult;
    }

    public static float getLight(int index){
        for(Location location : locations){
            if(location.getId() == index){
                return location.getLight();
            }
        }
        return 0.0f;
    }
}
