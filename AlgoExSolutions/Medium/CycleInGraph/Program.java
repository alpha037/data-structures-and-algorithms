package AlgoExSolutions.Medium.CycleInGraph;

import java.util.*;

/**
 * * Cycle In Graph
 */
class Program {
  public final int WHITE = 0;
  public final int GRAY = 1;
  public final int BLACK = 2;

  public boolean cycleInGraph(int[][] edges) {
    int[] colors = new int[edges.length];
    Arrays.fill(colors, WHITE);

    for (int vertex = 0; vertex < edges.length; vertex++) {
      if (colors[vertex] != WHITE) continue;

      if (hasCycle(edges, vertex, colors)) return true;
    }

    return false;
  }

  private boolean hasCycle(int[][] edges, int vertex, int[] colors) {
    colors[vertex] = GRAY;

    for (int neighbor : edges[vertex]) {
      if (colors[neighbor] == GRAY) return true;

      if (colors[neighbor] == BLACK) continue;

      if (hasCycle(edges, neighbor, colors)) return true;
    }

    colors[vertex] = BLACK;

    return false;
  }

  /**
   * * TC: O(w * h)
   * * SC: O(w * h)
   */
  // public boolean cycleInGraph(int[][] edges) {
  //   // Write your code here.
  //   int len = edges.length;
  //   boolean[] visited = new boolean[len];
  //   boolean[] inStack = new boolean[len];

  //   for (int vertex = 0; vertex < len; vertex++) {
  //     if (visited[vertex]) continue;

  //     if (hasCycle(edges, vertex, visited, inStack)) return true;
  //   }

  //   return false;
  // }

  // private boolean hasCycle(
  //   int[][] edges, int vertex, boolean[] visited, boolean[] inStack
  // ) {
  //   if (inStack[vertex]) return true;

  //   if (visited[vertex]) return false;

  //   inStack[vertex] = true;
  //   visited[vertex] = true;

  //   for (int idx = 0; idx < edges[vertex].length; idx++)
  //     if (hasCycle(edges, edges[vertex][idx], visited, inStack))
  //       return true;

  //   inStack[vertex] = false;

  //   return false;
  // }
}
