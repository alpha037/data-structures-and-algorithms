package AlgoExSolutions.Easy.ProductSum;

import java.util.*;

/**
 * * Product Sum
 */
class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  @SuppressWarnings("unchecked")
  public static int productSum(List<Object> array, int depth) {
    if (array == null || array.size() == 0) return 0;

    int sum = 0;
    for (Object val : array)
      if (val instanceof Integer) sum += (depth * (Integer) val);
      else sum += (depth * productSum((List<Object>) val, depth + 1));

    return sum;
  }

  public static int productSum(List<Object> array) {
    // Write your code here.
    return productSum(array, 1);
  }
}
