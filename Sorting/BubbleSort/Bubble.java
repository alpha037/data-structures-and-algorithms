package Sorting.BubbleSort;

public class Bubble {
  public static int[] sort(int[] arr) {

    if (arr.length <= 1) return arr;

    int n = arr.length;

    // Usually, bubble sort takes around
    // O(n^2) time for both sorted and unsorted
    // arrays. With this check, the algorithm
    // will take O(n) time for a sorted array
    boolean isSwapped;

    for (int i = 0; i < n - 1; i++) {
      // To check whether any of the
      // elements are swapped or not
      isSwapped = false;

      for (int j = 0; j < n - i - 1; j++)
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          isSwapped = true;
        }

      // If none of the elements are swapped,
      // then the array is already sorted
      if (!isSwapped) break;
    }

    return arr;
  }
}
