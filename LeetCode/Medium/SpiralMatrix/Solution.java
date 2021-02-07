package LeetCode.Medium.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/*
  54. Spiral Matrix

  Given an m x n matrix, return all elements of the matrix in spiral order.


  Example 1:
  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  Output: [1,2,3,6,9,8,7,4,5]

  Example 2:
  Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
  Output: [1,2,3,4,8,12,11,10,9,5,6,7]


  Constraints:
  m == matrix.length
  n == matrix[i].length
  1 <= m, n <= 10
  -100 <= matrix[i][j] <= 100
*/

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    int startRow = 0, startCol = 0;
    int endRow = matrix.length - 1, endCol = matrix[0].length - 1;
    List<Integer> res = new ArrayList<>();

    while (startRow <= endRow && startCol <= endCol) {
      for (int col = startCol; col <= endCol; col++) res.add(matrix[startRow][col]);

      for (int row = startRow + 1; row <= endRow; row++) res.add(matrix[row][endCol]);

      for (int col = endCol - 1; col >= startCol; col--) {
        if (startRow == endRow) break;

        res.add(matrix[endRow][col]);
      }

      for (int row = endRow - 1; row > startRow; row--) {
        if (startCol == endCol) break;

        res.add(matrix[row][startCol]);
      }

      ++startRow;
      ++startCol;
      --endRow;
      --endCol;
    }

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [1,2,3,6,9,8,7,4,5]
    System.out.println(
        solution.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString());

    // should be [1,2,3,4,8,12,11,10,9,5,6,7]
    System.out.println(
        solution.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toString());
  }
}
