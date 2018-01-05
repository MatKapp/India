import database.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

// The Java class will be hosted at the URI path "/helloworld/{index}"
@Path("/helloworld")
public class BuildingsController {

    @GET
    @Path("")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    public String doGet() {
        List<Integer> indexes = database.Database.getIndexes();
        String site = String.format("<form method=\"post\" action=\"helloworld\">\n", "");
        site += "<select name=\"Index\">\n";
        for (Integer index : indexes) {
            site += "<option>\n";
            site += index;
            site += "</option>\n";
        }
        site += "</select>\n";
        site += "<input type=\"submit\" value=\"Wybierz lokacje\" name=\"Submit\" /> \n";
        site += "</form>";
        return site;
    }

    @GET
    @Path("/{index}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public float getArea(@PathParam("index") int index) {
        return Database.getArea(index);
    }

    @POST
    @Path("")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response doPost(@FormParam("Index") int index) {
        return Response.status(200)
                .entity(Database.getArea(index))
                .build();
    }



}