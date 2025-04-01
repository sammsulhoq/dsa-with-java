package graphs;

import java.sql.SQLOutput;
import java.util.*;

public class MyGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw  new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        for (var n: adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for(var entry: adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " is connected to " + Arrays.toString(entry.getValue().toArray()));
        }
    }
}
