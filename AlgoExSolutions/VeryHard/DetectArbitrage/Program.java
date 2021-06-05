package AlgoExSolutions.VeryHard.DetectArbitrage;

import java.util.*;

/**
 * * Detect Arbitrage
 */
class Program {
  /**
   * * TC: O(n^3)
   * * SC: O(n^2)
   */
  public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
    // Write your code here.
    ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
    return hasNegativeWeightCycle(logExchangeRates, 0);
  }

  private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
    ArrayList<ArrayList<Double>> logMatrix = new ArrayList<>();

    for (int i = 0; i < matrix.size(); i++) {
      logMatrix.add(new ArrayList<>());
      for (int j = 0; j < matrix.get(i).size(); j++)
        logMatrix.get(i).add(-Math.log10(matrix.get(i).get(j)));
    }

    return logMatrix;
  }

  private boolean hasNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int srcVertex) {
    double[] distances = new double[graph.size()];
    Arrays.fill(distances, Double.MAX_VALUE);
    distances[srcVertex] = 0;

    for (int i = 0; i < graph.size(); i++)
      if (!relaxEdgesAndUpdateDistances(graph, distances)) return false;

    return relaxEdgesAndUpdateDistances(graph, distances);
  }

  private boolean relaxEdgesAndUpdateDistances(
      ArrayList<ArrayList<Double>> graph, double[] distances) {
    boolean didUpdate = false;

    for (int srcIdx = 0; srcIdx < graph.size(); srcIdx++) {
      for (int destIdx = 0; destIdx < graph.get(srcIdx).size(); destIdx++) {
        double edgeWeight = graph.get(srcIdx).get(destIdx);
        double newDistance = distances[srcIdx] + edgeWeight;

        if (newDistance < distances[destIdx]) {
          didUpdate = true;
          distances[destIdx] = newDistance;
        }
      }
    }

    return didUpdate;
  }
}
