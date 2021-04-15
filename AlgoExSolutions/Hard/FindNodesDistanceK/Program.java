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

  public ArrayList<Integer> findNodesDistanceK(
		BinaryTree tree, int target, int k
	) {
    // Write your code here.
		return findNodesDistanceKHelper(tree, target, k);
  }

  
  /**
   * * BFS Approach
   * 
   * * TC: O(v + e) < O(2n), since e < v ~ O(n)
   * * SC: O(n)
   */
	private ArrayList<Integer> findNodesDistanceKHelper(
		BinaryTree root, int target, int k
	) {
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
				for (Pair<BinaryTree, Integer> p : queue)
					nodesDistanceK.add(p.first.value);
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
		BinaryTree root, BinaryTree parent, Map<Integer, BinaryTree> parents
	) {
		if (root == null) return;
		
		parents.put(root.value, parent);

		populateParents(root.left, root, parents);
		populateParents(root.right, root, parents);
	}
	
	private BinaryTree getTargetNode(
		BinaryTree root, int target, Map<Integer, BinaryTree> parents
	) {
		if (root.value == target) return root;
		
		BinaryTree parent = parents.get(target);
		
		return parent.left != null && parent.left.value == target ?
			parent.left : parent.right;
	}
}
