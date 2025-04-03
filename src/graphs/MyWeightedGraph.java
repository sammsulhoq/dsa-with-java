package graphs;

import java.util.*;

public class MyWeightedGraph {
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
    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to + "(" + weight + ")";
        }
    }
    private Map<String, Node> nodes;
    private Map<Node, List<Edge>> adjacencyList;

    public MyWeightedGraph() {
        nodes = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        var edge = new Edge(fromNode, toNode, weight);
        adjacencyList.putIfAbsent(fromNode, new ArrayList<>());
        adjacencyList.putIfAbsent(toNode, new ArrayList<>());

        adjacencyList.get(fromNode).add(edge);
        adjacencyList.get(toNode).add(edge);
    }

    public void print() {
        for(var entry: adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " is connected to " + Arrays.toString(entry.getValue().toArray()));
        }
    }
}
