package AlgoExSolutions.Medium.MinimumPassesOfMatrix;

import java.util.*;

/**
 * * Minimum Passes Of Matrix
 */
class Program {
  /**
   * * TC: O(wh)
   * * SC: O(wh)
   */
  public int minimumPassesOfMatrix(int[][] matrix) {
    // Write your code here.
    int minPasses = minimumPassesOfMatrixBFS(matrix);
    return hasNegative(matrix) ? -1 : minPasses - 1;
  }

  private int minimumPassesOfMatrixBFS(int[][] matrix) {
    int passes = 0;
    Queue<Pair> q1 = getAllPositivesPositions(matrix), q2;
    int[] rowDirections = {1, 0, -1, 0}, colDirections = {0, 1, 0, -1};

    while (!q1.isEmpty()) {
      q2 = new ArrayDeque<>(q1);
      q1.clear();

      while (!q2.isEmpty()) {
        int currentRow = q2.peek().row, currentCol = q2.peek().col;
        q2.poll();

        for (int i = 0; i < 4; i++) {
          int row = currentRow + rowDirections[i];
          int col = currentCol + colDirections[i];

          if (isOutOfBounds(row, col, matrix)) continue;

          if (matrix[row][col] < 0) {
            matrix[row][col] *= -1;
            q1.add(new Pair(row, col));
          }
        }
      }

      ++passes;
    }

    return passes;
  }

  private Queue<Pair> getAllPositivesPositions(int[][] matrix) {
    Queue<Pair> queue = new ArrayDeque<>();

    for (int row = 0; row < matrix.length; row++)
      for (int col = 0; col < matrix[row].length; col++)
        if (matrix[row][col] > 0) queue.add(new Pair(row, col));

    return queue;
  }

  private boolean isOutOfBounds(int row, int col, int[][] matrix) {
    return (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length);
  }

  private boolean hasNegative(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++)
      for (int col = 0; col < matrix[row].length; col++) if (matrix[row][col] < 0) return true;
    return false;
  }

  static class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
