package LeetCode.Easy.RomanToInteger;

/*
 13. Roman to Integer

 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000

 For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer.


 Example 1:
 Input: s = "III"
 Output: 3

 Example 2:
 Input: s = "IV"
 Output: 4

 Example 3:
 Input: s = "IX"
 Output: 9

 Example 4:
 Input: s = "LVIII"
 Output: 58
 Explanation: L = 50, V= 5, III = 3.

 Example 5:
 Input: s = "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

 Constraints:
 1 <= s.length <= 15
 s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

public class Solution {
  private static int getRomanValue(char ch) {
    if (ch == 'I') return 1;

    if (ch == 'V') return 5;

    if (ch == 'X') return 10;

    if (ch == 'L') return 50;

    if (ch == 'C') return 100;

    if (ch == 'D') return 500;

    if (ch == 'M') return 1000;

    return -1;
  }

  public int romanToInt(String s) {
    int res = 0;

    for (int i = 0; i < s.length(); i++) {
      int val1 = getRomanValue(s.charAt(i));

      if (i + 1 < s.length()) {
        int val2 = getRomanValue(s.charAt(i + 1));

        if (val1 >= val2) res += val1;
        else {
          res += (val2 - val1);
          i++;
        }
      } else res += val1;
    }

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.romanToInt("III"));

    // should be 4
    System.out.println(solution.romanToInt("IV"));

    // should be 9
    System.out.println(solution.romanToInt("IX"));

    // should be 58
    System.out.println(solution.romanToInt("LVIII"));

    // should be 1994
    System.out.println(solution.romanToInt("MCMXCIV"));
  }
}
