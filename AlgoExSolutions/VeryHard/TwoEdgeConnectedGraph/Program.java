package AlgoExSolutions.VeryHard.TwoEdgeConnectedGraph;

import java.util.*;

/**
 * * Two-Edge Connected Graph
 */
class Program {
  /**
   * * TC :O(v + e)
   * * SC: O(v)
   */
  public boolean twoEdgeConnectedGraph(int[][] edges) {
    // Write your code here.
    if (edges == null || edges.length == 0) return true;

    int sourceVertex = 0;
    int[] minimumArrivalTimes = new int[edges.length];
    Arrays.fill(minimumArrivalTimes, -1);

    if (getMinimumArrivalTimeOfAncestors(sourceVertex, -1, 0, minimumArrivalTimes, edges) == -1)
      return false;

    return isConnected(minimumArrivalTimes);
  }

  private int getMinimumArrivalTimeOfAncestors(
      int currentVertex, int parent, int currentTime, int[] minimumArrivalTimes, int[][] edges) {
    minimumArrivalTimes[currentVertex] = currentTime;
    int minimumArrivalTime = currentTime;

    for (int destination : edges[currentVertex]) {
      if (minimumArrivalTimes[destination] == -1)
        minimumArrivalTime =
            Math.min(
                minimumArrivalTime,
                getMinimumArrivalTimeOfAncestors(
                    destination, currentVertex, currentTime + 1, minimumArrivalTimes, edges));
      else if (destination != parent)
        minimumArrivalTime = Math.min(minimumArrivalTime, minimumArrivalTimes[destination]);
    }

    return currentTime == minimumArrivalTime && parent != -1 ? -1 : minimumArrivalTime;
  }

  private boolean isConnected(int[] minimumArrivalTimes) {
    for (int time : minimumArrivalTimes) if (time == -1) return false;
    return true;
  }
}
