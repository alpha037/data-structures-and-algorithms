package LeetCode.Easy.ValidPalindrome;

/*
  125. Valid Palindrome

  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

  Note: For the purpose of this problem, we define empty string as valid palindrome.

  Example 1:
  Input: "A man, a plan, a canal: Panama"
  Output: true

  Example 2:
  Input: "race a car"
  Output: false


  Constraints:
  s consists only of printable ASCII characters.
*/

public class Solution {
  public boolean isPalindrome(String s) {
    if (s.length() <= 1) return true;

    int i = 0, j = s.length() - 1;

    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) ++i;

      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) --j;

      if (i < j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

    // should be false
    System.out.println(solution.isPalindrome("race a car"));
  }
}
