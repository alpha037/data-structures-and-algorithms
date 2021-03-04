package AlgoExSolutions.Easy.BubbleSort;

// import java.util.*;

/**
 * * Bubble Sort
 */
class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.

    int i = 0;
    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;

          isSorted = false;
        }
      }
      ++i;
    }

    return array;
  }
}
