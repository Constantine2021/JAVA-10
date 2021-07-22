package by.bsu.lab10.tree;

import java.util.List;

public class RoadRouteFormatter {
    public String formatRoute(List<Road> route){
        float routeWeight = 0.f;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = route.size() - 1; i != -1; i--){
            Road road = route.get(i);
            routeWeight += road.getWeight();
            stringBuilder.append(road.getStart().getCity()).append("->");
        }
        stringBuilder.append(route.get(0).getEnd().getCity()).append(" ");
        return stringBuilder.toString();
    }
}
