package sample;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.api.client.config.*;
import com.sun.jersey.api.client.*;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Connection {

    // HTTP GET request
    public static List<Location> GetLocations(String url) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri(url).build());

        ClientResponse response = service.accept("application/json")
                .get(ClientResponse.class);


        if(response.getStatus()!=200){
            return new ArrayList<Location>();
        }
        else {
            String json = response.getEntity(String.class);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Location>>() {}.getType();
            System.out.println(json);
            List<Location> fromJson = gson.fromJson(json, type);

            return fromJson;
        }
    }

    public static String sendPost(int index, String url) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri(url).build());

        Form f = new Form();
        f.add("Index", index);

        String y = service.post(String.class,f);

        return y;


//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost("http://localhost:8080/India_war_exploded/helloworld");
//
//        Form f = new Form();
//        f.add("userId", "foo");
//        f.add("deviceId", "bar");
//        f.add("comments", "Device");
//
//        try {
//            HttpResponse response = client.execute(post);
//
//            HttpEntity x = response.getEntity();
//            // Print out the response message
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
