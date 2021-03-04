package AlgoExSolutions.Easy.ValidateSubSequence;

import java.util.*;

/**
 * * Validate Subsequence
 */
class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
    int j = 0;
    for (int i = 0; i < array.size(); i++)
      if (i < array.size() && j < sequence.size() && array.get(i) == sequence.get(j)) ++j;

    return (j == sequence.size());
  }
}
