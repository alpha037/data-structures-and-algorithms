package AlgoExSolutions.Easy.SelectionSort;

// import java.util.*;

/**
 * * Selection Sort
 */
class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
    if (array == null || array.length == 0) return new int[] {};

    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < array.length; j++) if (array[minIndex] >= array[j]) minIndex = j;

      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }

    return array;
  }
}
