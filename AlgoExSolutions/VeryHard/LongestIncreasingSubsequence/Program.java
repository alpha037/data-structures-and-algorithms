package AlgoExSolutions.VeryHard.LongestIncreasingSubsequence;

import java.util.*;

/**
 * * Longest Increasing Subsequence
 */
class Program {
  /**
   * * Binary Search Approach
   *
   * * TC: O(n log(n))
   * * SC: O(n)
   */
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
    // Write your code here.
    int len = array.length, maxLen = 0;
    int[] sequences = new int[len];
    Arrays.fill(sequences, Integer.MIN_VALUE);
    int[] indices = new int[len + 1];
    Arrays.fill(indices, Integer.MIN_VALUE);

    for (int i = 0; i < len; i++) {
      int newLength = binarySearch(1, maxLen, indices, array, array[i]);
      sequences[i] = indices[newLength - 1];
      indices[newLength] = i;
      maxLen = Math.max(maxLen, newLength);
    }

    return buildSequence(array, sequences, indices[maxLen]);
  }

  private static int binarySearch(int low, int high, int[] indices, int[] array, int target) {
    if (low > high) return low;

    int mid = low + (high - low) / 2;
    if (array[indices[mid]] < target) low = mid + 1;
    else high = mid - 1;

    return binarySearch(low, high, indices, array, target);
  }

  private static List<Integer> buildSequence(int[] array, int[] sequences, int endIdx) {
    List<Integer> seq = new ArrayList<>();
    while (endIdx != Integer.MIN_VALUE) {
      seq.add(0, array[endIdx]);
      endIdx = sequences[endIdx];
    }

    return seq;
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // public static List<Integer> longestIncreasingSubsequence(int[] array) {
  //   int len = array.length, endIdx = 0, maxLen = 1;
  // 	int[] lengths = new int[len];
  // 	Arrays.fill(lengths, 1);

  // 	for (int i = 1; i < len; i++) {
  // 		for (int j = 0; j < i; j++) {
  // 			if (array[i] > array[j] && lengths[i] <= lengths[j] + 1)
  // 				lengths[i] = 1 + lengths[j];
  // 		}

  // 		if (maxLen < lengths[i]) {
  // 			maxLen = lengths[i];
  // 			endIdx = i;
  // 		}
  // 	}

  // 	return buildSequence(lengths, array, endIdx);
  // }

  // private static List<Integer> buildSequence(
  // 	int[] lengths, int[] array, int endIdx
  // ) {
  // 	List<Integer> seq = new ArrayList<>();
  // 	seq.add(array[endIdx]);
  // 	int currentLen = lengths[endIdx] - 1;
  // 	while (endIdx >= 0) {
  // 		if (currentLen == lengths[endIdx]) {
  // 			seq.add(0, array[endIdx]);
  // 			currentLen = lengths[endIdx] - 1;
  // 		}
  // 		--endIdx;
  // 	}
  // 	return seq;
  // }
}
