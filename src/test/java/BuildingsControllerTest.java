import database.Database;
import model.Location;
import model.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BuildingsControllerTest {

    private BuildingsController buildingsController;

    @Before
    public void setUp() throws Exception {
        buildingsController = new BuildingsController();
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
        List<Location> locations = new ArrayList<Location>();
        locations.add(room1);
        locations.add(room2);
        locations.add(room2);
        locations.add(room3);
        locations.add(floor1);
        locations.add(floor2);
        locations.add(building1);
        Database.setLocationsForTests(locations);
    }

    @Test
    public void testGetArea() {
        assertEquals(buildingsController.getArea(1),1.0f,0.1f);
        assertEquals(buildingsController.getArea(2),2.0f,0.1f);
        assertEquals(buildingsController.getArea(3),3.0f,0.1f);
        assertEquals(buildingsController.getArea(6),6.0f,0.1f);
    }

    @Test
    public void testDoPost() {
        assertEquals(buildingsController.doPost(1).getEntity(),1.0f);
        assertEquals(buildingsController.doPost(2).getEntity(),2.0f);
        assertEquals(buildingsController.doPost(3).getEntity(),3.0f);
        assertEquals(buildingsController.doPost(6).getEntity(),6.0f);
    }

    @Test
    public void testDoPostType() {
        assertTrue(buildingsController.doPost(1).getEntity() instanceof Float);
        assertTrue(buildingsController.doPost(2).getEntity() instanceof Float);
        assertTrue(buildingsController.doPost(3).getEntity() instanceof Float);
        assertTrue(buildingsController.doPost(6).getEntity() instanceof Float);
    }

    @Test
    public void testDoPostAndGetArea() {
        assertEquals(buildingsController.doPost(1).getEntity(),buildingsController.getArea(1));
        assertEquals(buildingsController.doPost(2).getEntity(),buildingsController.getArea(2));
        assertEquals(buildingsController.doPost(3).getEntity(),buildingsController.getArea(3));
        assertEquals(buildingsController.doPost(6).getEntity(),buildingsController.getArea(6));
    }

    @Test
    public void testDatabase() {
        assertEquals(buildingsController.doPost(1).getEntity(),Database.getArea(1));
        assertEquals(buildingsController.doPost(2).getEntity(),Database.getArea(2));
        assertEquals(buildingsController.doPost(3).getEntity(),Database.getArea(3));
        assertEquals(buildingsController.doPost(6).getEntity(),Database.getArea(6));
        assertEquals(buildingsController.getArea(1),Database.getArea(1),0.1);
        assertEquals(buildingsController.getArea(2),Database.getArea(2),0.1);
        assertEquals(buildingsController.getArea(3),Database.getArea(3),0.1);
        assertEquals(buildingsController.getArea(6),Database.getArea(6),0.1);
    }
}
