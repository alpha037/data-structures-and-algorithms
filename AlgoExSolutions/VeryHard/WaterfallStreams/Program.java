package AlgoExSolutions.VeryHard.WaterfallStreams;

// import java.util.*;

/**
 * * Waterfall Streams
 */
class Program {
  /**
   * * TC: O(w^2 * h)
   * * SC: O(w)
   */
  public double[] waterfallStreams(double[][] array, int source) {
    // Write your code here.
    double[] previousRow = array[0].clone();
    previousRow[source] = -1;

    for (int row = 1; row < array.length; row++) {
      double[] currentRow = array[row].clone();

      for (int idx = 0; idx < currentRow.length; idx++) {
        double valueAbove = previousRow[idx];
        boolean hasWater = valueAbove < 0, hasBlock = currentRow[idx] == 1;

        if (!hasWater) continue;

        if (!hasBlock) {
          currentRow[idx] += valueAbove;
          continue;
        }

        double splitWater = valueAbove / 2;
        int leftIdx = idx, rightIdx = idx;

        while (leftIdx - 1 >= 0) {
          --leftIdx;
          if (previousRow[leftIdx] == 1) break;
          if (currentRow[leftIdx] != 1) {
            currentRow[leftIdx] += splitWater;
            break;
          }
        }

        while (rightIdx + 1 < currentRow.length) {
          ++rightIdx;
          if (previousRow[rightIdx] == 1) break;
          if (currentRow[rightIdx] != 1) {
            currentRow[rightIdx] += splitWater;
            break;
          }
        }
      }

      previousRow = currentRow;
    }

    return convertToPercentage(previousRow);
  }

  private static double[] convertToPercentage(double[] array) {
    for (int idx = 0; idx < array.length; idx++) if (array[idx] < 0) array[idx] *= -100;

    return array;
  }
}
