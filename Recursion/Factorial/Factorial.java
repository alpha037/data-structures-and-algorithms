package Recursion.Factorial;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

  private static Map<Integer, Integer> map = new HashMap<>();

  public static enum TYPE {
    RECURSIVE,
    MEMOIZATION
  };

  private static int recursiveFactorial(int n) {
    if (n < 2) return 1;

    return n * recursiveFactorial(n - 1);
  }

  private static int memoizedFactorial(int n) {
    if (n < 2) return 1;

    if (!map.containsKey(n)) map.put(n, n * memoizedFactorial(n - 1));

    return map.get(n);
  }

  public static int factorial(int n, TYPE type) {
    switch (type) {
      case RECURSIVE:
        return recursiveFactorial(n);

      case MEMOIZATION:
        return memoizedFactorial(n);

      default:
        System.out.println("Invalid type.");
        return -1;
    }
  }
}
