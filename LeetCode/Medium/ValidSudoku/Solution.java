package LeetCode.Medium.ValidSudoku;

/*
  36. Valid Sudoku

  Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

  Each row must contain the digits 1-9 without repetition.
  Each column must contain the digits 1-9 without repetition.
  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
  Note:
  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
  Only the filled cells need to be validated according to the mentioned rules.


  Example 1:
  Input: board =
  [["5","3",".",".","7",".",".",".","."]
  ,["6",".",".","1","9","5",".",".","."]
  ,[".","9","8",".",".",".",".","6","."]
  ,["8",".",".",".","6",".",".",".","3"]
  ,["4",".",".","8",".","3",".",".","1"]
  ,["7",".",".",".","2",".",".",".","6"]
  ,[".","6",".",".",".",".","2","8","."]
  ,[".",".",".","4","1","9",".",".","5"]
  ,[".",".",".",".","8",".",".","7","9"]]
  Output: true


  Example 2:
  Input: board =
  [["8","3",".",".","7",".",".",".","."]
  ,["6",".",".","1","9","5",".",".","."]
  ,[".","9","8",".",".",".",".","6","."]
  ,["8",".",".",".","6",".",".",".","3"]
  ,["4",".",".","8",".","3",".",".","1"]
  ,["7",".",".",".","2",".",".",".","6"]
  ,[".","6",".",".",".",".","2","8","."]
  ,[".",".",".","4","1","9",".",".","5"]
  ,[".",".",".",".","8",".",".","7","9"]]
  Output: false

  Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


  Constraints:
  board.length == 9
  board[i].length == 9
  board[i][j] is a digit or '.'.
*/

/**
 * Solution
 */
public class Solution {
  private boolean isValidSudoku(char[][] board, int row, int col, char target) {
    // Check the current row
    for (int i = 0; i < 9; i++) {
      if (i == row) continue;

      if (board[i][col] == target) return false;
    }

    // Check the current column
    for (int j = 0; j < 9; j++) {
      if (j == col) continue;

      if (board[row][j] == target) return false;
    }

    int startRow = row - (row % 3);
    int startCol = col - (col % 3);

    // Check the current box
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++) {
        if (i + startRow == row && j + startCol == col) continue;

        if (board[i + startRow][j + startCol] == target) return false;
      }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int row = 0; row < 9; row++)
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') continue;

        if (!isValidSudoku(board, row, col, board[row][col])) return false;
      }

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(
        solution.isValidSudoku(
            new char[][] {
              {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
              {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
              {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
              {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
              {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
              {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
              {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
              {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            }));

    // should be false
    System.out.println(
        solution.isValidSudoku(
            new char[][] {
              {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
              {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
              {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
              {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
              {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
              {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
              {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
              {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
              {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            }));
  }
}
