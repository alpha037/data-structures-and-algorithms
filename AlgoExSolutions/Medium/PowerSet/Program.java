package AlgoExSolutions.Medium.PowerSet;

import java.util.*;

/**
 * * PowerSet
 * ? OR
 * * All Subsets
 */
class Program {
  private static void powerset(
      List<Integer> array, List<Integer> current, int index, List<List<Integer>> set) {
    if (index < 0) {
      set.add(new ArrayList<>(current));
      return;
    }

    current.add(array.get(index));
    powerset(array, current, index - 1, set);

    current.remove(current.size() - 1);
    powerset(array, current, index - 1, set);
  }

  public static List<List<Integer>> powerset(List<Integer> array) {
    // Write your code here.
    List<List<Integer>> set = new ArrayList<>();

    powerset(array, new ArrayList<Integer>(), array.size() - 1, set);

    return set;
  }
}
