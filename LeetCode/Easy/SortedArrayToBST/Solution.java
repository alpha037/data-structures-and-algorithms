package LeetCode.Easy.SortedArrayToBST;

/*
  108. Convert Sorted Array to Binary Search Tree

  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

  Example:

  Given the sorted array: [-10,-3,0,5,9],

  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

       0
      / \
    -3   9
    /   /
  -10  5
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
  private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (start > end) return null;

    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = sortedArrayToBST(nums, start, mid - 1);
    root.right = sortedArrayToBST(nums, mid + 1, end);

    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.val + " ");
      inOrder(root.right);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root = solution.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});

    solution.inOrder(root);
  }
}
