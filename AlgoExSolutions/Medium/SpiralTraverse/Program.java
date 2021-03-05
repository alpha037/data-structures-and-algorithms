package AlgoExSolutions.Medium.SpiralTraverse;

import java.util.*;

/**
 * * Spiral Traverse
 */
class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
    int startRow = 0, startCol = 0;
    int endRow = array.length - 1, endCol = array[0].length - 1;
    List<Integer> res = new ArrayList<>();

    while (startRow <= endRow && startCol <= endCol) {
      for (int i = startCol; i <= endCol; i++) res.add(array[startRow][i]);

      for (int i = startRow + 1; i <= endRow; i++) res.add(array[i][endCol]);

      for (int i = endCol - 1; i >= startCol; i--) {
        if (startRow == endRow) break;

        res.add(array[endRow][i]);
      }

      for (int i = endRow - 1; i > startRow; i--) {
        if (startCol == endCol) break;

        res.add(array[i][startCol]);
      }

      ++startRow;
      ++startCol;
      --endRow;
      --endCol;
    }

    return res;
  }
}
