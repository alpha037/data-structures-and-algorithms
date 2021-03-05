package AlgoExSolutions.Medium.FirstDuplicateValue;

// import java.util.*;

/**
 * * First Duplicate Value
 */
class Program {

  public int firstDuplicateValue(int[] array) {
    // Write your code here.

    for (int idx = 0; idx < array.length; idx++) {
      int targetIdx = Math.abs(array[idx]) - 1;
      if (array[targetIdx] < 0) return Math.abs(array[idx]);

      array[targetIdx] = -array[targetIdx];
    }

    return -1;
  }
}
