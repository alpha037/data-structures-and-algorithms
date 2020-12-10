package Arrays.ArrayPairSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayPairSum {

  public static void getUniquePairs(int[] array, int k) {

    // Edge Case
    if (array.length <= 2) return;

    // To change the integer array into an ArrayList
    List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

    List<Integer> sums = new ArrayList<>();
    Map<Integer, Boolean> map = new HashMap<>();

    // Iterate over the hashmap and set false (not visited)
    // as a default value
    for (Integer i : list) map.put(i, false);

    for (int i = 0; i < list.size(); i++) {
      int temp = k - list.get(i);

      // If the list contains the result of (k - arr[i]) and
      // if that element is not visited and if that element is not itself,
      // then only this condition should execute
      if (list.contains(temp) && !map.get(temp) && (list.indexOf(temp) != i)) {

        // If the condition is true, add the element to the sums list
        sums.add(list.get(i));
        sums.add(temp);

        // And then, mark them as visited (true)
        map.put(list.get(i), true);
        map.put(temp, true);
      }
    }

    printPairs(sums);
  }

  private static void printPairs(List<Integer> list) {
    System.out.println("No. of Pairs: " + list.size() / 2);

    for (int i = 0; i < list.size() - 1; i += 2)
      System.out.println("(" + list.get(i) + ", " + list.get(i + 1) + ")");
  }
}
