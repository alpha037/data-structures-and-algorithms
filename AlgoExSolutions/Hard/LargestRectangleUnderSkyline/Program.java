package AlgoExSolutions.Hard.LargestRectangleUnderSkyline;

import java.util.*;

/**
 * * Largest Rectangle Under Skyline
 */
class Program {

  /**
   * * TC: O(n)
   * * SC: O(n)
   */
  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    // Write your code here.
    List<Integer> extendedBuildings = new ArrayList<>(buildings);
    extendedBuildings.add(0);
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;

    for (int idx = 0; idx < extendedBuildings.size(); idx++) {
      int currentHeight = extendedBuildings.get(idx);

      while (!stack.isEmpty() && currentHeight < extendedBuildings.get(stack.peek())) {
        int previousHeight = extendedBuildings.get(stack.pop());
        int width = stack.isEmpty() ? idx : idx - stack.peek() - 1;
        maxArea = Math.max(maxArea, width * previousHeight);
      }

      stack.push(idx);
    }

    return maxArea;
  }
}
