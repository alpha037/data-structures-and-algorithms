package DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * Longest Increasing Subsequence
 */
public class Solution {
  public int longestIncreasingSubsequence(int[] items) {
    // return longestIncreasingSubsequenceRec(-1, 0, items);

    // int[][] cache = new int[items.length + 1][items.length + 1];
    // for (int[] row : cache)  Arrays.fill(row, -1);

    // return longestIncreasingSubsequenceMem(-1, 0, items, cache);

    return longestIncreasingSubsequenceDP(items);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private int longestIncreasingSubsequenceDP(int[] items) {
    int len = items.length, maxLen = 1, end = 0;
    int[] dp = new int[len];
    Arrays.fill(dp, 1);

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (items[i] > items[j] && dp[i] <= dp[j]) {
          dp[i] = 1 + dp[j];
          if (maxLen < dp[i]) {
            maxLen = dp[i];
            end = i;
          }
        }
      }
    }

    System.out.println(buildSequence(items, dp, end));

    return maxLen;
  }

  private List<Integer> buildSequence(int[] items, int[] dp, int end) {
    List<Integer> seq = new ArrayList<>();
    int currentLen = dp[end] - 1;
    seq.add(items[end]);

    while (end >= 0) {
      if (currentLen == dp[end]) {
        seq.add(0, items[end]);
        currentLen = dp[end] - 1;
      }

      --end;
    }

    return seq;
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // private int longestIncreasingSubsequenceMem(int prev, int curr, int[] items, int[][] cache) {
  //   if (curr == items.length) return 0;

  //   if (prev != -1 && cache[prev][curr] != -1) return cache[prev][curr];

  //   int lengthWithCurrentItem = 0;
  //   if (prev == -1 || items[curr] > items[prev])
  //     lengthWithCurrentItem = 1 + longestIncreasingSubsequenceMem(curr, curr + 1, items, cache);

  //   int lengthWithoutCurrentItem = longestIncreasingSubsequenceMem(prev, curr + 1, items, cache);

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
  // private int longestIncreasingSubsequenceRec(int prev, int curr, int[] items) {
  //   if (curr == items.length) return 0;

  //   int lengthWithCurrentItem = 0;
  //   if (prev == -1 || items[curr] > items[prev])
  //     lengthWithCurrentItem =  1 + longestIncreasingSubsequenceRec(curr, curr + 1, items);

  //   int lengthWithoutCurrentItem = longestIncreasingSubsequenceRec(prev, curr + 1, items);

  //   return max(lengthWithCurrentItem, lengthWithoutCurrentItem);
  // }

  // private int max(int... a) {
  //   int maxValue = Integer.MIN_VALUE;
  //   for (int val : a) maxValue = Math.max(maxValue, val);
  //   return maxValue;
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 6
    System.out.println(
        solution.longestIncreasingSubsequence(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80}));

    // should be 6
    System.out.println(
        solution.longestIncreasingSubsequence(
            new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
  }
}
