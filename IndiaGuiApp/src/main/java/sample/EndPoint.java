package sample;

/**
 * Models endpoint object
 * @author Piotr Gorny
 * @version 1.0
 */
public class EndPoint {
    public String url;
    public String typeName;

    /**
     * Constructor of the endpoint class
     * @param url URL to proper functionality on the server
     * @param typeName Type name of the proper functionality
     */
    EndPoint(String url, String typeName){
        this.url = url;
        this.typeName = typeName;
    }

    /**
     * Gives access to data
     * @param index Index of location to retrieve data
     * @return Data from a specific endpoint
     */
    public String GetData(int index) {
        return Connection.sendPost(index, url);
    }
}
