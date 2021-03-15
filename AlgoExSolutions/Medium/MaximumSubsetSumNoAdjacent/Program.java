package AlgoExSolutions.Medium.MaximumSubsetSumNoAdjacent;

// import java.util.*;

/**
 * * Maximum Subset Sum With No Adjacent
 */
class Program {
  /**
   * * TC: O(N)
   * * SC: O(N)
   */
  // public static int maxSubsetSumNoAdjacent(int[] array) {
  //   // Write your code here.
  // 	if (array.length <= 1) return array.length == 0 ? 0 : array[0];

  // 	int len = array.length;
  // 	int[] dp = new int[len];

  // 	dp[0] = array[0];
  // 	dp[1] = Math.max(array[0], array[1]);

  // 	for (int i = 2; i < len; i++)
  // 		dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);

  //   return dp[len - 1];
  // }

  /**
   * * TC: O(N)
   * * SC: O(1)
   */
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
    if (array.length <= 1) return array.length == 0 ? 0 : array[0];

    int first = array[0], second = Math.max(array[0], array[1]);

    for (int i = 2; i < array.length; i++) {
      int currentMax = Math.max(second, first + array[i]);
      first = second;
      second = currentMax;
    }

    return second;
  }
}
