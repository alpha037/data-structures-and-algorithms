package DynamicProgramming.MaximumSumIncreasingSubsequence;

/**
 * * Maximum Increasing Sum Subsequence (Variation of LIS problem)
 * Problem Statement: https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
 */
public class Solution {
  public int maximumSumIncreasingSubsequence(int[] nums) {
    return longestIncreasingSubsequence(nums);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private int longestIncreasingSubsequence(int[] items) {
    int len = items.length, maxSum = items[0];
    // In this case, the dp array
    // needs to contain the max
    // increasing sum value and not the
    // length of the longest subsequence
    int[] dpSums = items.clone();

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        // If the current item is greater
        // than the previous item and if
        // we haven't added it to the max
        // sum subsequence, then only we add it
        if (items[i] > items[j] && dpSums[i] < (dpSums[j] + items[i])) {
          dpSums[i] = dpSums[j] + items[i];
          maxSum = Math.max(maxSum, dpSums[i]);
        }
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 106
    System.out.println(
        solution.maximumSumIncreasingSubsequence(new int[] {1, 101, 2, 3, 100, 4, 5}));

    // should be 22
    System.out.println(solution.maximumSumIncreasingSubsequence(new int[] {3, 4, 5, 10}));

    // should be 10
    System.out.println(solution.maximumSumIncreasingSubsequence(new int[] {10, 5, 4, 3}));
  }
}
