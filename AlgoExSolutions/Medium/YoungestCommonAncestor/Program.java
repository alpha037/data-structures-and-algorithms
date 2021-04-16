package AlgoExSolutions.Medium.YoungestCommonAncestor;

// import java.util.*;

/**
 * * Youngest Common Ancestor
 */
class Program {
  private static int depth(AncestralTree topAncestor, AncestralTree descendant) {
    int depth = 0;

    while (descendant != topAncestor) {
      descendant = descendant.ancestor;
      ++depth;
    }

    return depth;
  }

  private static AncestralTree backtrack(AncestralTree lower, AncestralTree higher, int diff) {
    while (diff-- > 0) lower = lower.ancestor;

    while (lower != higher) {
      lower = lower.ancestor;
      higher = higher.ancestor;
    }

    return lower;
  }

  /**
   * * TC: O(d) | SC: O(1)
   */
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.
    int depthOne = depth(topAncestor, descendantOne);
    int depthTwo = depth(topAncestor, descendantTwo);

    if (depthOne > depthTwo) return backtrack(descendantOne, descendantTwo, depthOne - depthTwo);

    return backtrack(descendantTwo, descendantOne, depthTwo - depthOne);
  }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}
