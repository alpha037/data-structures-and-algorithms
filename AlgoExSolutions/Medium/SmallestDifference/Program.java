package AlgoExSolutions.Medium.SmallestDifference;

import java.util.*;

/**
 * * Smallest Difference
 */
class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    if (arrayOne == null || arrayTwo == null) return new int[] {};

    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int i = 0, j = 0;
    int num1 = 0, num2 = 0;
    int min = Integer.MAX_VALUE, difference = Integer.MAX_VALUE;

    while (i < arrayOne.length && j < arrayTwo.length) {
      int val1 = arrayOne[i], val2 = arrayTwo[j];

      if (val1 < val2) {
        difference = val2 - val1;
        ++i;
      } else {
        difference = val1 - val2;
        ++j;
      }

      if (difference < min) {
        min = difference;
        num1 = val1;
        num2 = val2;
      }
    }

    return new int[] {num1, num2};
  }
}
