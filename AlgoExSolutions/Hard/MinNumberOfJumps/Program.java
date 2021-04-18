package AlgoExSolutions.Hard.MinNumberOfJumps;

// import java.util.*;

/**
 * * Min Number Of Jumps
 */
class Program {
  /**
   * * Optimized Approach
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
    int len = array.length;

    if (len == 1) return 0;

    int jumps = 0, steps = array[0], maxReach = array[0];

    for (int i = 1; i < len - 1; i++) {
      maxReach = Math.max(maxReach, i + array[i]);
      --steps;

      if (steps == 0) {
        ++jumps;
        steps = maxReach - i;

        if (steps < 0) return -1;
      }
    }

    return jumps + 1;
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // public static int minNumberOfJumps(int[] array) {
  // 	int len = array.length;
  // 	int[] jumps = new int[len];
  // 	Arrays.fill(jumps, Integer.MAX_VALUE);
  // 	jumps[0] = 0;

  // 	for (int i = 1; i < len; i++) {
  // 		for (int j = 0; j < i; j++) {
  // 			if (array[j] + j >= i)
  //         jumps[i] = Math.min(jumps[i], jumps[j] + 1);
  //     }
  //   }

  //   return jumps[len - 1];
  // }
}
