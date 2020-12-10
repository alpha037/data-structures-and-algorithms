package Recursion.SplitPhrase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SplitPhrase {

  static Set<String> splitWords = new HashSet<>();

  public static ArrayList<String> split(String phrase, String[] words) {

    for (String word : words)
      if (phrase.startsWith(word)) {
        splitWords.add(word);

        return split(phrase.substring(word.length()), words);
      }

    return new ArrayList<>(splitWords);
  }

  public static void clearList() {
    splitWords.clear();
  }
}
