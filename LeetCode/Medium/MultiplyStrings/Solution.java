package LeetCode.Medium.MultiplyStrings;

/*
  43. Multiply Strings

  Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

  Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


  Example 1:
  Input: num1 = "2", num2 = "3"
  Output: "6"

  Example 2:
  Input: num1 = "123", num2 = "456"
  Output: "56088"


  Constraints:
  1 <= num1.length, num2.length <= 200
  num1 and num2 consist of digits only.
  Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/

public class Solution {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();

    if (len1 == 0 || len2 == 0) return "0";

    int[] result = new int[len1 + len2 + 1];
    int pos1 = 0, pos2 = 0;

    for (int i = len1 - 1; i >= 0; i--) {
      int carry = 0;
      pos2 = 0;

      for (int j = len2 - 1; j >= 0; j--) {
        int sum = carry + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + result[pos1 + pos2];

        carry = sum / 10;
        result[pos1 + pos2] = sum % 10;

        pos2++;
      }

      if (carry > 0) result[pos1 + pos2] += carry;

      pos1++;
    }

    // Ignore trailing zeroes
    // from the right
    int i = result.length - 1;
    while (i >= 0 && result[i] == 0) --i;

    // This means that
    // the result is 0
    if (i < 0) return "0";

    StringBuilder sb = new StringBuilder();

    while (i >= 0) sb.append(result[i--]);

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be "6"
    System.out.println(solution.multiply("2", "3"));

    // should be "56088"
    System.out.println(solution.multiply("123", "456"));
  }
}
