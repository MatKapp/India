package sample;

public class EndPoint {
    public String url;
    public String typeName;

    EndPoint(String url, String typeName){
        this.url = url;
        this.typeName = typeName;
    }

    public String GetData(int index) {
        return Connection.sendPost(index, url);
    }
}
