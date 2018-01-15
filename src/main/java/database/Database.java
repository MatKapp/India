package database;

import model.Location;
import model.Room;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Location> locations;

    public static void reset(){
        //Create all locations
        Location room1 = new Room(1, "Room1", 1.0f);
        Location room2 = new Room(2, "Room2", 2.0f);
        Location room3 = new Room(3, "Room3", 3.0f);
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

    public static void setLocationsForTests(List<Location> locations){
        Database.locations = locations;
    }

    public static List<Location> getLocations(){
        return locations;
    }

    public static float getArea(int index){
        for(Location location : locations){
            if(location.getId() == index){
                return location.getArea();
            }
        }
        return 0.0f;
    }
}
