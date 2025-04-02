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

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            var result = hasCycle(current, all, visiting, visited);
            if (result)
                return true;
        }

        return false;
    }

    public void traverseBreadthFirstIteratively(String label) {
        var root = nodes.get(label);
        if (root == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current))
                continue;

            System.out.println(current.label);
            visited.add(current);

            for (var node: adjacencyList.get(current))
                if (!visited.contains(current))
                    queue.add(node);
        }
    }

    public void traverseDepthFirstIteratively(String label) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        var root = nodes.get(label);
        if (root == null)
            return;

        stack.push(root);

        while(!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var node: adjacencyList.get(current))
                if (!visited.contains(node))
                    stack.push(node);
        }
    }

    public void traverseDepthFirst(String label) {
        traverseDepthFirst(nodes.get(label), new HashSet<>());
    }

    public List<String> topologicalSort() {
        List<String> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node: nodes.values())
            topologicalSort(node, visited, stack);

        while(!stack.isEmpty()) {
            var current = stack.pop();
            result.add(current.label);
        }

        return result;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (node == null || visited.contains(node))
            return;

        visited.add(node);

        for (var n: adjacencyList.get(node))
            topologicalSort(n, visited, stack);

        stack.push(node);
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        if (root == null)
            return;

        System.out.println(root);
        visited.add(root);

        for (var node: adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirst(node, visited);
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visited.add(node);

        for (var n: adjacencyList.get(node)){
            if (visited.contains(n))
                continue;

            if (visited.contains(n))
                return true;

            var result = hasCycle(n, all, visiting, visited);
            if (result)
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
