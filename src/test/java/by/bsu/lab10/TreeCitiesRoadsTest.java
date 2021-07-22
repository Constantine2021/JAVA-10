package by.bsu.lab10;

import by.bsu.lab10.tree.Node;
import by.bsu.lab10.tree.Road;
import by.bsu.lab10.tree.TreeBuilder;
import by.bsu.lab10.tree.TreeCitiesRoads;
import by.bsu.lab10.tree.RoadRouteFormatter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
Во входном файле хранится информация о системе главных автодорог, связывающих г. Минск с другими городами Беларуси. Используя эту информацию,
построить дерево, отображающее систему дорог республики, а затем, продвигаясь по дереву, определить минимальный по длине путь из г. Минска в другой
заданный город. Предусмотреть возможность сохранения дерева в виртуальной памяти.
 */
public class TreeCitiesRoadsTest {

    @Test
    public void testFindShortestRoute(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("citiesAndRoads.txt").getFile());
        TreeCitiesRoads treeCitiesRoads = new TreeBuilder(file).buildTree();
        Node node = treeCitiesRoads.getNode("Vitebsk");
        float routeWeight = 0.f;
        List<Road> roads = treeCitiesRoads.findShortestRoute(new ArrayList<>(), node);
        for (Road road: roads){
            routeWeight += road.getWeight();
        }
        System.out.println(new RoadRouteFormatter().formatRoute(roads));
        //assertEquals(routeWeight, 176.3f, 0.1);
    }
}
