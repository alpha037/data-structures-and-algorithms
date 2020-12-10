package Sorting.InsertionSort;

public class Insertion {

  public static int[] sort(int[] arr) {

    if (arr.length <= 1) return arr;

    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int currentKey = arr[i];
      int j = i - 1;

      while (j >= 0 && currentKey < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }

      arr[j + 1] = currentKey;
    }

    return arr;
  }
}
