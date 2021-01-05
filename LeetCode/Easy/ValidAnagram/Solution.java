package LeetCode.Easy.ValidAnagram;

// import java.util.Arrays;
import java.util.HashMap;

/*
  242. Valid Anagram

  Given two strings s and t , write a function to determine if t is an anagram of s.

  Example 1:
  Input: s = "anagram", t = "nagaram"
  Output: true

  Example 2:
  Input: s = "rat", t = "car"
  Output: false

  Note:
  You may assume the string contains only lowercase alphabets.

  Follow up:
  What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    /**
     * * Sorting approach
     * * TC: O(n * log(n)), SC: O(1)
     */

    // char[] sArray = (s.toCharArray());
    // Arrays.sort(sArray);
    // char[] tArray = t.toCharArray();
    // Arrays.sort(tArray);

    // return Arrays.equals(sArray, tArray);

    /**
     * * Hashmap approach
     * * TC: O(n), SC: O(n)
     */
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

    for (int i = 0; i < t.length(); i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);

    for (int val : map.values()) if (val != 0) return false;

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isAnagram("anagram", "nagaram"));

    // should be false
    System.out.println(solution.isAnagram("rat", "car"));
  }
}
