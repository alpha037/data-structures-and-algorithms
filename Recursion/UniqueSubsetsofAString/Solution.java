package Recursion.UniqueSubsetsofAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * * Unique Subsets of A String
 * ? OR
 * * Distinct Subsets of A String
 * ? OR
 * * Distinct Subsets of A String In Lexicographical Order
 */
public class Solution {
  private void generateUniqueSubsets(
      String input, StringBuilder output, int index, List<String> subsets) {
    /**
     * Base Case.
     *
     * If the current index
     * is less than 0, then we
     * have found a potential
     * subset.
     */
    if (index < 0) {
      subsets.add(output.toString());
      return;
    }

    // First, we pick the current
    // character and try out all
    // the possibilities
    output.append(input.charAt(index));
    generateUniqueSubsets(input, output, index - 1, subsets);

    // Then, we ignore the duplicates
    // in the given input string
    while (index > 0 && input.charAt(index) == input.charAt(index - 1)) --index;

    // Finally, we don't pick the
    // current character and try out
    // all the possibilities
    output.deleteCharAt(output.length() - 1);
    generateUniqueSubsets(input, output, index - 1, subsets);
  }

  public List<String> generateUniqueSubsets(String string) {
    List<String> uniqueSubsets = new ArrayList<>();

    char[] characters = string.toCharArray();

    // For lexicographically sorted
    // subsets, we need to sort
    // the given input string
    Arrays.sort(characters);

    generateUniqueSubsets(
        new String(characters), new StringBuilder(""), string.length() - 1, uniqueSubsets);

    // For lexicographically sorted
    // subsets, we need to reverse
    // the list
    Collections.reverse(uniqueSubsets);

    return uniqueSubsets;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.generateUniqueSubsets("abd"));
  }
}
