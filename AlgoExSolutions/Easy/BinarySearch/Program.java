package AlgoExSolutions.Easy.BinarySearch;

// import java.util.*;

/**
 * * Binary Search
 */
class Program {
  private static int binarySearch(int[] array, int left, int right, int target) {
    if (left > right) return -1;

    int mid = (left + right) / 2;

    if (array[mid] == target) return mid;
    else if (array[mid] < target) return binarySearch(array, mid + 1, right, target);
    else return binarySearch(array, left, mid - 1, target);
  }

  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    if (array == null || array.length == 0) return -1;

    return binarySearch(array, 0, array.length - 1, target);
  }
}
