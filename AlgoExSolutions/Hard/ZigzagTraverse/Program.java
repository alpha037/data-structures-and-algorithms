package AlgoExSolutions.Hard.ZigzagTraverse;

import java.util.*;

/**
 * * Zigzag Traverse
 */
class Program {
  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    // Write your code here.
    List<Integer> elements = new ArrayList<>();
    boolean goingDown = true;
    int height = array.size(), width = array.get(0).size();
    int row = 0, col = 0;

    while (!isOutOfBounds(row, col, height, width)) {
      elements.add(array.get(row).get(col));

      if (goingDown) {
        if (col == 0 || row == height - 1) {
          goingDown = false;

          if (row == height - 1) ++col;
          else ++row;
        } else {
          ++row;
          --col;
        }
      } else {
        if (row == 0 || col == width - 1) {
          goingDown = true;

          if (col == width - 1) ++row;
          else ++col;
        } else {
          --row;
          ++col;
        }
      }
    }

    return elements;
  }

  private static boolean isOutOfBounds(int row, int col, int height, int width) {
    return (row < 0 || row >= height || col < 0 || col >= width);
  }
}
