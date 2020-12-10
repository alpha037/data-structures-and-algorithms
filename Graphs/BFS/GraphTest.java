package Graphs.BFS;

import Graphs.BFS.Graph.TYPE;

public class GraphTest {
  public static void main(String[] args) {
    Graph<String> graph = new Graph<>();

    graph.addEdge("0", "1");
    graph.addEdge("0", "2");
    graph.addEdge("1", "2");
    graph.addEdge("2", "0");
    graph.addEdge("2", "3");
    graph.addEdge("3", "3");

    // should be 0 1 2 3
    graph.BFS("0", TYPE.ITERATIVE);

    // should be 2 0 3 1
    graph.BFS("2", TYPE.RECURSIVE);

    // should be 3
    graph.BFS("3", TYPE.ITERATIVE);

    // should be 1 2 0 3
    graph.BFS("1", TYPE.RECURSIVE);

    // should be 4
    System.out.println(graph.size());
  }
}
