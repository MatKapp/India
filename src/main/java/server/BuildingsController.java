package server;
import server.database.Database;
import server.model.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


// The Java class will be hosted at the URI path "/india/{index}"
@Path("/india")
public class BuildingsController {

    @GET
    @Path("")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    public String doGet() {
//        List<Integer> indexes = new ArrayList();
//        List<Location> locations = Database.getLocations();
//        for (Location location: locations){
//            indexes.add(location.getId());
//        }
//
//        String site = String.format("<form method=\"post\" action=\"india\">\n", "");
//        site += "<select name=\"Index\">\n";
//        for (Integer index : indexes) {
//            site += "<option>\n";
//            site += index;
//            site += "</option>\n";
//        }
//        site += "</select>\n";
//        site += "<input type=\"submit\" value=\"Wybierz lokacje\" name=\"Submit\" /> \n";
//        site += "</form>";
        String site = "<html>\n" +
                "      <head>\n" +
                "          <meta charset=\"UTF-8\">\n" +
                "      </head>\n" +
                "      <body>\n" +
                "           <h1>W celu sprawdzenia budynków należu uruchomić aplikację</h1>" +
                "      </body>\n" +
                "</html>";
        return site;
    }

    @GET
    @Path("/locations")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response doGetLocations() {
        List<Location> locations = Database.getLocations();
        return Response.status(200)
                .entity(locations)
                .build();
    }

    @POST
    @Path("/checkHeatingAlert")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response doCheckHeatingAlert(@FormParam("Index") int index) {
        String locations = Database.checkHeatingAlert(index);
        return Response.status(200)
                .entity(locations)
                .build();
    }

    @POST
    @Path("/area")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getArea(@FormParam("Index") int index) {
        return Response.status(200)
                .entity(Database.getArea(index))
                .build();
    }

    @POST
    @Path("/cube")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getCube(@FormParam("Index") int index) {
        return Response.status(200)
                .entity(Database.getCube(index))
                .build();
    }

    @POST
    @Path("/heating")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getHeating(@FormParam("Index") int index) {
        return Response.status(200)
                .entity(Database.getHeating(index))
                .build();
    }

    @POST
    @Path("/light")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getLight(@FormParam("Index") int index) {
        return Response.status(200)
                .entity(Database.getLight(index))
                .build();
    }

}