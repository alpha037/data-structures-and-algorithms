package AlgoExSolutions.Medium.Permutations;

import java.util.*;

/**
 * * Permutations of an array of integers
 */
class Program {
  private static void swap(List<Integer> array, int src, int dest) {
    int temp = array.get(src);
    array.set(src, array.get(dest));
    array.set(dest, temp);
  }

  private static void getPermutationsHelper(
      List<Integer> array, int start, int end, List<List<Integer>> permutations) {
    if (start == end) permutations.add(new ArrayList<>(array));
    else
      for (int idx = start; idx <= end; idx++) {
        swap(array, start, idx);
        getPermutationsHelper(array, start + 1, end, permutations);
        swap(array, start, idx);
      }
  }

  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
    List<List<Integer>> permutations = new ArrayList<>();

    getPermutationsHelper(array, 0, array.size() - 1, permutations);

    return permutations;
  }
}
