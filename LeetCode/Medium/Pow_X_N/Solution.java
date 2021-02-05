package LeetCode.Medium.Pow_X_N;

/*
  50. Pow(x, n)

  Implement pow(x, n), which calculates x raised to the power n (i.e. xn).


  Example 1:
  Input: x = 2.00000, n = 10
  Output: 1024.00000

  Example 2:
  Input: x = 2.10000, n = 3
  Output: 9.26100

  Example 3:
  Input: x = 2.00000, n = -2
  Output: 0.25000
  Explanation: 2-2 = 1/22 = 1/4 = 0.25


  Constraints:
  -100.0 < x < 100.0
  -231 <= n <= 231-1
  -104 <= xn <= 104
*/

public class Solution {
  public double myPow(double x, int n) {
    if (x == 0) return 0;

    if (n == 0) return 1;

    double res = 1.0d;
    long N = n;

    if (n < 0) N *= -1;

    while (N > 0) {
      if (N % 2 == 0) {
        x *= x;
        N /= 2;
      } else {
        res *= x;
        N--;
      }
    }

    return n < 0 ? (double) (1.0 / res) : res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 1024.00000
    System.out.println(solution.myPow(2.00000, 10));

    // should be 9.26100
    System.out.println(solution.myPow(2.10000, 3));

    // should be 0.25000
    System.out.println(solution.myPow(2.00000, -2));
  }
}
