package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MyGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void removeNode(String label) {

    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw  new IllegalArgumentException();

        var existingList = adjacencyList.get(fromNode);
        existingList.add(toNode);
        adjacencyList.putIfAbsent(fromNode, existingList);
    }

    public void removeEdge(String from, String to) {

    }

    public void print() {

    }
}
