package AlgoExSolutions.Medium.ReverseWordsInAString;

import java.util.*;

/**
 * * Reverse Words In A String
 */
class Program {
  public String reverseWordsInString(String string) {
    // Write your code here.
    List<String> words = new ArrayList<>();
    int start = 0;

    for (int idx = 0; idx < string.length(); ++idx) {
      if (string.charAt(idx) == ' ') {
        words.add(string.substring(start, idx));
        start = idx;
      } else if (string.charAt(start) == ' ') {
        words.add(" ");
        start = idx;
      }
    }

    words.add(string.substring(start));

    Collections.reverse(words);
    return String.join("", words);
  }
}
