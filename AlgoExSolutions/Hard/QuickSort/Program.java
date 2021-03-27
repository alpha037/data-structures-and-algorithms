package AlgoExSolutions.Hard.QuickSort;

// import java.util.*;

/**
 * * Quick Sort
 */
class Program {
  /**
   * * Best: O(n log(n)) time | O(log(n)) space
   * * Average: O(n log(n)) time | O(log(n)) space
   * * Worst: O(n^2) time | O(log(n)) space
   */
  public static int[] quickSort(int[] array) {
    // Write your code here.
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private static void quickSort(int[] array, int low, int high) {
    while (low < high) {
      int partitionIdx = partition(array, low, high);
      boolean isLeftSubArraySmaller = partitionIdx - low < high - partitionIdx;

      if (isLeftSubArraySmaller) {
        quickSort(array, low, partitionIdx - 1);
        low = partitionIdx + 1;
      } else {
        quickSort(array, partitionIdx + 1, high);
        high = partitionIdx - 1;
      }
    }
  }

  private static int partition(int[] array, int low, int high) {
    int pivotIdx = high, leftIdx = low - 1;

    for (int rightIdx = low; rightIdx < high; rightIdx++) {
      if (array[rightIdx] < array[pivotIdx]) {
        leftIdx++;
        swap(array, leftIdx, rightIdx);
      }
    }

    swap(array, leftIdx + 1, pivotIdx);
    return leftIdx + 1;
  }

  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
