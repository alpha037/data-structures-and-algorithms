package AlgoExSolutions.Medium.KadanesAlgorithm;

// import java.util.*;

/**
 * * Kadane's Algorithm
 */
class Program {
  public static int kadanesAlgorithm(int[] array) {
    // Write your code here.
    int currentSum = array[0], maximumSum = array[0];

    for (int idx = 1; idx < array.length; idx++) {
      currentSum = Math.max(array[idx], currentSum + array[idx]);
      maximumSum = Math.max(currentSum, maximumSum);
    }

    return maximumSum;
  }
}
