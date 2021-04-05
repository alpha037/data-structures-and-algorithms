package AlgoExSolutions.Hard.LaptopRentals;

import java.util.*;

/**
 * * Laptop Rentals
 */
class Program {
  /**
   * ? Note: Although the overall time and space complexities of
   * ? both the solutions are similar, however:
   *
   * - The first approach is marginally better at optimizing the space
   *   complexity than the second one. This is because our min heap is going
   *   to have at most N elements inside it, whereas in the second solution,
   *   we are explicitly storing 2N elements in two separate lists.
   *
   * - The second solution is marginally better at optimizing time complexity
   *   than the first one. This is because in the first solution, we have a
   *   lot of insert (or, add) and remove (or, poll) methods inside our for-loop
   *   which take O(log n) time each.
   */

  /**
   * * Approach using a Min-Heap
   *
   * * TC: O(n log(n))
   * * SC: O(n)
   */
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
    if (times.size() == 0) return 0;

    Collections.sort(times, (t1, t2) -> t1.get(0) - t2.get(0));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(times.get(0).get(1));

    for (int i = 1; i < times.size(); i++) {
      List<Integer> currentTimeInt = times.get(i);
      if (currentTimeInt.get(0) >= minHeap.peek()) minHeap.poll();

      minHeap.add(currentTimeInt.get(1));
    }

    return minHeap.size();
  }

  /**
   * * Approach using separate arrays for start and end times
   *
   * * TC: O(n log(n))
   * * SC: O(n)
   */
  // public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
  //   // Write your code here.
  // 	if (times.size() == 0) return 0;

  // 	List<Integer> startTimes = new ArrayList<>(), endTimes = new ArrayList<>();
  // 	int numberOfLaptops = 0, startTimeIdx = 0, endTimeIdx = 0;

  // 	for (List<Integer> time : times) {
  // 		startTimes.add(time.get(0));
  // 		endTimes.add(time.get(1));
  // 	}

  // 	Collections.sort(startTimes);
  // 	Collections.sort(endTimes);

  // 	while (startTimeIdx < startTimes.size()) {
  // 		if (startTimes.get(startTimeIdx) < endTimes.get(endTimeIdx)) {
  // 			++numberOfLaptops;
  // 			++startTimeIdx;
  // 		}
  // 		else {
  // 			++startTimeIdx;
  // 			++endTimeIdx;
  // 		}
  // 	}

  //   return numberOfLaptops;
  // }
}
