package LeetCode.Easy.IsomorphicStrings;

/*
  205. Isomorphic Strings

  Given two strings s and t, determine if they are isomorphic.

  Two strings are isomorphic if the characters in s can be replaced to get t.

  All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

  Example 1:
  Input: s = "egg", t = "add"
  Output: true

  Example 2:
  Input: s = "foo", t = "bar"
  Output: false

  Example 3:
  Input: s = "paper", t = "title"
  Output: true

  Note:
  You may assume both s and t have the same length.
*/

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    // Since, there are total
    // 256 characters in ASCII
    int[] sMap = new int[256];
    int[] tMap = new int[256];

    // If they are supposed to
    // be isomorphic, then their
    // positions must be same
    for (int i = 0; i < s.length(); i++) {
      if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) return false;

      sMap[s.charAt(i)] = i + 1;
      tMap[t.charAt(i)] = i + 1;
    }

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isIsomorphic("egg", "add"));

    // should be false
    System.out.println(solution.isIsomorphic("foo", "bar"));

    // should be true
    System.out.println(solution.isIsomorphic("paper", "title"));

    // should be false
    System.out.println(solution.isIsomorphic("abba", "abab"));
  }
}
