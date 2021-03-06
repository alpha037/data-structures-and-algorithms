package AlgoExSolutions.Medium.SearchInSortedMatrix;

// import java.util.*;

/**
 * * Search In Sorted Matrix
 */
class Program {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    // Write your code here.
    int row = 0, col = matrix[0].length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] > target) --col;
      else if (matrix[row][col] < target) ++row;
      else return new int[] {row, col};
    }

    return new int[] {-1, -1};
  }
}
