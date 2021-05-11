package DynamicProgramming.MaximumLengthChainOfPairs;

import java.util.Arrays;

/**
 * * Maximum Length Chain of Pairs (Variation of LIS problem)
 * Problem Statement: https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
 *
 * ? Can also be solved using Greedy Approach
 * ? (Activity Selection Problem - TC: O(n log(n)))
 */
public class Solution {
  public int maximumLengthChainOfPairs(Pair[] pairs) {
    // Sort the array based on
    // the smaller element
    Arrays.sort(pairs, (p1, p2) -> p1.a - p2.a);

    return longestIncreasingSubsequence(pairs);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private int longestIncreasingSubsequence(Pair[] items) {
    int len = items.length, maxLen = 1;
    int[] dp = new int[len];
    Arrays.fill(dp, 1);

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (items[i].a > items[j].b && dp[i] <= dp[j]) dp[i] = 1 + dp[j];
        maxLen = Math.max(maxLen, dp[i]);
        // if (maxLen < dp[i]) {
        //   maxLen = Math.max(maxLen, dp[i]);
        //   end = i;
        // }
      }
    }

    return maxLen;
  }

  // private List<Pair> buildSequence(int[] dp, Pair[] items, int end) {
  //   List<Pair> seq = new ArrayList<>();
  //   int currentVal = dp[end] - 1;
  //   seq.add(0, items[end]);

  //   while (end >= 0) {
  //     if (currentVal == dp[end]) {
  //       seq.add(0, items[end]);
  //       currentVal = dp[end] - 1;
  //     }

  //     --end;
  //   }

  //   return seq;
  // }

  static class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public String toString() {
      return "[" + a + ", " + b + "]";
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(
        solution.maximumLengthChainOfPairs(
            new Pair[] {
              new Pair(5, 24),
              new Pair(39, 60),
              new Pair(15, 28),
              new Pair(27, 40),
              new Pair(50, 90),
            }));

    // should be 2
    System.out.println(
        solution.maximumLengthChainOfPairs(new Pair[] {new Pair(6, 8), new Pair(3, 4)}));
  }
}
