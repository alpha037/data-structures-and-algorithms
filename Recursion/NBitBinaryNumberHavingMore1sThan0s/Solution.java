package Recursion.NBitBinaryNumberHavingMore1sThan0s;

import java.util.ArrayList;
import java.util.List;

/**
 * * Generate N-bit Binary Numbers Having More 1's Than 0's In All Prefixes
 */
public class Solution {
  private void generateNBitBinaryNumbers(
      int ones, int zeroes, int n, StringBuilder current, List<String> numbers) {
    /**
     * Base Case.
     */
    if (current.length() == n) {
      numbers.add(current.toString());
      return;
    }

    // First, we append "1" and try
    // out all the possibilities
    current.append("1");
    generateNBitBinaryNumbers(ones + 1, zeroes, n, current, numbers);

    // Then, we remove the "1" we added
    current.deleteCharAt(current.length() - 1);

    // We'll only be adding
    // zeroes if the number
    // of ones is greater than
    // the total number of zeroes
    if (zeroes < ones) {
      // Second, we append "0" and try
      // out all the possibilities
      current.append("0");
      generateNBitBinaryNumbers(ones, zeroes + 1, n, current, numbers);

      // Then, we remove the "0" we added
      current.deleteCharAt(current.length() - 1);
    }
  }

  public List<String> generateNBitBinaryNumbers(int n) {
    List<String> numbers = new ArrayList<>();

    generateNBitBinaryNumbers(0, 0, n, new StringBuilder(""), numbers);

    return numbers;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.generateNBitBinaryNumbers(4));
  }
}
