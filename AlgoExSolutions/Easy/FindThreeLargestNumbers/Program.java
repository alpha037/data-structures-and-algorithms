package AlgoExSolutions.Easy.FindThreeLargestNumbers;

// import java.util.*;

/**
 * * Find Three Largest Numbers
 */
class Program {
  private static void shiftAndUpdate(int[] res, int num, int index) {
    for (int i = 0; i <= index; i++)
      if (i == index) res[i] = num;
      else res[i] = res[i + 1];
  }

  private static void updateResult(int[] res, int num) {
    if (num > res[2]) shiftAndUpdate(res, num, 2);
    else if (num > res[1]) shiftAndUpdate(res, num, 1);
    else if (num > res[0]) shiftAndUpdate(res, num, 0);

    return;
  }

  public static int[] findThreeLargestNumbers(int[] array) {
    // Write your code here.
    if (array == null || array.length < 3) return null;

    // 		int k = 3;
    // 		int[] res = new int[3];
    // 		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // 		for (int el : array)
    // 			maxHeap.add(el);

    // 		for (int i=k-1; i>=0; i--)
    // 			res[i] = maxHeap.poll();

    // 		return res;

    int[] res = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    for (int el : array) updateResult(res, el);

    return res;
  }
}
