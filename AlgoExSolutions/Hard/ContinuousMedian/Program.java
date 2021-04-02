package AlgoExSolutions.Hard.ContinuousMedian;

import java.util.*;

/**
 * * Continuous Median
 */

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
  /**
   * * TC: O(log n)
   * * SC: O(n)
   */
  static class ContinuousMedianHandler {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    double median = 0;

    public void insert(int number) {
      // Write your code here.
      if (maxHeap.isEmpty() || number < maxHeap.peek()) maxHeap.add(number);
      else minHeap.add(number);

      reBalanceHeaps();
      updateMedian();
    }

    private void reBalanceHeaps() {
      if (maxHeap.size() - minHeap.size() == 2) minHeap.add(maxHeap.poll());
      else if (minHeap.size() - maxHeap.size() == 2) maxHeap.add(minHeap.poll());
    }

    private void updateMedian() {
      if (maxHeap.size() == minHeap.size()) calcEvenMedian();
      else calcOddMedian();
    }

    private void calcEvenMedian() {
      median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }

    private void calcOddMedian() {
      median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }

    public double getMedian() {
      return median;
    }
  }
}
