package AlgoExSolutions.Hard.MaximizeExpression;

// import java.util.*;

/**
 * * Maximize Expression
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(4n) ~ O(n)
   */
  public int maximizeExpression(int[] array) {
    // Write your code here.
    int len = array.length;
    if (len < 4) return 0;

    int[] maxA = new int[len];
    maxA[0] = array[0];
    for (int i = 1; i < len; i++) maxA[i] = Math.max(maxA[i - 1], array[i]);

    int[] maxAMinusB = new int[len];
    maxAMinusB[0] = Integer.MIN_VALUE;
    for (int i = 1; i < len; i++)
      maxAMinusB[i] = Math.max(maxAMinusB[i - 1], maxA[i - 1] - array[i]);

    int[] maxAMinusBPlusC = new int[len];
    maxAMinusBPlusC[0] = maxAMinusBPlusC[1] = Integer.MIN_VALUE;
    for (int i = 2; i < len; i++)
      maxAMinusBPlusC[i] = Math.max(maxAMinusBPlusC[i - 1], maxAMinusB[i - 1] + array[i]);

    int[] maxAMinusBPlusCMinusD = new int[len];
    maxAMinusBPlusCMinusD[0] =
        maxAMinusBPlusCMinusD[1] = maxAMinusBPlusCMinusD[2] = Integer.MIN_VALUE;
    for (int i = 3; i < len; i++)
      maxAMinusBPlusCMinusD[i] =
          Math.max(maxAMinusBPlusCMinusD[i - 1], maxAMinusBPlusC[i - 1] - array[i]);

    return maxAMinusBPlusCMinusD[len - 1];
  }
}
