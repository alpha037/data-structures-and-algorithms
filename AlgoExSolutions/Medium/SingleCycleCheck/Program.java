package AlgoExSolutions.Medium.SingleCycleCheck;

// import java.util.*;

/**
 * * Single Cycle Check
 */
class Program {
  private static int jump(int currentIdx, int[] array) {
    int len = array.length;
    int jumpIdx = (currentIdx + array[currentIdx]) % len;

    return jumpIdx >= 0 ? jumpIdx : len + jumpIdx;
  }

  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
    int currentIdx = 0, visitedElements = 0;

    while (visitedElements < array.length) {
      if (visitedElements > 0 && currentIdx == 0) return false;
      ++visitedElements;

      currentIdx = jump(currentIdx, array);
    }

    return currentIdx == 0;
  }
}
