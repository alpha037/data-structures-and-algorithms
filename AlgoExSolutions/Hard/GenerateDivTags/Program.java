package AlgoExSolutions.Hard.GenerateDivTags;

import java.util.*;

/**
 * * Generate Div Tags
 */
class Program {
  /**
   * * TC: O((2n)! / ((n! * ((n + 1)!)))) [catalan number]
   * * SC: O((2n)! / ((n! * ((n + 1)!))))
   */
  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
    ArrayList<String> divTags = new ArrayList<>();
    generateDivTags(numberOfTags, 0, 0, new ArrayList<>(), divTags);
    return divTags;
  }

  private void generateDivTags(
      int numberOfTags,
      int openTags,
      int closeTags,
      List<String> prefix,
      ArrayList<String> divTags) {
    if (openTags + closeTags == 2 * numberOfTags) {
      divTags.add(String.join("", prefix));
      return;
    }

    if (openTags < numberOfTags) {
      prefix.add("<div>");
      generateDivTags(numberOfTags, openTags + 1, closeTags, prefix, divTags);
      prefix.remove(prefix.size() - 1);
    }

    if (closeTags < openTags) {
      prefix.add("</div>");
      generateDivTags(numberOfTags, openTags, closeTags + 1, prefix, divTags);
      prefix.remove(prefix.size() - 1);
    }
  }
}
