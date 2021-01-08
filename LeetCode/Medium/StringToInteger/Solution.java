package LeetCode.Medium.StringToInteger;

/*
  8. String to Integer (atoi)

  Implement atoi which converts a string to an integer.

  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

  If no valid conversion could be performed, a zero value is returned.

  Note:
  Only the space character ' ' is considered a whitespace character.
  Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, 231 − 1 or −231 is returned.


  Example 1:
  Input: str = "42"
  Output: 42

  Example 2:
  Input: str = "   -42"
  Output: -42
  Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.

  Example 3:
  Input: str = "4193 with words"
  Output: 4193
  Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

  Example 4:
  Input: str = "words and 987"
  Output: 0
  Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.

  Example 5:
  Input: str = "-91283472332"
  Output: -2147483648
  Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.


  Constraints:
  0 <= s.length <= 200
  s consists of English letters (lower-case and upper-case), digits, ' ', '+', '-' and '.'.
*/

public class Solution {
  public int myAtoi(String s) {
    if (s == null || s.length() == 0) return 0;

    int res = 0, i = 0;
    boolean minus = false;

    while (i < s.length() && s.charAt(i) == ' ') ++i;

    if (i == s.length()) return 0;

    if (s.charAt(i) == '+' || s.charAt(i) == '-') minus = s.charAt(i++) == '-';

    if (i == s.length()) return 0;

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      int temp = s.charAt(i++) - '0';

      // If res is about to overflow
      // in the next iteration, then
      // we'll return MIN_VALUE or
      // MAX_VALUE depending on the
      // minus flag
      if (res > (Integer.MAX_VALUE - temp) / 10)
        return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      // Otherwise, we keep on
      // building the result
      res = (res * 10) + temp;
    }

    return minus ? res * -1 : res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 42
    System.out.println(solution.myAtoi("42"));

    // should be -42
    System.out.println(solution.myAtoi("   -42"));

    // should be 4193
    System.out.println(solution.myAtoi("4193 with words"));

    // should be 0
    System.out.println(solution.myAtoi("words with 987"));

    // should be -2147483648
    System.out.println(solution.myAtoi("-91283472332"));

    // should be 1
    System.out.println(solution.myAtoi("1"));
  }
}
