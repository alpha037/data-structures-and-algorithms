package AlgoExSolutions.VeryHard.NumberOfBinaryTreeTopologies;

// import java.util.*;

/**
 * * Number Of Binary Tree Topologies
 */
class Program {
  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n^2)
   * * Sc: O(n)
   */
  public static int numberOfBinaryTreeTopologies(int n) {
    // Write your code here.
    return numberOfBinaryTreeTopologiesHelper(n);
  }

  private static int numberOfBinaryTreeTopologiesHelper(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 1;

    for (int i = 1; i < n + 1; i++) {
      for (int left = 0; left < i; left++) {
        int right = i - left - 1;
        dp[i] += dp[left] * dp[right];
      }
    }

    return dp[n];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(n^2)
   * * Sc: O(n)
   */
  // public static int numberOfBinaryTreeTopologies(int n) {
  // 	return numberOfBinaryTreeTopologiesHelper(n);
  // }

  // private static int numberOfBinaryTreeTopologiesHelper(int n) {
  // 	if (n <= 0) return 1;

  // 	int topologies = 0;

  // 	for (int left = 0; left < n; left++) {
  // 		int right = n - 1 - left;
  // 		int leftTopology = numberOfBinaryTreeTopologiesHelper(left);
  // 		int rightTopology = numberOfBinaryTreeTopologiesHelper(right);
  // 		topologies += (leftTopology * rightTopology);
  // 	}

  // 	return topologies;
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O((n*(2n)!)/(n!(n+1)!))
   * * SC: O(n)
   */
  // public static int numberOfBinaryTreeTopologies(int n) {
  // 	return numberOfBinaryTreeTopologiesHelper(n);
  // }

  // private static int numberOfBinaryTreeTopologiesHelper(int n) {
  // 	if (n <= 0) return 1;

  // 	int topologies = 0;

  // 	for (int left = 0; left < n; left++) {
  // 		int right = n - 1 - left;
  // 		int leftTopology = numberOfBinaryTreeTopologiesHelper(left);
  // 		int rightTopology = numberOfBinaryTreeTopologiesHelper(right);
  // 		topologies += (leftTopology * rightTopology);
  // 	}

  // 	return topologies;
  // }
}
