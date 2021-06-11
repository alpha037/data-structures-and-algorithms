package AlgoExSolutions.VeryHard.CompareLeafTraversal;

// import java.util.*;

/**
 * * Compare Leaf Traversal
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

  /**
   * * LinkedList Approach
   *
   * * TC: O(m + n)
   * * SC: O(max(h1 + h2))
   */
  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    // Write your code here.
    BinaryTree tree1Head = createLinkedList(tree1, null, null)[0];
    BinaryTree tree2Head = createLinkedList(tree2, null, null)[0];

    while (tree1Head != null && tree2Head != null) {
      if (tree1Head.value != tree2Head.value) return false;

      tree1Head = tree1Head.right;
      tree2Head = tree2Head.right;
    }

    return tree1Head == null && tree2Head == null;
  }

  private BinaryTree[] createLinkedList(BinaryTree current, BinaryTree head, BinaryTree prev) {
    if (current == null) return new BinaryTree[] {head, prev};

    if (isLeafNode(current)) {
      if (prev == null) head = current;
      else prev.right = current;

      prev = current;
    }

    BinaryTree[] leftNodeHeadAndPrev = createLinkedList(current.left, head, prev);

    return createLinkedList(current.right, leftNodeHeadAndPrev[0], leftNodeHeadAndPrev[1]);
  }

  /**
   * * Bit Optimized Approach
   *
   * * TC: O(m + n)
   * * SC: O(h1 + h2)
   */
  // public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
  // 	Stack<BinaryTree> stack1 = new Stack<>();
  // 	stack1.push(tree1);
  // 	Stack<BinaryTree> stack2 = new Stack<>();
  // 	stack2.push(tree2);

  // 	while (!stack1.isEmpty() && !stack2.isEmpty()) {
  // 		BinaryTree leafNode1 = getNextLeafNode(stack1);
  // 		BinaryTree leafNode2 = getNextLeafNode(stack2);

  // 		if (!areSameNodes(leafNode1, leafNode2)) return false;
  // 	}

  //   return stack1.isEmpty() && stack2.isEmpty();
  // }

  // private BinaryTree getNextLeafNode(Stack<BinaryTree> stack) {
  // 	while (!stack.isEmpty()) {
  // 		BinaryTree node = stack.pop();

  // 		if (isLeafNode(node)) return node;

  // 		if (node.right != null) stack.push(node.right);
  // 		if (node.left != null) stack.push(node.left);
  // 	}

  // 	return null;
  // }

  private boolean isLeafNode(BinaryTree node) {
    return node != null && node.left == null && node.right == null;
  }

  // private boolean areSameNodes(BinaryTree node1, BinaryTree node2) {
  // 	return node1 != null && node2 != null && node1.value == node2.value;
  // }

  /**
   * * Brute Force
   *
   * * TC: O(m + n)
   * * SC: O(m + n)
   */
  // public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
  // 	List<BinaryTree> tree1LeafNodes = getLeafNodes(tree1);
  // 	List<BinaryTree> tree2LeafNodes = getLeafNodes(tree2);
  // 	int len = Math.min(tree1LeafNodes.size(), tree2LeafNodes.size());

  // 	for (int i = 0; i < len; i++)
  // 		if (tree1LeafNodes.get(i).value != tree2LeafNodes.get(i).value)
  // 			return false;

  //   return true;
  // }

  // private List<BinaryTree> getLeafNodes(BinaryTree root) {
  // 	List<BinaryTree> leafNodes = new ArrayList<>();
  // 	getLeafNodes(root, leafNodes);
  // 	return leafNodes;
  // }

  // private void getLeafNodes(BinaryTree node, List<BinaryTree> leafNodes) {
  // 	if (node == null) return;

  // 	if (node.left == null && node.right == null) leafNodes.add(node);

  // 	getLeafNodes(node.left, leafNodes);
  // 	getLeafNodes(node.right, leafNodes);
  // }
}
