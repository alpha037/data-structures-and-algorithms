package AlgoExSolutions.Easy.NthFibonacci;

import java.util.*;

/**
 * * Nth Fibonacci
 */
class Program {
  private static int getNthFib(int n, Map<Integer, Integer> map) {
    if (n == 1) return 0;

    if (n == 2) return 1;

    if (map.containsKey(n)) return map.get(n);

    map.put(n, getNthFib(n - 1, map) + getNthFib(n - 2, map));

    return map.get(n);
  }

  public static int getNthFib(int n) {
    // Write your code here.
    return getNthFib(n, new HashMap<>());
  }
}
