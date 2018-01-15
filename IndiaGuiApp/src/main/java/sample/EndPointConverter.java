package sample;

import javafx.util.StringConverter;

public class EndPointConverter extends StringConverter<EndPoint> {

    public String toString(EndPoint object) {
        return object.typeName;
    }

    public EndPoint fromString(String string) {
        return new EndPoint(string,string);
    }
}
