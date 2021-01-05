package LeetCode.Easy.PowerofTwo;

/*
  231. Power of Two

  Given an integer n, return true if it is a power of two. Otherwise, return false.

  An integer n is a power of two, if there exists an integer x such that n == 2x.


  Example 1:
  Input: n = 1
  Output: true
  Explanation: 20 = 1

  Example 2:
  Input: n = 16
  Output: true
  Explanation: 24 = 16

  Example 3:
  Input: n = 3
  Output: false

  Example 4:
  Input: n = 4
  Output: true

  Example 5:
  Input: n = 5
  Output: false


  Constraints:
  -231 <= n <= 231 - 1
*/

public class Solution {
  public boolean isPowerOfTwo(int n) {
    /**
     * * Simple approach
     */

    // if (n <= 0)
    //   return false;

    // while (n > 0) {
    //   if (n % 2 != 0 && n != 1)
    //     return false;

    //   n /= 2;
    // }

    // return true;

    /**
     * * Bit Manipulation
     */
    return (n > 0) && (n & (n - 1)) == 0;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isPowerOfTwo(1));

    // should be true
    System.out.println(solution.isPowerOfTwo(16));

    // should be false
    System.out.println(solution.isPowerOfTwo(3));

    // should be false
    System.out.println(solution.isPowerOfTwo(-2147483648));
  }
}
