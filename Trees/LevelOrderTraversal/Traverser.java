package Trees.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

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

public class Traverser {

  public static void levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    // Counters for printing a "\n" after the current level
    int currentLevel = 1, nextLevel = 0;

    while (!queue.isEmpty()) {

      TreeNode tempNode = queue.poll();
      currentLevel--;

      System.out.print(tempNode.value + " ");

      if (tempNode.left != null) {
        queue.add(tempNode.left);
        nextLevel++;
      }

      if (tempNode.right != null) {
        queue.add(tempNode.right);
        nextLevel++;
      }

      // If currentLevel is 0, that means the next
      // level will start
      if (currentLevel == 0) {
        System.out.println();
        currentLevel = nextLevel;
        nextLevel = 0;
      }
    }
  }
}
