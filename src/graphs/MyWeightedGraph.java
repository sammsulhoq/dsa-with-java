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
    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        // Populating the distances for each of the node to MAX
        Map<Node, Integer> distances = new HashMap<>();
        for (var node: nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);          // Setting the distance for the source node to 0

        Set<Node> visited = new HashSet<>();
        Map<Node, Node> previousNodes = new HashMap<>();

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
                    previousNodes.put(edge.to, current);            // Updating the previous node
                    priorityQueue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNodes, toNode);
    }

    public MyWeightedGraph getMinimumSpanningTree() {
        var tree = new MyWeightedGraph();
        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge: nextNode.getEdges()) {
                if (!tree.containsNode(edge.to.label)) {
                    edges.add(edge);
                }
            }
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }

    public void print() {
        for (var node: nodes.values()){
            System.out.println(node + " is connected to " + Arrays.toString(node.getEdges().toArray(new Edge[0])));
        }
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        for (var node: nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return  true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);
        for (var edge: node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to))
                return true;

            var result = hasCycle(edge.to, node, visited);
            if (result)
                return  true;
        }

        return false;
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }

        return path;
    }
}
