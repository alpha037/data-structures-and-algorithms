package AlgoExSolutions.Hard.MaxSumIncreasingSubsequence;

import java.util.*;

/**
 * * Max Sum Increasing Subsequence
 */
class Program {
  /**
   * * TC: O(n^2)
   * * SC: O(n)
   */
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    // Write your code here.
    int len = array.length, maxSumIdx = 0;
    int[] sums = array.clone();
    int[] sequences = new int[len];
    Arrays.fill(sequences, Integer.MIN_VALUE);

    for (int i = 0; i < len; i++) {
      int currentNum = array[i];
      for (int j = 0; j < i; j++) {
        int otherNum = array[j];
        if (otherNum < currentNum && currentNum + sums[j] > sums[i]) {
          sums[i] = currentNum + sums[j];
          sequences[i] = j;
        }
      }

      if (sums[i] > sums[maxSumIdx]) maxSumIdx = i;
    }

    return buildSequence(array, sequences, maxSumIdx, sums[maxSumIdx]);
  }

  private static List<List<Integer>> buildSequence(
      int[] array, int[] sequences, int currentIdx, int maxSum) {
    List<List<Integer>> seq = new ArrayList<>();
    seq.add(new ArrayList<>());
    seq.add(new ArrayList<>());
    seq.get(0).add(maxSum);

    while (currentIdx != Integer.MIN_VALUE) {
      seq.get(1).add(0, array[currentIdx]);
      currentIdx = sequences[currentIdx];
    }

    return seq;
  }
}
