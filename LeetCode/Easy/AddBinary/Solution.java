package LeetCode.Easy.AddBinary;

/*
  67. Add Binary

  Given two binary strings a and b, return their sum as a binary string.

  Example 1:
  Input: a = "11", b = "1"
  Output: "100"

  Example 2:
  Input: a = "1010", b = "1011"
  Output: "10101"


  Constraints:
  1 <= a.length, b.length <= 104
  a and b consist only of '0' or '1' characters.
  Each string does not contain leading zeros except for the zero itself.
*/

public class Solution {
  public String addBinary(String a, String b) {

    int i = a.length() - 1, j = b.length() - 1, sum = 0;
    StringBuilder res = new StringBuilder();

    while (i >= 0 || j >= 0) {

      sum += (i >= 0) ? a.charAt(i) - '0' : 0;
      sum += (j >= 0) ? b.charAt(j) - '0' : 0;

      // If the sum is 1 or 3, then add 0
      // and move 1 to carry
      res.append(sum % 2);

      // Compute the carry
      sum /= 2;

      --i;
      --j;
    }

    if (sum != 0) return res.append(sum).reverse().toString();

    return res.reverse().toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 100
    System.out.println(solution.addBinary("11", "1"));

    // should be 10101
    System.out.println(solution.addBinary("1010", "1011"));
  }
}
