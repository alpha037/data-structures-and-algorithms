package Recursion.PermutationWithCaseChange;

import java.util.ArrayList;
import java.util.List;

/**
 * * Permutation With Case Change
 */
public class Solution {
  private void getPermutationsWithCaseChange(
      String input, int index, String output, List<String> perms) {
    /**
     * * TC: O(n * 2^n).
     */

    /**
     * ? Recursive Approach
     */

    /**
     * Base Case.
     *
     * If the current index is
     * equal to the input string
     * length, then we've found
     * a potential permutation.
     */
    if (index == input.length()) {
      perms.add(output.toString());
      return;
    }

    // First, we consider changing the case
    // of  the current character and
    // then we try out all the possibilities
    // in that scenario
    getPermutationsWithCaseChange(
        input, index + 1, output + Character.toUpperCase(input.charAt(index)), perms);

    // First, we don't consider changing the
    // case of  the current character and
    // then we try out all the possibilities
    // in that scenario
    getPermutationsWithCaseChange(input, index + 1, output + input.charAt(index), perms);
  }

  public List<String> getPermutationsWithCaseChange(String string) {
    List<String> perms = new ArrayList<>();

    getPermutationsWithCaseChange(string.toLowerCase(), 0, "", perms);

    return perms;
  }

  /**
   * ? Bit-Masking Approach
   */

  //   public List<String> getPermutationsWithCaseChange(String string) {
  //   List<String> perms = new ArrayList<>();

  //   string = string.toLowerCase();
  //   int len = string.length(), numberOfPossibilities = 1 << len;

  //   for (int i = 0; i < numberOfPossibilities; i++) {
  //     char[] perm = string.toCharArray();

  //     for (int j = 0; j < len; j++) {
  //       if (((i >> j) & 1) == 1)
  //         perm[j] = (char) (perm[j] - 32);
  //     }

  //     perms.add(new String(perm));
  //   }

  //   return perms;
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.getPermutationsWithCaseChange("ABC"));
  }
}
