package by.bsu.lab10.tree;

import java.util.Objects;

public class Road {
    private Node start;
    private Node end;
    private float weight;

    public Road(Node start, Node end, float weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Road(){
        start = new Node();
        end = new Node();
    }

    public void swapEnds(){
        Node temp = getStart();
        start = end;
        end = temp;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;
        Road road = (Road) o;
        return Float.compare(road.getWeight(), getWeight()) == 0 &&
                Objects.equals(getStart(), road.getStart()) &&
                Objects.equals(getEnd(), road.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd(), getWeight());
    }
}
