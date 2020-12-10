package Arrays.LargestContinuousSum;

public class LargestContinuousSum {

  public static int find(int[] array) {

    // * Edge Case
    if (array.length == 0) return 0;

    int maxSum = array[0];
    int currentSum = array[0];

    // * Kadane's Algorithm
    for (int i = 1; i < array.length; i++) {

      currentSum = Math.max(currentSum + array[i], array[i]);

      maxSum = Math.max(currentSum, maxSum);
    }

    return maxSum;
  }
}
