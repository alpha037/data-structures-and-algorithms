package LeetCode.Medium.LongestPalindromicSubstring;

/*
  5. Longest Palindromic Substring

  Given a string s, return the longest palindromic substring in s.


  Example 1:
  Input: s = "babad"
  Output: "bab"
  Note: "aba" is also a valid answer.

  Example 2:
  Input: s = "cbbd"
  Output: "bb"

  Example 3:
  Input: s = "a"
  Output: "a"

  Example 4:
  Input: s = "ac"
  Output: "a"


  Constraints:
  1 <= s.length <= 1000
  s consist of only digits and English letters (lower-case and/or upper-case),
*/

public class Solution {
  public String longestPalindrome(String s) {
    if (s.length() <= 1) return s;

    /**
     * * Dynamic Programming approach
     * * TC: O(n^2), SC: O(n^2)
     */

    // int n = s.length(), start = 0, maxLength = 1;
    // boolean[][] dp = new boolean[n][n];

    // for (int i=0; i<n; i++)
    //   dp[i][i] = true;

    // for (int i=0; i<n-1; i++)
    //   if (s.charAt(i) == s.charAt(i+1)) {
    //     dp[i][i+1] = true;
    //     start = i;
    //     maxLength = 2;
    //   }

    // for (int k=3; k<=n; k++)
    //   for (int i=0; i<n-k+1; i++) {
    //     int j = i + k - 1;

    //     if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
    //       dp[i][j] = true;

    //       if (k > maxLength) {
    //         start = i;
    //         maxLength = k;
    //       }
    //     }
    //   }

    /**
     * * Optimized space approach
     * * TC: O(n^2), SC: O(1)
     */
    int maxLength = 0, start = 0;

    for (int i = 0; i < s.length(); i++) {
      int length = Math.max(expand(s, i, i), expand(s, i, i + 1));
      if (length > maxLength) {
        maxLength = length;
        start = i - (maxLength - 1) / 2;
      }
    }

    return s.substring(start, start + maxLength);
  }

  private int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }

    return right - left - 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be "bab"
    System.out.println(solution.longestPalindrome("babad"));

    // should be "bb"
    // System.out.println(solution.longestPalindrome("cbbd"));

    // should be "a"
    // System.out.println(solution.longestPalindrome("a"));

    // should be "a"
    // System.out.println(solution.longestPalindrome("ac"));
  }
}
