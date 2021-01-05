package LeetCode.Easy.LowestCommonAncestorofABST;

/*
  235. Lowest Common Ancestor of a Binary Search Tree

  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

  According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)."


  Example 1:
  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
  Output: 6
  Explanation: The LCA of nodes 2 and 8 is 6.

  Example 2:
  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
  Output: 2
  Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

  Example 3:
  Input: root = [2,1], p = 2, q = 1
  Output: 2


  Constraints:
  The number of nodes in the tree is in the range [2, 105].
  -109 <= Node.val <= 109
  All Node.val are unique.
  p != q
  p and q will exist in the BST.
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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    /**
     * * Simple approach
     */
    // if (root.val == p.val || root.val == q.val)
    //   return root;

    // TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
    // TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

    // if (leftAncestor == null)
    //   return rightAncestor;

    // if (rightAncestor== null)
    //   return leftAncestor;

    // return root;

    /**
     * * Binary Search Approach
     */
    if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    else return root;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
    root.right = new TreeNode(8, new TreeNode(7), new TreeNode(9));

    System.out.println(solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
  }
}
