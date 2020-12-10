package Recursion.Permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

  private static List<String> permutations = new ArrayList<>();

  private static List<String> permute(String string, String res) {

    // * Base Case
    if (string.length() == 0) permutations.add(res);

    for (int i = 0; i < string.length(); i++)
      permute(string.substring(0, i) + string.substring(i + 1), res + string.charAt(i));

    return permutations;
  }

  public static List<String> permute(String string) {
    return permute(string, "");
  }

  public static void clearList() {
    permutations.clear();
  }
}
