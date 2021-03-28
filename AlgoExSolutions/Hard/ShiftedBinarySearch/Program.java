package AlgoExSolutions.Hard.ShiftedBinarySearch;

// import java.util.*;

/**
 * * Shifted Binary Search
 */
class Program {
  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
    return shiftedBinarySearch(array, target, 0, array.length - 1);
  }

  /**
   * * TC: O(log n)
   * * SC: O(1)
   */
  private static int shiftedBinarySearch(int[] array, int target, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == target) return mid;
      else if (array[low] <= array[mid]) {
        if (target >= array[low] && target <= array[mid]) high = mid - 1;
        else low = mid + 1;
      } else {
        if (target >= array[mid] && target <= array[high]) low = mid + 1;
        else high = mid - 1;
      }
    }

    return -1;
  }

  /**
   * * TC: O(log n)
   * * SC: O(log n)
   */
  // private static int shiftedBinarySearch(
  // 	int[] array, int target, int low, int high
  // ) {
  // 	if (low > high) return -1;

  // 	int mid = low + (high - low) / 2;

  // 	if (array[mid] == target) return mid;

  // 	if (array[low] <= array[mid]) {
  //     if (target >= array[low] && target < array[mid])
  //       return shiftedBinarySearch(array, target, low, mid - 1);

  //     return shiftedBinarySearch(array, target, mid + 1, high);
  //   }

  //   if (target >= array[mid] && target < array[high])
  //     return shiftedBinarySearch(array, target, mid + 1, high);

  //   return shiftedBinarySearch(array, target, low, mid - 1);
  // }
}
