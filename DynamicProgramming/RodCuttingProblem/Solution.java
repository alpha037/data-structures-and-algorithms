package DynamicProgramming.RodCuttingProblem;

// import java.util.Arrays;

/**
 * * Rod Cutting Problem (Variation of Unbounded Knapsack)
 */
public class Solution {
  public int cutRod(int[] prices, int length) {
    // return cutRodRec(length, prices, length, length);

    // int[][] cache = new int[length + 1][length + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MIN_VALUE);

    // return cutRodMem(length, prices, length, length, cache);

    return cutRodDP(prices, length);
  }

  /**
   * * Bottom-Up Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private int cutRodDP(int[] prices, int length) {
    int[] dp = new int[length + 1];

    for (int rodLength = 1; rodLength < length + 1; rodLength++) {
      int maxProfit = Integer.MIN_VALUE;

      for (int j = 0; j < rodLength; j++)
        maxProfit = Math.max(maxProfit, prices[j] + dp[rodLength - j - 1]);

      dp[rodLength] = maxProfit;
    }

    return dp[length];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(n^2)
   * * SC: O(n^2)
   */
  // private int cutRodMem(int index, int[] prices, int length, int capacity, int[][] cache) {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (cache[index][capacity] != Integer.MIN_VALUE)
  //     return cache[index][capacity];

  //   if (length <= capacity)
  //     return cache[index][capacity] = Math.max(
  //       prices[index - 1] + cutRodMem(index, prices, length, capacity - length, cache),
  //       cutRodMem(index - 1, prices, length - 1, capacity, cache)
  //     );

  //   return cache[index][capacity] = cutRodMem(index - 1, prices, length - 1, capacity, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int cutRodRec(int index, int[] prices, int length, int capacity) {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (length <= capacity)
  //     return Math.max(
  //       prices[index - 1] + cutRodRec(index, prices, length, capacity - length),
  //       cutRodRec(index - 1, prices, length - 1, capacity)
  //     );

  //   return cutRodRec(index - 1, prices, length - 1, capacity);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 22
    System.out.println(solution.cutRod(new int[] {1, 5, 8, 9, 10, 17, 17, 20}, 8));

    // should be 24
    System.out.println(solution.cutRod(new int[] {3, 5, 8, 9, 10, 17, 17, 20}, 8));
  }
}
