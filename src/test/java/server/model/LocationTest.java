package server.model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LocationTest {
    private Location floor1;
    private Location floor2;
    private Location building1;
    private Room room1;
    private Room room2;
    private Room room3;

    @Before
    public void setUp() throws Exception {
        room1 = mock(Room.class);
        when(room1.getArea()).thenReturn(1.0f);
        when(room1.getCube()).thenReturn(3.0f);
        when(room1.getHeating()).thenReturn(5.0f);
        when(room1.getLight()).thenReturn(10.0f);

        room2 = mock(Room.class);
        when(room2.getArea()).thenReturn(3.0f);
        when(room2.getCube()).thenReturn(5.0f);
        when(room2.getHeating()).thenReturn(1.0f);
        when(room2.getLight()).thenReturn(2.0f);

        room3 = mock(Room.class);
        when(room3.getArea()).thenReturn(1000.4f);
        when(room3.getCube()).thenReturn(2000.8f);
        when(room3.getHeating()).thenReturn(1.1f);
        when(room3.getLight()).thenReturn(1.9f);

        floor1 = new Location(1, "Floor1");
        floor2 = new Location(2, "Floor2");
        building1 = new Location(3, "Building1");

        floor1.addChild(room1);
        floor1.addChild(room2);
        floor2.addChild(room3);
        building1.addChild(floor1);
        building1.addChild(floor2);
    }

    @Test
    public void testGetArea() {
        assertTrue(floor1.getArea() == 4.0f);
        verify(room1).getArea();
        verify(room2).getArea();

        assertTrue(floor2.getArea() == 1000.4f);
        verify(room3).getArea();

        assertTrue(building1.getArea() == 1004.4f);
        verify(room1, times(2)).getArea();
        verify(room2, times(2)).getArea();
        verify(room3, times(2)).getArea();
    }

    @Test
    public void testGetCube() {
        assertTrue(floor1.getCube() == 8.0f);
        verify(room1).getCube();
        verify(room2).getCube();

        assertTrue(floor2.getCube() == 2000.8f);
        verify(room3).getCube();

        assertTrue(building1.getCube() == 2008.8f);
        verify(room1, times(2)).getCube();
        verify(room2, times(2)).getCube();
        verify(room3, times(2)).getCube();
    }

    @Test
    public void testGetHeating() {
        assertTrue(floor1.getHeating() == 2.5f);
        verify(room1).getHeating();
        verify(room1, times(2)).getCube();
        verify(room2).getHeating();
        verify(room1, times(2)).getCube();

        assertTrue(floor2.getHeating() == 1.1f);
        verify(room3).getHeating();
        verify(room3, times(2)).getCube();

        assertTrue(building1.getHeating() == 1.1055756f);
        verify(room1, times(2)).getHeating();
        verify(room1, times(6)).getCube();
        verify(room2, times(2)).getHeating();
        verify(room2, times(6)).getCube();
        verify(room3, times(2)).getHeating();
        verify(room3, times(6)).getCube();
    }

    @Test
    public void testGetLight() {
        assertTrue(floor1.getLight() == 4.0f);
        verify(room1).getLight();
        verify(room1, times(2)).getArea();
        verify(room2).getLight();
        verify(room1, times(2)).getArea();

        assertTrue(floor2.getLight() == 1.9f);
        verify(room3).getLight();
        verify(room3, times(2)).getArea();

        assertTrue(building1.getLight() == 1916.76f/1004.4f);
        verify(room1, times(2)).getLight();
        verify(room1, times(6)).getArea();
        verify(room2, times(2)).getLight();
        verify(room2, times(6)).getArea();
        verify(room3, times(2)).getLight();
        verify(room3, times(6)).getArea();
    }

    @Test
    public void testGetName() {
        assertEquals(floor1.getName(), "Floor1");
        assertEquals(floor2.getName(), "Floor2");
        assertEquals(building1.getName(), "Building1");
    }

    @Test
    public void testGetId() {
        assertTrue(floor1.getId() == 1);
        assertTrue(floor2.getId() == 2);
        assertTrue(building1.getId() == 3);
    }

}
