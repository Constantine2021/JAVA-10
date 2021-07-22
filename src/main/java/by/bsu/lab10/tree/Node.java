package by.bsu.lab10.tree;

import java.util.Objects;

public class Node {
    private String city;

    public Node(String city){
        this.city = city;
    }

    public Node(){};

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getCity(), node.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity());
    }

    @Override
    public String toString() {
        return "[city ".concat(getCity()).concat(" ]");
    }
}
