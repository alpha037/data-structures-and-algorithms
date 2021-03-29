package AlgoExSolutions.Hard.Quickselect;

// import java.util.*;

/**
 * * Quickselect
 */
class Program {
  public static int quickselect(int[] array, int k) {
    // Write your code here.
    return quickselect(array, 0, array.length - 1, k);
  }

  /**
   * * Best: O(n) time | O(1) space
   * * Average: O(n) time | O(1) space
   * * Worst: O(n^2) time | O(1) space
   */
  private static int quickselect(int[] array, int low, int high, int k) {
    while (low <= high) {
      int partitionIdx = partition(array, low, high);

      if (partitionIdx == k - 1) return array[k - 1];
      else if (partitionIdx > k - 1) high = partitionIdx - 1;
      else low = partitionIdx + 1;
    }

    return -1;
  }

  private static int partition(int[] array, int low, int high) {
    // For a randomized choice of
    // the pivot index
    // randomize(array, low, high);
    int pivotIdx = high, i = low - 1;

    for (int j = low; j < high; j++) {
      if (array[j] < array[pivotIdx]) swap(array, ++i, j);
    }

    swap(array, i + 1, pivotIdx);
    return i + 1;
  }

  // private static void randomize(int[] array, int low, int high) {
  // 	int randomPivotIdx = new Random().nextInt(high - low + 1) + low;
  // 	swap(array, randomPivotIdx, high);
  // }

  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
