package LeetCode.Easy.CountPrimes;

import java.util.Arrays;

/*
  204. Count Primes

  Count the number of prime numbers less than a non-negative number, n.


  Example 1:
  Input: n = 10
  Output: 4
  Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

  Example 2:
  Input: n = 0
  Output: 0

  Example 3:
  Input: n = 1
  Output: 0


  Constraints:
  0 <= n <= 5 * 106
*/

public class Solution {
  /**
   * * Naive approach
   * * TC: O(n^2)
   */

  // private boolean isPrime(int n) {
  //   if (n == 2)
  //     return true;

  //   if (n % 2 == 0)
  //     return false;

  //   for (int i=3; i<=Math.sqrt(n); i++)
  //     if (n % i == 0)
  //       return false;

  //   return true;
  // }

  // public int countPrimes(int n) {
  //   if (n <= 1)
  //     return 0;

  //   int count = 0;
  //   for (int i=2; i<n; i++)
  //     if (isPrime(i))
  //       ++count;

  //   return count;
  // }

  /**
   * * Sieve of Eratosthenes
   * * TC: O(n * log(log(n)))
   */
  public int countPrimes(int n) {
    if (n <= 1) return 0;

    int count = 0;

    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);

    for (int p = 2; p * p <= n; p++) {
      if (primes[p]) for (int i = p * p; i <= n; i += p) primes[i] = false;
    }

    for (int i = 2; i < n; i++) if (primes[i]) ++count;

    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 4
    System.out.println(solution.countPrimes(10));

    // should be 0
    System.out.println(solution.countPrimes(0));

    // should be 0
    System.out.println(solution.countPrimes(1));
  }
}
