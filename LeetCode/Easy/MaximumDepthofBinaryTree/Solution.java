package LeetCode.Easy.MaximumDepthofBinaryTree;

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
  private int maxDepth(TreeNode root, int count) {
    if (root == null) return count;

    return Math.max(maxDepth(root.left, count + 1), maxDepth(root.right, count + 1));
  }

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    return maxDepth(root, 0);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    // should be 3
    System.out.println(solution.maxDepth(root));
  }
}
