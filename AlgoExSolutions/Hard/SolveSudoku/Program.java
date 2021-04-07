package AlgoExSolutions.Hard.SolveSudoku;

import java.util.*;

/**
 * * Solve Sudoku
 */
class Program {
  /**
   * ? Generally,
   * * TC: O(9^(n * n)), as for every unassigned position,
   * * there are at most 9 choices.
   * * SC: O(n * n)
   *
   * ? But, if the size of the board remains constant, then
   * * TC: O(1)
   * * SC: O(1)
   */
  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    // Write your code here.
    solvePartialSudoku(0, 0, board);
    return board;
  }

  private boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
    int currentRow = row, currentCol = col;

    if (currentCol == board.get(row).size()) {
      currentCol = 0;
      currentRow++;

      if (currentRow == board.size()) return true;
    }

    if (board.get(currentRow).get(currentCol) == 0)
      return tryChoicesAtCurrentPosition(currentRow, currentCol, board);

    return solvePartialSudoku(currentRow, currentCol + 1, board);
  }

  private boolean tryChoicesAtCurrentPosition(
      int row, int col, ArrayList<ArrayList<Integer>> board) {
    for (int choice = 1; choice < 10; choice++) {
      if (isValidChoice(choice, row, col, board)) {
        board.get(row).set(col, choice);
        if (solvePartialSudoku(row, col, board)) return true;
      }
    }

    board.get(row).set(col, 0);
    return false;
  }

  private boolean isValidChoice(int choice, int row, int col, ArrayList<ArrayList<Integer>> board) {
    for (int colIdx = 0; colIdx < 9; colIdx++) {
      if (colIdx == col) continue;

      if (board.get(row).get(colIdx) == choice) return false;
    }

    for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
      if (rowIdx == row) continue;

      if (board.get(rowIdx).get(col) == choice) return false;
    }

    int startRow = (row / 3) * 3, startCol = (col / 3) * 3;

    for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
      for (int colIdx = 0; colIdx < 3; colIdx++) {
        int currentRow = startRow + rowIdx, currentCol = startCol + colIdx;
        if (currentRow == row && currentCol == col) continue;

        if (board.get(currentRow).get(currentCol) == choice) return false;
      }
    }

    return true;
  }
}
