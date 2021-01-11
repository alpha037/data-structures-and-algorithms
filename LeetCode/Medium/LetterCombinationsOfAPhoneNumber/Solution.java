package LeetCode.Medium.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
  17. Letter Combinations of a Phone Number

  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

  A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


  Example 1:
  Input: digits = "23"
  Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

  Example 2:
  Input: digits = ""
  Output: []

  Example 3:
  Input: digits = "2"
  Output: ["a","b","c"]


  Constraints:
  0 <= digits.length <= 4
  digits[i] is a digit in the range ['2', '9'].
*/

public class Solution {
  private final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private void letterCombinations(List<String> res, String digits, StringBuilder curr, int index) {
    if (index == digits.length()) {
      res.add(curr.toString());
      return;
    }

    char[] ch = MAP[digits.charAt(index) - '0'].toCharArray();
    for (char c : ch) {
      curr.append(c);
      letterCombinations(res, digits, curr, index + 1);
      curr.deleteCharAt(curr.length() - 1);
    }

    return;
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) return List.of();

    if (digits.length() == 1) return List.of(MAP[digits.charAt(0) - '0'].split(""));

    List<String> res = new ArrayList<>();
    StringBuilder curr = new StringBuilder();

    letterCombinations(res, digits, curr, 0);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be ["a", "b", "c"]
    System.out.println(solution.letterCombinations("2").toString());

    // should be ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    System.out.println(solution.letterCombinations("23").toString());
  }
}
