package LeetCode.Easy.ExcelSheetColumnNumber;

/*
  171. Excel Sheet Column Number

  Given a column title as appear in an Excel sheet, return its corresponding column number.

  For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

  Example 1:
  Input: "A"
  Output: 1

  Example 2:
  Input: "AB"
  Output: 28

  Example 3:
  Input: "ZY"
  Output: 701


  Constraints:
  1 <= s.length <= 7
  s consists only of uppercase English letters.
  s is between "A" and "FXSHRXW".
*/

public class Solution {
  public int titleToNumber(String s) {
    int res = 0;

    for (int i = 0; i < s.length(); i++) res = (res * 26) + (s.charAt(i) - 'A' + 1);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 1
    System.out.println(solution.titleToNumber("A"));

    // should be 28
    System.out.println(solution.titleToNumber("AB"));

    // should be 701
    System.out.println(solution.titleToNumber("ZY"));

    // should be 52
    System.out.println(solution.titleToNumber("AZ"));

    // should be 2147483647
    System.out.println(solution.titleToNumber("FXSHRXW"));
  }
}
