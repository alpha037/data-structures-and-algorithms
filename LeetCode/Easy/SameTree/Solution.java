package LeetCode.Easy.SameTree;

/*
  100. Same Tree

  Given two binary trees, write a function to check if they are the same or not.

  Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

  Example 1:
  Input:     1         1
            / \       / \
           2   3     2   3

          [1,2,3],   [1,2,3]
  Output: true

  Example 2:
  Input:     1         1
            /           \
           2             2

          [1,2],     [1,null,2]
  Output: false

  Example 3:
  Input:     1         1
            / \       / \
           2   1     1   2

          [1,2,1],   [1,1,2]

  Output: false
*/

// Definition for TreeNode.
// Not needed in the actual code..
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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;

    if (p == null || q == null) return false;

    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    // should be true
    System.out.println(solution.isSameTree(p, q));

    p = q = null;

    p = new TreeNode(1, new TreeNode(2), null);
    q = new TreeNode(1, null, new TreeNode(2));

    // should be false
    System.out.println(solution.isSameTree(p, q));
  }
}
