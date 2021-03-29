package AlgoExSolutions.Hard.IndexEqualsValue;

// import java.util.*;

/**
 * * Index Equals Value
 */
class Program {
  public int indexEqualsValue(int[] array) {
    // Write your code here.
    return indexEqualsValueHelper(array);
  }

  /**
   * * TC: O(log n)
   * * SC: O(1)
   */
  private int indexEqualsValueHelper(int[] array) {
    int index = -1, low = 0, high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == mid) {
        index = mid;
        high = mid - 1;
      } else if (array[mid] < mid) low = mid + 1;
      else high = mid - 1;
    }

    return index;
  }
}
