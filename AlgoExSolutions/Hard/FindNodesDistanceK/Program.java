package AlgoExSolutions.Hard.FindNodesDistanceK;

import java.util.*;

/**
 * * Find Nodes Distance K
 */
class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class Pair<U, V> {
    final U first;
    final V second;

    public Pair(U first, V second) {
      this.first = first;
      this.second = second;
    }
  }

  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    // Write your code here.
    // ? For BFS Approach
    return findNodesDistanceKHelper(tree, target, k);

    // ? For DFS Approach
    // ArrayList<Integer> nodesDistanceK = new ArrayList<>();
    // findNodesDistanceK(tree, target, k, nodesDistanceK);
    // return nodesDistanceK;
  }

  /**
   * * BFS Approach
   *
   * * TC: O(v + e) < O(2n), since e < v ~ O(n)
   * * SC: O(n)
   */
  private ArrayList<Integer> findNodesDistanceKHelper(BinaryTree root, int target, int k) {
    Map<Integer, BinaryTree> parents = new HashMap<>();
    populateParents(root, null, parents);

    Map<Integer, Boolean> visited = new HashMap<>();

    BinaryTree targetNode = getTargetNode(root, target, parents);
    Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
    queue.add(new Pair<BinaryTree, Integer>(targetNode, 0));
    visited.put(targetNode.value, true);

    while (!queue.isEmpty()) {
      Pair<BinaryTree, Integer> pair = queue.poll();
      BinaryTree currentNode = pair.first;
      int distance = pair.second;

      if (distance == k) {
        ArrayList<Integer> nodesDistanceK = new ArrayList<>();
        nodesDistanceK.add(currentNode.value);
        for (Pair<BinaryTree, Integer> p : queue) nodesDistanceK.add(p.first.value);
        return nodesDistanceK;
      }

      List<BinaryTree> neighbors = new ArrayList<>();
      neighbors.add(currentNode.left);
      neighbors.add(currentNode.right);
      neighbors.add(parents.get(currentNode.value));

      for (BinaryTree node : neighbors) {
        if (node == null) continue;

        if (visited.containsKey(node.value)) continue;

        visited.put(node.value, true);
        queue.add(new Pair<BinaryTree, Integer>(node, distance + 1));
      }
    }

    return new ArrayList<>();
  }

  private void populateParents(
      BinaryTree root, BinaryTree parent, Map<Integer, BinaryTree> parents) {
    if (root == null) return;

    parents.put(root.value, parent);

    populateParents(root.left, root, parents);
    populateParents(root.right, root, parents);
  }

  private BinaryTree getTargetNode(BinaryTree root, int target, Map<Integer, BinaryTree> parents) {
    if (root.value == target) return root;

    BinaryTree parent = parents.get(target);

    return parent.left != null && parent.left.value == target ? parent.left : parent.right;
  }

  /**
   * * DFS Approach
   *
   * * TC: O(2n) ~ O(n)
   * * SC: O(n)
   */
  // private int findNodesDistanceK(
  // 	BinaryTree root, int target, int k, List<Integer> nodesDistanceK
  // ) {
  // 	if (root == null) return -1;

  // 	if (root.value == target) {
  // 		addNodesAtDistanceK(root, 0, k, nodesDistanceK);
  // 		return 1;
  // 	}

  // 	int leftDistance = findNodesDistanceK(root.left, target, k, nodesDistanceK);
  // 	int rightDistance = findNodesDistanceK(root.right, target, k, nodesDistanceK);

  // 	if (leftDistance == k || rightDistance == k) nodesDistanceK.add(root.value);

  // 	if (leftDistance != -1) {
  // 		addNodesAtDistanceK(root.right, leftDistance + 1, k, nodesDistanceK);
  // 		return leftDistance + 1;
  // 	}

  // 	if (rightDistance != -1) {
  // 		addNodesAtDistanceK(root.left, rightDistance + 1, k, nodesDistanceK);
  // 		return rightDistance + 1;
  // 	}

  // 	return -1;
  // }

  // private void addNodesAtDistanceK(
  // 	BinaryTree node, int distance, int k, List<Integer> nodesDistanceK
  // ) {
  // 	if (node == null) return;

  // 	if (distance == k) nodesDistanceK.add(node.value);

  // 	addNodesAtDistanceK(node.left, distance + 1, k, nodesDistanceK);
  // 	addNodesAtDistanceK(node.right, distance + 1, k, nodesDistanceK);
  // }
}
