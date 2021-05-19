package AlgoExSolutions.Hard.RadixSort;

import java.util.*;

/**
 * * Radix Sort
 */
class Program {
  /**
   * * TC: O(d * (n + b))
   * * SC: O(n + b)
   */
  public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
    // Write your code here.
    if (array.size() == 0) return array;

    int maxNumber = Collections.max(array), digit = 0;

    while ((maxNumber / Math.pow(10, digit)) > 0) {
      countingSort(array, digit);
      ++digit;
    }

    return array;
  }

  private void countingSort(List<Integer> array, int digit) {
    int len = array.size(), digitColumn = (int) Math.pow(10, digit);
    int[] sortedArray = new int[len], countArray = new int[10];

    for (int val : array) {
      int countIdx = val / digitColumn % 10;
      countArray[countIdx]++;
    }

    for (int i = 1; i < 10; i++) countArray[i] += countArray[i - 1];

    for (int i = len - 1; i >= 0; i--) {
      int countIdx = array.get(i) / digitColumn % 10;
      countArray[countIdx]--;
      int sortedIdx = countArray[countIdx];
      sortedArray[sortedIdx] = array.get(i);
    }

    for (int i = 0; i < len; i++) array.set(i, sortedArray[i]);
  }
}
