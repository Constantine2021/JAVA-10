package by.bsu.lab10.tree;

import by.bsu.lab10.file.RoadsReader;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TreeBuilder {
    private TreeCitiesRoads tree;
    private List<Road> roads;
    private List<Node> addedCities;

    public TreeBuilder(File file){
        tree = new TreeCitiesRoads();
        ClassLoader classLoader = getClass().getClassLoader();
        roads = new RoadsReader().readFile(file);
    }
    public TreeCitiesRoads buildTree(){
        addMinskAndNeighbouringCities();
        addOtherCities();
        return tree;
    }

    private void addMinskAndNeighbouringCities(){
        List<Road> roadsWithMinsk = roads.stream()
                .filter((road) -> road.getStart().getCity().equals("Minsk") || road.getEnd().getCity().equals("Minsk"))
                .collect(Collectors.toList());
        roads = roads.stream()
                .filter(road -> !road.getStart().getCity().equals("Minsk") && !road.getEnd().getCity().equals("Minsk"))
                .collect(Collectors.toList());
        Node minsk = new Node("Minsk");
        tree.addNode(minsk);
        for (Road road: roadsWithMinsk){
            if (!road.getStart().getCity().equals("Minsk")){
                road.swapEnds();
            }
            tree.addRoadToNode(minsk, road);
        }
    }

    private void addOtherCities(){
        while(roads.size() > 0){
            for (Node node: tree.getHull()){
                List<Road> roadsWithNode = roads.stream()
                        .filter(road -> road.getStart().equals(node) || road.getEnd().equals(node))
                        .collect(Collectors.toList());
                roads.removeIf(roadsWithNode::contains);
                tree.addRoadsToNode(node, roadsWithNode);
            }
        }
    }
}
