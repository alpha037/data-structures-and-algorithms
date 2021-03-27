package AlgoExSolutions.Hard.HeapSort;

// import java.util.*;

/**
 * * Heap Sort
 */
class Program {
  /**
   * * Best: O(n log(n)) time | O(1) space
   * * Average: O(n log(n)) time | O(1) space
   * * Worst: O(n log(n)) time | O(1) space
   */
  public static int[] heapSort(int[] array) {
    buildHeap(array, array.length);

    for (int endIdx = array.length - 1; endIdx > 0; --endIdx) {
      swap(array, 0, endIdx);
      heapify(array, 0, endIdx);
    }

    return array;
  }

  private static void buildHeap(int[] array, int length) {
    int firstParentIdx = (int) Math.floor(length / 2);
    for (int currentIdx = firstParentIdx; currentIdx >= 0; --currentIdx)
      heapify(array, currentIdx, length);
  }

  private static void heapify(int[] array, int currIdx, int length) {
    int leftIdx = 2 * currIdx + 1;
    int rightIdx = 2 * currIdx + 2;
    int largest = currIdx;

    if (leftIdx < length && array[leftIdx] > array[largest]) largest = leftIdx;

    if (rightIdx < length && array[rightIdx] > array[largest]) largest = rightIdx;

    if (largest != currIdx) {
      swap(array, currIdx, largest);
      heapify(array, largest, length);
    }
  }

  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
