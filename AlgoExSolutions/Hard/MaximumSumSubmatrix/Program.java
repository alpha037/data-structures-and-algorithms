package AlgoExSolutions.Hard.MaximumSumSubmatrix;

// import java.util.*;

/**
 * * Maximum Sum Submatrix
 */
class Program {
  /**
   * * TC: O(mn)
   * * SC: O(mn)
   */
  public int maximumSumSubmatrix(int[][] matrix, int size) {
    // Write your code here.
    int[][] sums = createSumMatrix(matrix);
    int m = matrix.length, n = matrix[0].length, maxSum = Integer.MIN_VALUE;

    for (int i = size - 1; i < m; i++) {
      for (int j = size - 1; j < n; j++) {
        int currentSum = sums[i][j];
        boolean touchesTopBorder = i - size < 0, touchesLeftBorder = j - size < 0;

        if (!touchesTopBorder) currentSum -= sums[i - size][j];
        if (!touchesLeftBorder) currentSum -= sums[i][j - size];
        if (!touchesTopBorder && !touchesLeftBorder) currentSum += sums[i - size][j - size];

        maxSum = Math.max(maxSum, currentSum);
      }
    }

    return maxSum;
  }

  private int[][] createSumMatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dpSums = new int[m][n];

    dpSums[0][0] = matrix[0][0];

    for (int j = 1; j < n; j++) dpSums[0][j] = matrix[0][j] + dpSums[0][j - 1];
    for (int i = 1; i < m; i++) dpSums[i][0] = matrix[i][0] + dpSums[i - 1][0];

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dpSums[i][j] = matrix[i][j] + dpSums[i - 1][j] + dpSums[i][j - 1] - dpSums[i - 1][j - 1];
      }
    }

    return dpSums;
  }
}
