package Trees.TrimBST;

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

public class Trimmer {

  public static TreeNode trimBST(TreeNode root, int min, int max) {

    // Base Case
    if (root == null) return null;

    // If the current value is less than min,
    // then discard the entire left subtree
    // return the right subtree as this is a
    // Binary search tree
    if (root.value < min) return root.right;

    // If the current value is greater than max,
    // then discard the entire right subtree
    // return the left subtree according to
    // the BST property
    if (root.value > max) return root.left;

    // If the current value is in range, then
    // traverse it's left subtree
    root.left = trimBST(root.left, min, max);
    root.right = trimBST(root.right, min, max);

    return root;
  }

  public static void traverse(TreeNode root) {
    if (root != null) {
      traverse(root.left);
      System.out.print(root.value + " ");
      traverse(root.right);
    }
  }
}
