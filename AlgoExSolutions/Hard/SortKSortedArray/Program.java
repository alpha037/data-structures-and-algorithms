package AlgoExSolutions.Hard.SortKSortedArray;

import java.util.*;

/**
 * * Sort K-Sorted Array
 */
class Program {

  /**
   * * TC: O(n log(k))
   * * SC: O(k)
   */
  public int[] sortKSortedArray(int[] array, int k) {
    // Write your code here.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int len = array.length, insertAt = 0, i = 0;

    for (; i < Math.min(k + 1, len); i++) minHeap.add(array[i]);

    while (insertAt < len) {
      array[insertAt++] = minHeap.poll();

      if (i < len) {
        minHeap.add(array[i]);
        ++i;
      }
    }

    return array;
  }
}
