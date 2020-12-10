package Recursion.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  private static Map<Integer, Integer> map = new HashMap<>();

  public static enum TYPE {
    RECURSION,
    MEMOIZATION,
    ITERATION,
  }

  public static int fibo(int n, TYPE type) {
    switch (type) {
      case RECURSION:
        return fibonacciByRecursion(n);

      case MEMOIZATION:
        return fibonacciByMemoization(n);

      case ITERATION:
        return fibonacciByIteration(n);

      default:
        System.err.println("Invalid type");
        return -1;
    }
  }

  private static int fibonacciByRecursion(int n) {

    // * Base Case
    if (n <= 1) return n;

    return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
  }

  private static int fibonacciByMemoization(int n) {

    // * Base Case
    if (n <= 1) return n;

    if (!map.containsKey(n))
      map.put(n, fibonacciByMemoization(n - 1) + fibonacciByMemoization(n - 2));

    return map.get(n);
  }

  private static int fibonacciByIteration(int n) {

    if (n <= 2) return 1;

    int n1 = 0, n2 = 1, sum = 0;

    for (int i = 2; i <= n; i++) {
      sum = n1 + n2;
      n1 = n2;
      n2 = sum;
    }

    return sum;
  }
}
