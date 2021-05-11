package DynamicProgramming.BuildingBridges;

import java.util.Arrays;

/**
 * * Building Bridges (Variation of LIS problem)
 * Problem Statement: https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
 */
public class Solution {
  public int buildingBridges(int[][] cityPairs) {
    // Sort the pairs according to
    // increasing order of south bridges
    Arrays.sort(cityPairs, (a, b) -> a[1] - b[1]);

    // return longestIncreasingSubsequenceRec(-1, 0, cityPairs);

    // int[][] cache = new int[cityPairs.length + 1][cityPairs.length + 1];
    // for (int[] row : cache) Arrays.fill(row, -1);

    // return longestIncreasingSubsequenceMem(-1, 0, cityPairs, cache);

    return longestIncreasingSubsequenceDP(cityPairs);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private int longestIncreasingSubsequenceDP(int[][] cityPairs) {
    int len = cityPairs.length, maxLen = 1;
    int[] dp = new int[len];
    Arrays.fill(dp, 1);

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        // Longest increasing subsequence
        // based on north bridges
        if (cityPairs[i][0] > cityPairs[j][0] && dp[i] <= dp[j]) {
          dp[i] = 1 + dp[j];
          maxLen = max(maxLen, dp[i]);
        }
      }
    }

    return maxLen;
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(n^2)
   * * SC: O(n^2)
   */
  // private int longestIncreasingSubsequenceMem(int prev, int curr, int[][] cityPairs, int[][]
  // cache) {
  //   if (curr == cityPairs.length) return 0;

  //   if (prev != -1 && cache[prev][curr] != -1) return cache[prev][curr];

  //   int lengthWithCurrentItem = 0;
  //   if (prev == -1 || cityPairs[curr][0] > cityPairs[prev][0])
  //     lengthWithCurrentItem = 1 + longestIncreasingSubsequenceMem(curr, curr + 1, cityPairs,
  // cache);

  //   int lengthWithoutCurrentItem = longestIncreasingSubsequenceMem(prev, curr + 1, cityPairs,
  // cache);

  //   return prev != -1 ?
  //     cache[prev][curr] = max(lengthWithCurrentItem, lengthWithoutCurrentItem) :
  //     max(lengthWithCurrentItem, lengthWithoutCurrentItem);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int longestIncreasingSubsequenceRec(int prev, int curr, int[][] cityPairs) {
  //   if (curr == cityPairs.length) return 0;

  //   int lengthWithCurrentItem = 0;
  //   if (prev == -1 || cityPairs[curr][0] > cityPairs[prev][0])
  //     lengthWithCurrentItem = 1 + longestIncreasingSubsequenceRec(curr, curr + 1, cityPairs);

  //   int lengthWithoutCurrentItem = longestIncreasingSubsequenceRec(prev, curr + 1, cityPairs);

  //   return max(lengthWithCurrentItem, lengthWithoutCurrentItem);
  // }

  private int max(int... a) {
    int maxValue = Integer.MIN_VALUE;
    for (int val : a) maxValue = Math.max(maxValue, val);
    return maxValue;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 2
    System.out.println(
        solution.buildingBridges(
            new int[][] {
              {6, 2},
              {4, 3},
              {2, 6},
              {1, 5}
            }));

    // should be 5
    System.out.println(
        solution.buildingBridges(
            new int[][] {
              {8, 1},
              {1, 2},
              {4, 3},
              {3, 4},
              {5, 5},
              {2, 6},
              {6, 7},
              {7, 8}
            }));
  }
}
