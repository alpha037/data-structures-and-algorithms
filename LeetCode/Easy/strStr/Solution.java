package LeetCode.Easy.strStr;

public class Solution {
  public int strStr(String haystack, String needle) {

    if (haystack.equals(needle)) return 0;

    int len = needle.length();
    int i;

    for (i = 0; i < haystack.length() - len; i++)
      if (haystack.substring(i, i + len).equals(needle)) return i;

    // Check for the last len characters
    if (haystack.substring(i).equals(needle)) return i;

    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 2
    System.out.println(solution.strStr("hello", "ll"));

    // should be -1
    System.out.println(solution.strStr("aaaaa", "bba"));

    // should be 0
    System.out.println(solution.strStr("", ""));
  }
}
