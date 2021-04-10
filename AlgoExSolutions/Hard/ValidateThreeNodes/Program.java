package AlgoExSolutions.Hard.ValidateThreeNodes;

// import java.util.*;

/**
 * * Validate Three Nodes
 */
class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  /**
   * * TC: O(d), d - distance between nodeOne and nodeThree
   * * SC: O(1)
   */
  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
    // Write your code here.
    BST searchOne = nodeOne, searchTwo = nodeThree;

    while (true) {
      boolean foundThreeFromOne = searchOne == nodeThree;
      boolean foundOneFromThree = searchTwo == nodeOne;
      boolean foundNodeTwo = searchOne == nodeTwo || searchTwo == nodeTwo;
      boolean hasFinishedSearching = searchOne == null && searchTwo == null;

      if (foundThreeFromOne || foundOneFromThree || foundNodeTwo || hasFinishedSearching) break;

      if (searchOne != null)
        searchOne = searchOne.value < nodeTwo.value ? searchOne.right : searchOne.left;

      if (searchTwo != null)
        searchTwo = searchTwo.value < nodeTwo.value ? searchTwo.right : searchTwo.left;
    }

    boolean foundOneFromOther = searchOne == nodeThree || searchTwo == nodeOne;
    boolean foundNodeTwo = searchOne == nodeTwo || searchTwo == nodeTwo;

    if (foundOneFromOther || !foundNodeTwo) return false;

    return searchForTarget(nodeTwo, (searchOne == nodeTwo) ? nodeThree : nodeOne);
  }

  private boolean searchForTarget(BST node, BST target) {
    while (node != null) {
      if (node == target) return true;

      node = node.value < target.value ? node.right : node.left;
    }

    return false;
  }

  // public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
  // 	if (isDescendant(nodeOne, nodeTwo)) return isDescendant(nodeTwo, nodeThree);

  // 	return isDescendant(nodeThree, nodeTwo) && isDescendant(nodeTwo, nodeOne);
  // }

  /**
   * * TC: O(h)
   * * SC: O(1)
   */
  // private boolean isDescendant(BST node, BST target) {
  // 	while (node != null) {
  // 		if (node == target) return true;

  // 		node = node.value < target.value ? node.right : node.left;
  // 	}

  // 	return false;
  // }

  /**
   * * TC: O(h)
   * * SC: O(h)
   */
  // 	private boolean isDescendantRec(BST node, BST target) {
  // 		if (node == null) return false;

  // 		if (node == target) return true;

  // 		return node.value < target.value ?
  // 			isDescendantRec(node.right, target)
  // 			: isDescendantRec(node.left, target);
  // 	}
}
