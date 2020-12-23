package LeetCode.Easy.BalancedBinaryTree;

/*
  110. Balanced Binary Tree

  Given a binary tree, determine if it is height-balanced.

  For this problem, a height-balanced binary tree is defined as:

  a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


  Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: true

  Example 2:
  Input: root = [1,2,2,3,3,null,null,4,4]
  Output: false

  Example 3:
  Input: root = []
  Output: true


  Constraints:
  The number of nodes in the tree is in the range [0, 5000].
  -10^4 <= Node.val <= 10^4
*/

// Definition for a binary tree node.
// Not needed in the actual code.
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

  /**
   * * Simple, but inefficient as
   * * TC is O(n^2)
   */

  // private int height(TreeNode root, int count) {
  //   if (root == null)
  //     return count;

  //   return Math.max(
  //     height(root.left, count + 1), height(root.right, count + 1)
  //   );
  // }

  // public boolean isBalanced(TreeNode root) {
  //   if (root == null)
  //     return true;

  //   int lHeight = height(root.left, 0);
  //   int rHeight = height(root.right, 0);

  //   return Math.abs(lHeight - rHeight) <= 1
  //     && isBalanced(root.left) && isBalanced(root.right);
  // }

  /**
   * * Optimized solution, using
   * * DFS and bottom up approach
   * * to compute the height of
   * * the lower nodes first and
   * * then bubbling up the result
   *
   * * TC: O(n)
   */
  private boolean isBalanced = true;

  private int dfs(TreeNode root) {
    if (root == null) return -1;

    int lDepth = dfs(root.left);
    int rDepth = dfs(root.right);

    if (Math.abs(lDepth - rDepth) > 1) {
      isBalanced = false;
      return -1;
    }

    return Math.max(lDepth, rDepth) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    dfs(root);

    return isBalanced;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    // should be true
    System.out.println(solution.isBalanced(root));
  }
}
