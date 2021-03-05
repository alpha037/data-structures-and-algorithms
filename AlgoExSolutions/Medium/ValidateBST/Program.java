package AlgoExSolutions.Medium.ValidateBST;

// import java.util.*;

/**
 * * Validate BST
 */
class Program {
  private static boolean validateBST(BST root, int minValue, int maxValue) {
    if (root == null) return true;
    else if ((minValue != Integer.MIN_VALUE && root.value < minValue)
        || (maxValue != Integer.MAX_VALUE && root.value >= maxValue)) return false;
    else
      return validateBST(root.left, minValue, root.value)
          && validateBST(root.right, root.value, maxValue);
  }

  public static boolean validateBst(BST tree) {
    // Write your code here.
    return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
