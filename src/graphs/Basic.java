package graphs;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        MyGraph directedGraph = new MyGraph();
        directedGraph.addNode("A");
        directedGraph.addNode("B");
        directedGraph.addNode("C");
        directedGraph.addNode("D");

        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("B", "D");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("C", "D");

        directedGraph.print();

        // Testing DFS
        directedGraph.traverseDepthFirst("A");

        // Testing DFS iteratively
        directedGraph.traverseDepthFirstIteratively("A");

        // Testing Breadth First traversal
        directedGraph.traverseBreadthFirstIteratively("A");

        directedGraph.removeEdge("A", "C");
        directedGraph.print();

        directedGraph.removeNode("B");
        directedGraph.print();

        // Testing Topological Sort
        System.out.println(Arrays.toString(directedGraph.topologicalSort().toArray()));

        System.out.println(directedGraph.hasCycle());
    }
}
