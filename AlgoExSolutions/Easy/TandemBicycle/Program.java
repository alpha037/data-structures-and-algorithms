package AlgoExSolutions.Easy.TandemBicycle;

import java.util.*;

/**
 * * Tandem Bicycle
 */
class Program {

  /**
   * * TC: O(n log(n))
   * * SC: O(1)
   */
  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    // Write your code here.
    int totalSpeed = 0;
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);

    if (fastest) reverse(blueShirtSpeeds);

    for (int i = 0; i < redShirtSpeeds.length; i++) {
      int redShirtSpeed = redShirtSpeeds[i], blueShirtSpeed = blueShirtSpeeds[i];
      totalSpeed += Math.max(redShirtSpeed, blueShirtSpeed);
    }

    return totalSpeed;
  }

  private void reverse(int[] array) {
    int start = 0, end = array.length - 1;
    while (start < end) {
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;

      ++start;
      --end;
    }
  }
}
