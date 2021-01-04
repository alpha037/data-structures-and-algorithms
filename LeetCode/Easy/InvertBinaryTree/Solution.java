package LeetCode.Easy.InvertBinaryTree;

/*
  226. Invert Binary Tree

  Invert a binary tree.

  Example:

  Input:
      4
    /   \
   2     7
  / \   / \
 1   3 6   9

  Output:
      4
    /   \
   7     2
  / \   / \
 9   6 3   1

  Trivia:
  This problem was inspired by this original tweet by Max Howell:
  Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
*/

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    // Recursively call the left and
    // right subtrees
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    // Replace left subtree
    // with the right one
    // and vice versa
    root.left = right;
    root.right = left;

    return root;
  }

  public void display(TreeNode root) {
    if (root == null) return;

    display(root.left);
    System.out.print(root.val + " ");
    display(root.right);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

    // should be 1 2 3 4 6 7 9
    System.out.println("\nBefore inverting: ");
    solution.display(root);

    // should be 9 7 6 4 3 2 1
    System.out.println("\n\nAfter inverting: ");
    solution.display(solution.invertTree(root));
  }
}
