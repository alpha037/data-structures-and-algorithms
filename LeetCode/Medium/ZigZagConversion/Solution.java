package LeetCode.Medium.ZigZagConversion;

/*
  6. ZigZag Conversion

  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

  P   A   H   N
  A P L S I I G
  Y   I   R
  And then read line by line: "PAHNAPLSIIGYIR"

  Write the code that will take a string and make this conversion given a number of rows:

  string convert(string s, int numRows);

  Example 1:
  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"

  Example 2:
  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I

  Example 3:
  Input: s = "A", numRows = 1
  Output: "A"


  Constraints:
  1 <= s.length <= 1000
  s consists of English letters (lower-case and upper-case), ',' and '.'.
  1 <= numRows <= 1000
*/

public class Solution {
  /**
   * * TC: O(n), SC: O(1)
   */
  public String convert(String s, int numRows) {
    if (numRows <= 1 || numRows > s.length()) return s;

    StringBuilder res = new StringBuilder();
    int currentRow = 1, idx = 0;
    boolean down = true;

    while (currentRow <= numRows) {
      res.append(s.charAt(idx));

      // If we're going in the downward
      // direction, then the index would
      // jump at every 2 * (numRows
      // - currentRow) step
      if (down) idx += (numRows - currentRow) * 2;

      // Otherwise, if we're going up,
      // then the index would jump at
      // every 2 * (currentRow - 1)
      // step
      else idx += (currentRow - 1) * 2;

      // If the currentRow is not the
      // first row or the last last row,
      // then we can toggle down every
      // time
      if (currentRow != 1 && currentRow != numRows) down = !down;

      // If we're down with the
      // currentRow, then we
      // increment the currentRow
      // and reset the index at
      // currentRow - 1
      if (idx >= s.length()) {
        ++currentRow;
        idx = currentRow - 1;

        // If the currentRow is
        // less than the numRows,
        // then we're going in
        // the downward direction
        if (currentRow < numRows) down = true;

        // Otherwise, we're going up
        else down = false;
      }
    }

    return res.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be "PAHNAPLSIIGYIR"
    System.out.println(solution.convert("PAYPALISHIRING", 3));

    // should be "PINALSIGYAHRPI"
    System.out.println(solution.convert("PAYPALISHIRING", 4));

    // should be "A"
    System.out.println(solution.convert("A", 1));
  }
}
