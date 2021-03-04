package AlgoExSolutions.Easy.InsertionSort;

// import java.util.*;

/**
 * * Insertion Sort
 */
class Program {
  public static int[] insertionSort(int[] array) {
    // Write your code here.
    if (array == null || array.length == 0) return new int[] {};

    for (int i = 1; i < array.length; i++) {
      int j = i;

      while (j > 0 && array[j] < array[j - 1]) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;

        --j;
      }
    }

    return array;
  }
}
