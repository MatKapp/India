import database.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld/{index}")
public class BuildingsController {

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public float getArea(@PathParam("index") int index) {
        return Database.getArea(index);
    }
}