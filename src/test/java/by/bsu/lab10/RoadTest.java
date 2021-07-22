package by.bsu.lab10;

import static org.junit.Assert.assertEquals;

import by.bsu.lab10.tree.Node;
import by.bsu.lab10.tree.Road;
import org.junit.Test;

public class RoadTest {
    @Test
    public void testSwapEnds(){
        Road road = new Road(new Node("Test"), new Node("Test1"), 20);
        road.swapEnds();
        assertEquals("Test1", road.getStart().getCity());
        assertEquals("Test", road.getEnd().getCity());
    }
}
