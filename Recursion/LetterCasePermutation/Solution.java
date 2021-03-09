package Recursion.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * * Letter Case Permutation
 */
public class Solution {
  /**
   * Helper function to check if
   * a character is a digit or not.
   */
  private boolean isDigit(char ch) {
    return Character.isDigit(ch);
  }

  /**
   * Helper function to toggle
   * the case of a character.
   */
  private char toggleCharacterCase(char ch) {
    return Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
  }

  private void getPermutationsWithLetterCaseChange(
      String input, int index, String output, List<String> perms) {
    /**
     * Base Case.
     *
     * If index is equal to the
     * input length, then we've
     * found a potential output.
     */
    if (index == input.length()) {
      perms.add(output.toString());
      return;
    }

    char currentChar = input.charAt(index);

    // If the current character
    // is a digit, then we don't
    // need to perform any case
    // change. We just add it to
    // the output string.
    if (isDigit(currentChar)) {
      getPermutationsWithLetterCaseChange(input, index + 1, output + currentChar, perms);
    } else {
      // First, we first toggle the
      // case of the current character
      // and consider all possible
      // scenarios.
      getPermutationsWithLetterCaseChange(
          input, index + 1, output + toggleCharacterCase(currentChar), perms);

      // Second, we don't first toggle the
      // case of the current character
      // and consider all possible
      // scenarios.
      getPermutationsWithLetterCaseChange(input, index + 1, output + currentChar, perms);
    }
  }

  public List<String> getPermutationsWithLetterCaseChange(String string) {
    List<String> perms = new ArrayList<>();

    getPermutationsWithLetterCaseChange(string, 0, "", perms);

    return perms;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.getPermutationsWithLetterCaseChange("A1B2"));
  }
}
