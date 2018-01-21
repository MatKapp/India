package server.model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class RoomTest {
    private Room room1;
    private Room room2;
    private Room room3;

    @Before
    public void setUp() throws Exception {
        Location room1 = new Room(1, "Room1", 1.0f, 3.0f, 5.0f, 10.0f);
        Location room2 = new Room(2, "Room2", 3.0f, 7.0f, 7.0f, 1.0f);
        Location room3 = new Room(3, "Room3", 1000.4f, 2000.8f, 1.5f, 1.1f);
    }

    @Test
    public void testGetHeating() {
        assertTrue(room1.getHeating() == 5.0f);
        assertTrue(room2.getHeating() == 7.0f);
        assertTrue(room3.getHeating() == 1.5f);
    }

    @Test
    public void testGetArea() {
        assertTrue(room1.getArea() == 1.0f);
        assertTrue(room2.getArea() == 3.0f);
        assertTrue(room3.getArea() == 1000.4f);
    }

    @Test
    public void testGetCube() {
        assertTrue(room1.getCube() == 3.0f);
        assertTrue(room2.getCube() == 7.0f);
        assertTrue(room3.getCube() == 2000.8f);
    }

    @Test
    public void testGetLight() {
        assertTrue(room1.getLight() == 10.0f);
        assertTrue(room2.getLight() == 1.0f);
        assertTrue(room3.getLight() == 1.1f);
    }

    @Test
    public void testGetName() {
        assertTrue(room1.getName() == "Room1");
        assertTrue(room2.getName() == "Room2");
        assertTrue(room3.getName() == "Room3");
    }

}
