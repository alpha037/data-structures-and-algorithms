package LeetCode.Easy.MinimumDepthofBinaryTree;

/*
  111. Minimum Depth of Binary Tree

  Given a binary tree, find its minimum depth.

  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

  Note: A leaf is a node with no children.


  Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: 2

  Example 2:
  Input: root = [2,null,3,null,4,null,5,null,6]
  Output: 5


  Constraints:
  The number of nodes in the tree is in the range [0, 105].
  -1000 <= Node.val <= 1000
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
  /**
   * * Recursive approach
   */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    int lDepth = minDepth(root.left);
    int rDepth = minDepth(root.right);

    if (lDepth == 0 || rDepth == 0) return Math.max(lDepth, rDepth) + 1;

    return Math.min(lDepth, rDepth) + 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    // should be 2
    System.out.println(solution.minDepth(root));
  }
}
