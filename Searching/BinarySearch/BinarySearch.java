package Searching.BinarySearch;

public class BinarySearch {
  public static int search(int[] arr, int value) {
    return binarySearch(arr, value, 0, arr.length - 1);
  }

  /**
   * * Iterative Approach
   *
   * * TC: O(log n)
   * * SC: O(1)
   */
  private static int binarySearch(int[] arr, int value, int low, int high) {
    // Base Case
    while (low < high) {
      int mid = low + high - low / 2;

      if (arr[mid] == value) return mid;
      else if (arr[mid] < value) low = mid + 1;
      else high = mid - 1;
    }

    return -1;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(log n)
   * * SC: O(log n)
   */
  // private static int binarySearch(int[] arr, int value, int low, int high) {
  //   if (low > high) return -1;

  //   int mid = low + high - low / 2;

  //   if (arr[mid] == value) return mid;

  //   else if (arr[mid] < value) return binarySearch(arr, value, mid + 1, high);

  //   return binarySearch(arr, value, low, mid - 1);
  // }
}
