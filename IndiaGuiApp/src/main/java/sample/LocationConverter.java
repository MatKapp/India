package sample;

import javafx.util.StringConverter;

public class LocationConverter extends StringConverter<Location> {

    public String toString(Location object) {
        return object.name;
    }

    public Location fromString(String string) {
        return new Location(1,string);
    }
}
