package AlgoExSolutions.Medium.NumberofWaysToTraverseGraph;

// import java.util.*;

/**
 * * Number Of Ways To Traverse Graph
 */
class Program {
  private int factorial(int n) {
    int res = 1;

    while (n > 0) res *= n--;

    return res;
  }

  /**
   * * TC: O(m + n)
   * * SC: O(1)
   */
  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.
    return factorial(width - 1 + height - 1) / (factorial(width - 1) * factorial(height - 1));
  }

  /**
   * * TC: O(m * n)
   * * SC: O(m * n)
   */
  // public int numberOfWaysToTraverseGraph(int width, int height) {
  //   int[][] numberOfWays = new int[width + 1][height + 1];

  // 	for (int row = 1; row <= width; row++) {
  // 		for (int col = 1; col <= height; col++) {
  // 			if (row == 1 || col == 1)
  // 				numberOfWays[row][col] = 1;
  // 			else
  // 				numberOfWays[row][col] =
  // 					numberOfWays[row - 1][col] + numberOfWays[row][col - 1];
  // 		}
  // 	}

  // 	return numberOfWays[width][height];
  // }

  /**
   * * TC: O(2 ^ (m + n))
   * * SC: O(m + n)
   */
  // public int numberOfWaysToTraverseGraph(int width, int height) {
  //   if (width == 1 || height == 1) return 1;

  //   return numberOfWaysToTraverseGraph(width - 1, height) +
  //     numberOfWaysToTraverseGraph(width, height - 1);
  // }
}
