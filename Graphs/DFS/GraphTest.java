package Graphs.DFS;

import Graphs.DFS.Graph.TYPE;

public class GraphTest {
  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<>();

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    // should be 0 1 2 3 or 0 2 3 1
    graph.DFS(0, TYPE.RECURSIVE);

    // should be 2 0 1 3 or 2 3 0 1
    graph.DFS(2, TYPE.ITERATIVE);

    // should be 3
    graph.DFS(3, TYPE.RECURSIVE);

    // should be 1 2 0 3 or 1 2 3 0
    graph.DFS(1, TYPE.ITERATIVE);

    // should be 4
    System.out.println(graph.size());
  }
}
