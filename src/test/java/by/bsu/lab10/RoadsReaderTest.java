package by.bsu.lab10;

import static org.junit.Assert.assertEquals;

import by.bsu.lab10.file.RoadsReader;
import by.bsu.lab10.tree.Road;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class RoadsReaderTest {

    private final RoadsReader roadsReader;

    public RoadsReaderTest() {
        roadsReader = new RoadsReader();
    }

    @Test
    public void testReadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("citiesAndRoadsForTest.txt").getFile());
        List<Road> roads = roadsReader.readFile(file);

        assertEquals(6, roads.size());
    }
}
