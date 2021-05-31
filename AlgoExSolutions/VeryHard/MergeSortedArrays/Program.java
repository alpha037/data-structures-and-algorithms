package AlgoExSolutions.VeryHard.MergeSortedArrays;

import java.util.*;

/**
 * * Merge Sorted Arrays
 */
class Program {
  /**
   * * TC: O(n log(k) + k)
   * * SC: O(n)
   */
  public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
    // Write your code here.
    List<Integer> sortedArray = new ArrayList<>();
    PriorityQueue<Pair> minHeap = buildHeap(arrays);
    int[] indices = new int[arrays.size()];

    while (!minHeap.isEmpty()) {
      Pair min = minHeap.poll();
      sortedArray.add(min.value);

      int k = min.index;
      indices[k]++;
      if (indices[k] < arrays.get(k).size())
        minHeap.add(new Pair(k, arrays.get(k).get(indices[k])));
    }

    return sortedArray;
  }

  private static PriorityQueue<Pair> buildHeap(List<List<Integer>> arrays) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(arrays.size(), new ValueComparator());
    for (int k = 0; k < arrays.size(); k++) minHeap.add(new Pair(k, arrays.get(k).get(0)));
    return minHeap;
  }

  static class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  static class ValueComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
      return p1.value - p2.value;
    }
  }
}
