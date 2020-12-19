package LeetCode.Easy.SymmetricTree;

/*
  101. Symmetric Tree

  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

      1
    / \
    2   2
  / \ / \
  3  4 4  3


  But the following [1,2,2,null,3,null,3] is not:

      1
    / \
    2   2
    \   \
    3    3


  Follow up: Solve it both recursively and iteratively.
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
  private static boolean isSymmetric(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;

    if (p != null && q != null && p.val == q.val)
      return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);

    return false;
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    return isSymmetric(root.left, root.right);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    // should be true
    System.out.println(solution.isSymmetric(root));
  }
}
