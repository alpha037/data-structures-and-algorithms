package AlgoExSolutions.Medium.RemoveIslands;

// import java.util.*;

/**
 * * Remove Islands
 */
class Program {
  /**
   * * TC: O(w * h)
   * * SC: O(w * h) | Better Average Space
   */
  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
    int height = matrix.length, width = matrix[0].length;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++)
        if (row == 0 || row == height - 1 || col == 0 || col == width - 1) DFS(matrix, row, col);
    }

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (matrix[row][col] == 1) matrix[row][col] = 0;

        if (matrix[row][col] == 2) matrix[row][col] = 1;
      }
    }

    return matrix;
  }

  private void DFS(int[][] matrix, int row, int col) {
    int height = matrix.length, width = matrix[0].length;
    if (row < 0 || row >= height || col < 0 || col >= width || matrix[row][col] == 2) return;

    if (matrix[row][col] == 0) return;

    matrix[row][col] = 2;

    DFS(matrix, row + 1, col);
    DFS(matrix, row - 1, col);
    DFS(matrix, row, col + 1);
    DFS(matrix, row, col - 1);
  }

  /**
   * * TC: O(w * h)
   * * SC: O(w * h)
   */
  // public int[][] removeIslands(int[][] matrix) {
  // 	int height = matrix.length, width = matrix[0].length;
  // 	boolean[][] visited = new boolean[height][width];

  // 	for (int row = 0; row < height; row++) {
  // 		for (int col = 0; col < width; col++)
  // 			if (row == 0 || row == height - 1 || col == 0 || col == width - 1)
  // 				DFS(matrix, row, col, visited);
  // 	}

  // 	for (int row = 1; row < height - 1; row++) {
  // 		for (int col = 1; col < width - 1; col++) {
  // 			if (matrix[row][col] == 0) continue;

  // 			if (matrix[row][col] == 1 && !visited[row][col])
  // 				matrix[row][col] = 0;
  // 		}
  // 	}

  // 	return matrix;
  // }

  // private void DFS(int[][] matrix, int row, int col, boolean[][] visited) {
  // 	int height = matrix.length, width = matrix[0].length;
  // 	if (
  // 		row < 0 || row >= height || col < 0 || col >= width ||
  // 		visited[row][col]
  // 	) return;

  // 	visited[row][col] = true;

  // 	if (matrix[row][col] == 0) return;

  // 	DFS(matrix, row + 1, col, visited);
  // 	DFS(matrix, row - 1, col, visited);
  // 	DFS(matrix, row, col + 1, visited);
  // 	DFS(matrix, row, col - 1, visited);
  // }
}
