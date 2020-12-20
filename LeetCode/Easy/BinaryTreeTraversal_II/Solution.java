package LeetCode.Easy.BinaryTreeTraversal_II;

/*
  107. Binary Tree Level Order Traversal II

  Given a binary tree, return the bottom-up level order traversal of its nodes'   values. (ie, from left to right, level by level from leaf to root).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
  return its bottom-up level order traversal as:
  [
    [15,7],
    [9,20],
    [3]
  ]
*/

import java.util.ArrayList;
import java.util.Collections;
// import java.util.LinkedList;
import java.util.List;
// import java.util.Queue;

// Definition for a binary tree node.
// Not needed in actual code.
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
   * * Recursive Approach
   */
  private static void traverse(TreeNode root, List<List<Integer>> lists, int level) {
    if (root == null) return;

    if (lists.size() <= level) lists.add(new ArrayList<>());

    lists.get(level).add(root.val);
    traverse(root.left, lists, level + 1);
    traverse(root.right, lists, level + 1);
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<List<Integer>> lists = new ArrayList<>();
    traverse(root, lists, 0);

    Collections.reverse(lists);
    return lists;
  }

  /**
   * * Iterative approach
   */
  // public List<List<Integer>> levelOrderBottom(TreeNode root) {
  //   if (root == null)
  //     return new ArrayList<>();

  //   Queue<TreeNode> queue = new LinkedList<>();
  //   List<List<Integer>> lists = new ArrayList<>();

  //   queue.add(root);
  //   lists.add(new ArrayList<>());

  //   int i = 0, currentLevel = 1, nextLevel = 0;

  //   while (!queue.isEmpty()) {
  //     TreeNode node = queue.poll();
  //     lists.get(i).add(node.val);
  //     --currentLevel;

  //     if (node.left != null) {
  //       queue.add(node.left);
  //       ++nextLevel;
  //     }

  //     if (node.right != null) {
  //       queue.add(node.right);
  //       ++nextLevel;
  //     }

  //     if (currentLevel == 0) {
  //       if (queue.isEmpty())
  //         break;

  //       ++i;
  //       lists.add(i, new ArrayList<>());
  //       currentLevel = nextLevel;
  //       nextLevel = 0;
  //     }
  //   }

  //   Collections.reverse(lists);
  //   return lists;
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode root =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    // should be [[15, 7], [9, 20], [3]]
    System.out.println(solution.levelOrderBottom(root).toString());

    root = null;

    // should be []
    System.out.println(solution.levelOrderBottom(root).toString());
  }
}
