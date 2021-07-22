package by.bsu.lab10;

import static org.junit.Assert.assertEquals;

import by.bsu.lab10.tree.TreeBuilder;
import by.bsu.lab10.tree.TreeCitiesRoads;
import org.junit.Test;

import java.io.File;

public class TreeBuilderTest {

    @Test
    public void testBuildTree(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("citiesAndRoads.txt").getFile());
        TreeCitiesRoads treeCitiesRoads = new TreeBuilder(file).buildTree();
    }
}
