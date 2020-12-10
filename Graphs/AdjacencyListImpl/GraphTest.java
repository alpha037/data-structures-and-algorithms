package Graphs.AdjacencyListImpl;

public class GraphTest {
  public static void main(String[] args) {
    Graph graph = new Graph();

    // Adding vertices
    graph.addVertex("Alpha");
    graph.addVertex("Bravo");
    graph.addVertex("Charlie");
    graph.addVertex("Delta");
    graph.addVertex("Echo");

    // Add edges
    graph.addEdge("Alpha", "Bravo");
    graph.addEdge("Alpha", "Delta");
    graph.addEdge("Bravo", "Charlie");
    graph.addEdge("Delta", "Charlie");
    graph.addEdge("Bravo", "Echo");
    graph.addEdge("Delta", "Echo");

    // should be Bravo Delta
    graph.displayVertices("Alpha");

    // should be Bravo
    System.out.println(graph.removeVertex("Bravo").getKey());

    // should be No vertices present.
    graph.displayVertices("Bravo");

    graph.removeEdge("Alpha", "Bravo");

    // should be No vertices present.
    graph.displayVertices("Bravo");

    // should be Delta
    graph.displayVertices("Alpha");
  }
}
