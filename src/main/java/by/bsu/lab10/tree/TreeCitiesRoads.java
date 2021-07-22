package by.bsu.lab10.tree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeCitiesRoads {
    private Node root;
    private Map<Node, ArrayList<Road>> roads;
    private List<Node> hull;

    public TreeCitiesRoads(){
        root = new Node();
        roads = new Hashtable<>();
    }

    public TreeCitiesRoads(Node root){
        this.root = root;
        roads = new Hashtable<>();
    }

    public TreeCitiesRoads(Node root, Hashtable<Node, ArrayList<Road>> roads){
        this.root = root;
        this.roads = roads;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<Node> getHull(){
        return hull;
    }

    public void addNode(Node node){
        if (roads.keySet().size() == 0){
            setRoot(node);
        }
        this.roads.put(node, new ArrayList<>());
        formHull();
    }

    public void addRoadToNode(Node node, Road road){
        if (!road.getStart().equals(node)){
            road.swapEnds();
        }
        this.roads.get(node).add(road);
        if (!roads.containsKey(road.getEnd())){
            roads.put(road.getEnd(), new ArrayList<>());
        }
        formHull();
    }

    public void addRoadsToNode(Node node, List<Road> roads){
        for (Road road: roads){
            if (!road.getStart().equals(node)){
                road.swapEnds();
            }
            this.roads.get(node).add(road);
            if (!this.roads.containsKey(road.getEnd())){
                this.roads.put(road.getEnd(), new ArrayList<>());
            }
        }
        formHull();
    }

    private void formHull(){
        hull = roads.keySet().stream().filter(node -> roads.get(node).size() == 0).collect(Collectors.toList());
    }

    public float calculateRouteWeight(List<Road> route){
        float routeWeight = 0.f;
        for (Road road: route){
            routeWeight += road.getWeight();
        }
        return routeWeight;
    }

    public List<Road> findShortestRoute(List<Road> route, Node city){
        Road road = getShortestRoad(city);
        route.add(road);
        if (road.getStart().getCity().equals("Minsk")){
            return route;
        }
        else{
            return findShortestRoute(route, road.getStart());
        }
    }

    private Road getShortestRoad(Node city){
        List<Road> shortestRoadToCity = findShortestRoadToCity(city);
        return shortestRoadToCity.stream()
                .sorted((road1, road2) -> (int) (road1.getWeight() - road2.getWeight()))
                .collect(Collectors.toList())
                .get(0);
    }

    private List<Road> findShortestRoadToCity(Node city){
        List<Node> nodesWithCity = roads.keySet().stream()
                .filter(node -> {
                    List<Road> currentRoads = roads.get(node);
                    return currentRoads.stream().map(Road::getEnd).collect(Collectors.toList()).contains(city);
                })
                .collect(Collectors.toList());
        List<Road> shortestRoadsToCity = new ArrayList<>();
        for (Node node: nodesWithCity){
            Road shortestRoad = roads.get(node).stream()
                    .sorted((road1, road2) -> (int) (road1.getWeight() - road2.getWeight()))
                    .filter(road -> road.getEnd().equals(city))
                    .collect(Collectors.toList())
                    .get(0);
            shortestRoadsToCity.add(shortestRoad);
        }
        return shortestRoadsToCity;
    }

    public Node getNode(String city) {
        Node nodeWithCity = null;
        for (Node node: roads.keySet()){
            if (node.getCity().equals(city)){
                nodeWithCity = node;
            }
        }
        return nodeWithCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeCitiesRoads)) return false;
        TreeCitiesRoads that = (TreeCitiesRoads) o;
        return Objects.equals(getRoot(), that.getRoot()) &&
                Objects.equals(roads, that.roads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoot(), roads);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeBuilder{");
        sb.append("root=").append(root);
        sb.append(", roads=").append(roads);
        sb.append('}');
        return sb.toString();
    }
}
