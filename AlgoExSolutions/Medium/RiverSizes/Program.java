package AlgoExSolutions.Medium.RiverSizes;

import java.util.*;

/**
 * * River Sizes
 */
class Program {
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
    List<Integer> sizes = new ArrayList<>();
    int height = matrix.length, width = matrix[0].length;
    boolean[][] visited = new boolean[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (visited[row][col]) continue;

        traverseNodes(matrix, row, col, visited, sizes);
      }
    }

    return sizes;
  }

  private static void traverseNodes(
      int[][] matrix, int row, int col, boolean[][] visited, List<Integer> sizes) {
    int currentSize = 0;
    Queue<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[] {row, col});

    while (!queue.isEmpty()) {
      Integer[] currentNode = queue.poll();
      row = currentNode[0];
      col = currentNode[1];

      if (visited[row][col]) continue;
      visited[row][col] = true;

      if (matrix[row][col] == 0) continue;

      ++currentSize;
      List<Integer[]> neighbors = getNeighborsOfCurrentNode(matrix, row, col, visited);

      for (Integer[] neighbor : neighbors) queue.add(neighbor);
    }

    if (currentSize > 0) sizes.add(currentSize);
  }

  private static List<Integer[]> getNeighborsOfCurrentNode(
      int[][] matrix, int row, int col, boolean[][] visited) {
    List<Integer[]> neighbors = new ArrayList<>();
    int height = matrix.length, width = matrix[0].length;

    if (row > 0 && !visited[row - 1][col]) neighbors.add(new Integer[] {row - 1, col});

    if (row < height - 1 && !visited[row + 1][col]) neighbors.add(new Integer[] {row + 1, col});

    if (col > 0 && !visited[row][col - 1]) neighbors.add(new Integer[] {row, col - 1});

    if (col < width - 1 && !visited[row][col + 1]) neighbors.add(new Integer[] {row, col + 1});

    return neighbors;
  }
}
