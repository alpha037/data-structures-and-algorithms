package LeetCode.Medium.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  49. Group Anagrams

  Given an array of strings strs, group the anagrams together. You can return the answer in any order.

  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


  Example 1:
  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

  Example 2:
  Input: strs = [""]
  Output: [[""]]

  Example 3:
  Input: strs = ["a"]
  Output: [["a"]]


  Constraints:
  1 <= strs.length <= 104
  0 <= strs[i].length <= 100
  strs[i] consists of lower-case English letters.
*/

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);

      if (!map.containsKey(sortedWord)) map.put(sortedWord, new ArrayList<>());

      map.get(sortedWord).add(word);
    }

    res.addAll(map.values());
    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(
        solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}).toString());

    System.out.println(solution.groupAnagrams(new String[] {""}).toString());

    System.out.println(solution.groupAnagrams(new String[] {"a"}).toString());
  }
}
