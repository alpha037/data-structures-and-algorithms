package AlgoExSolutions.Hard.SearchForRange;

// import java.util.*;

/**
 * * Search For Range
 */
class Program {
  public static int[] searchForRange(int[] array, int target) {
    // Write your code here.
    return new int[] {searchFirst(array, target), searchLast(array, target)};
  }

  /**
   * * TC: O(log n)
   * * SC: O(1)
   */
  private static int searchFirst(int[] array, int target) {
    int index = -1, low = 0, high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == array[mid]) {
        index = mid;
        high = mid - 1;
      } else if (target < array[mid]) high = mid - 1;
      else low = mid + 1;
    }

    return index;
  }

  /**
   * * TC: O(log n)
   * * SC: O(1)
   */
  private static int searchLast(int[] array, int target) {
    int index = -1, low = 0, high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == array[mid]) {
        index = mid;
        low = mid + 1;
      } else if (target < array[mid]) high = mid - 1;
      else low = mid + 1;
    }

    return index;
  }
}
