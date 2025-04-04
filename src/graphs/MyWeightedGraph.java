package graphs;

import java.util.*;

public class MyWeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        private List<Edge> getEdges() {
            return edges;
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
    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
    private Map<String, Node> nodes;

    public MyWeightedGraph() {
        nodes = new HashMap<>();
    }

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    /**
     * Returns shortest distance using Priority Queue and implementing
     * Dijkstra's algorithm
     * @param from Source
     * @param to   Destination
     * @return Shortest distance between two nodes
     */
    public int getShortestDistance(String from, String to) {
        var fromNode = nodes.get(from);

        Map<Node, Integer> distances = new HashMap<>();
        for (var node: nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);          // Setting the distance for the source node to 0

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        priorityQueue.add(new NodeEntry(fromNode, 0));

        while (!priorityQueue.isEmpty()) {
            var current = priorityQueue.remove().node;
            visited.add(current);

            for (var edge: current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(edge.to) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    priorityQueue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distances.get(nodes.get(to));
    }

    public void print() {
        for (var node: nodes.values()){
            System.out.println(node + " is connected to " + Arrays.toString(node.getEdges().toArray(new Edge[0])));
        }
    }
}
