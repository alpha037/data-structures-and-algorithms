package AlgoExSolutions.Hard.SearchForRange;

// import java.util.*;

/**
 * * Search For Range
 */
class Program {
  public static int[] searchForRange(int[] array, int target) {
    // Write your code here.
    // int[] range = new int[] {-1, -1};

    // searchForRangeHelper(array, target, 0, array.length - 1, range, true);
    // searchForRangeHelper(array, target, 0, array.length - 1, range, false);

    // return range;

    return new int[] {
      searchForRangeHelper(array, target, true), searchForRangeHelper(array, target, false)
    };
  }

  /**
   * * TC: O(log n)
   * * SC: O(1)
   */
  private static int searchForRangeHelper(int[] array, int target, boolean startRange) {
    int index = -1, low = 0, high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == array[mid]) {
        index = mid;

        if (startRange) high = mid - 1;
        else low = mid + 1;

      } else if (target < array[mid]) high = mid - 1;
      else low = mid + 1;
    }

    return index;
  }

  /**
   * * TC: O(log n)
   * * SC: O(log n)
   */
  // private static void searchForRangeHelper(
  //   int[] array, int target, int low, int high, int[] range, boolean startRange
  // ) {
  //   if (low > high) return;

  //   int mid = low + (high - low) / 2;

  //   if (array[mid] < target)
  //     searchForRangeHelper(array, target, mid + 1, high, range, startRange);

  //   else if (array[mid] > target)
  //     searchForRangeHelper(array, target, low, mid - 1, range, startRange);

  //   else {
  //     if (startRange) {
  //       if (mid == 0 || array[mid - 1] != target)
  //         range[0] = mid;
  //       else searchForRangeHelper(array, target, low, mid - 1, range, startRange);
  //     }
  //     else {
  //       if (mid == array.length - 1 || array[mid + 1] != target)
  //         range[1] = mid;
  //       else searchForRangeHelper(array, target, mid + 1, high, range, startRange);
  //     }
  //   }
  // }
}
