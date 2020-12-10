package Trees.BSTChecker;

// import java.util.ArrayList;

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

public class BSTChecker {

  private static boolean validateBST(
      // TreeNode root, TreeNode left, TreeNode  right
      TreeNode root, int min, int max) {

    // Base Case
    if (root == null) return true;

    // if (left != null && root.value <= left.value)
    //   return false;

    // if (right != null && root.value >= right.value)
    //   return false;

    if (min > root.value || max < root.value) return false;

    return validateBST(root.left, min, root.value) && validateBST(root.right, root.value, max);
  }

  public static boolean validateBST(TreeNode root) {

    return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
