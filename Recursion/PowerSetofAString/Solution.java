package Recursion.PowerSetofAString;

import java.util.ArrayList;
import java.util.List;

/**
 * * Power Set Of A String,
 * ? OR
 * * All Subsets Of A String,
 * ? OR
 * * All Subsequences Of A String
 */
public class Solution {
  private void generatePowerSet(String input, String output, List<String> powerSet) {
    /**
     * Base Case.
     *
     * If the input string is
     * empty, then we've found
     * a potential result
     */
    if (input.length() == 0) {
      powerSet.add(output);
      return;
    }

    // First, we pick the first character
    // of the input and try out all the
    // possibilities
    generatePowerSet(input.substring(1), output + input.charAt(0), powerSet);

    // Second, we don't pick the first
    // character and try out all the
    // possibilities
    generatePowerSet(input.substring(1), output, powerSet);
  }

  public List<String> generatePowerSet(String string) {
    List<String> powerSet = new ArrayList<>();
    generatePowerSet(string, "", powerSet);

    return powerSet;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.generatePowerSet("abc"));
  }
}
