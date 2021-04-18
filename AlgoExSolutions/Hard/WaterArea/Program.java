package AlgoExSolutions.Hard.WaterArea;

// import java.util.*;

/**
 * * Water Area
 */
class Program {
  /**
   * * Two-pointers Approach
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  public static int waterArea(int[] heights) {
    // Write your code here.
    if (heights.length == 0) return 0;

    int left = 0, right = heights.length - 1, waterArea = 0;
    int leftMax = heights[left], rightMax = heights[right];

    while (left < right) {
      if (heights[left] < heights[right]) {
        leftMax = Math.max(leftMax, heights[++left]);
        waterArea += leftMax - heights[left];
      } else {
        rightMax = Math.max(rightMax, heights[--right]);
        waterArea += rightMax - heights[right];
      }
    }

    return waterArea;
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(n)
   * * SC: O(n)
   */
  // public static int waterArea(int[] heights) {
  // 	int len = heights.length, waterArea = 0;
  // 	int[] maxHeights = new int[len];

  // 	int maxHeight = Integer.MIN_VALUE;
  // 	for (int i = 0; i < len; i++) {
  // 		maxHeight = Math.max(maxHeight, heights[i]);
  // 		maxHeights[i] = maxHeight;
  // 	}

  // 	maxHeight = Integer.MIN_VALUE;
  // 	for (int i = len - 1; i >= 0; i--) {
  // 		maxHeight = Math.max(maxHeight, heights[i]);
  // 		maxHeights[i] = Math.min(maxHeight, maxHeights[i]) - heights[i];
  // 	}

  // 	for (int height : maxHeights) waterArea += height;

  //   return waterArea;
  // }
}
