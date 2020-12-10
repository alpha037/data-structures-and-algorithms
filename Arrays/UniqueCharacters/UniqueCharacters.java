package Arrays.UniqueCharacters;

// import java.util.HashMap;
import java.util.HashSet;
// import java.util.Map;
import java.util.Set;

public class UniqueCharacters {
  public static boolean isUnique(String string) {

    // * Edge Cases
    if (string == null || string.length() < 1) return true;

    /**
     * ? HashSet Solution
     */
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < string.length(); i++)
      if (set.contains(string.charAt(i))) return false;
      else set.add(string.charAt(i));

    return true;

    /**
     * ? HashMap Solution
     */

    // Map<Character, Integer> map = new HashMap<>();

    // for (int i = 0; i < string.length(); i++)
    // map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);

    // for (Integer value : map.values())
    // if (value > 1)
    // return false;

    // return true;
  }
}
