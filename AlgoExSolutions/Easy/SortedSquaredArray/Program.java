package AlgoExSolutions.Easy.SortedSquaredArray;

import java.util.*;

/**
 * * Sorted Squared Array
 */
class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
    int len = array.length, start = 0, end = len - 1, idx = len - 1;
    int[] res = new int[len];
    Arrays.fill(res, 0);

    while (start <= end) {
      if (Math.abs(array[start]) < Math.abs(array[end])) {
        res[idx--] = array[end] * array[end];
        --end;
      } else {
        res[idx--] = array[start] * array[start];
        ++start;
      }
    }

    return res;
  }
}
