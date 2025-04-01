package graphs;

public class Basic {
    public static void main(String[] args) {
        MyGraph directedGraph = new MyGraph();
        directedGraph.addNode("A");
        directedGraph.addNode("B");
        directedGraph.addNode("C");

        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "C");
        directedGraph.addEdge("B", "C");

        directedGraph.print();
    }
}
