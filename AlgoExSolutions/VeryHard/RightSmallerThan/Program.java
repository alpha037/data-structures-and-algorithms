package AlgoExSolutions.VeryHard.RightSmallerThan;

import java.util.*;

/**
 * * Right Smaller Than
 */
class Program {
  /**
   * * Balanced BST Approach (Optimized)
   *
   * * TC: O(n log(n))
   * * SC: O(n)
   */
  public static List<Integer> rightSmallerThan(List<Integer> array) {
    // Write your code here.
    if (array == null || array.size() == 0) return new ArrayList<>();

    int len = array.size();
    CustomBST root = new CustomBST(array.get(len - 1));
    List<Integer> rightSmallerCounts = new ArrayList<>(array);
    rightSmallerCounts.set(len - 1, 0);

    for (int i = len - 2; i >= 0; i--) root.insert(i, array.get(i), rightSmallerCounts, 0);

    return rightSmallerCounts;
  }

  static class CustomBST {
    int value;
    int leftSubtreeSize = 0;
    CustomBST left = null, right = null;

    public CustomBST(int value) {
      this.value = value;
    }

    public void insert(
        int index, int value, List<Integer> rightSmallerCounts, int numberOfSmallerNodes) {
      if (value < this.value) {
        this.leftSubtreeSize++;

        if (this.left == null) {
          this.left = new CustomBST(value);
          rightSmallerCounts.set(index, numberOfSmallerNodes);
        } else this.left.insert(index, value, rightSmallerCounts, numberOfSmallerNodes);
      } else {
        numberOfSmallerNodes += this.leftSubtreeSize;
        if (value > this.value) numberOfSmallerNodes++;

        if (this.right == null) {
          this.right = new CustomBST(value);
          rightSmallerCounts.set(index, numberOfSmallerNodes);
        } else this.right.insert(index, value, rightSmallerCounts, numberOfSmallerNodes);
      }
    }
  }

  /**
   * * Balanced BST Approach
   *
   * * TC: O(n log(n))
   * * SC: O(n)
   */
  // public static List<Integer> rightSmallerThan(List<Integer> array) {
  // 	if (array == null || array.size() == 0) return new ArrayList<>();

  // 	int len = array.size();
  // 	CustomBST root = new CustomBST(len - 1, array.get(len - 1), 0);

  //   for (int i = len - 2; i >= 0; i--)
  // 		root.insert(i, array.get(i), 0);

  // 	List<Integer> rightSmallerCounts = new ArrayList<>(array);
  // 	getRightSmallerCounts(root, rightSmallerCounts);

  // 	return rightSmallerCounts;
  // }

  // private static void getRightSmallerCounts(
  // 	CustomBST root, List<Integer> rightSmallerCounts
  // ) {
  // 	if (root == null) return;

  // 	rightSmallerCounts.set(root.index, root.numberOfSmallerNodes);
  // 	getRightSmallerCounts(root.left, rightSmallerCounts);
  // 	getRightSmallerCounts(root.right, rightSmallerCounts);
  // }

  // static class CustomBST {
  // 	int index;
  // 	int value;
  // 	int numberOfSmallerNodes;
  // 	int leftSubtreeSize = 0;
  // 	CustomBST left = null, right = null;

  // 	public CustomBST(int index, int value, int numberOfSmallerNodes) {
  // 		this.index = index;
  // 		this.value = value;
  // 		this.numberOfSmallerNodes = numberOfSmallerNodes;
  // 	}

  // 	public void insert(int index, int value, int numberOfSmallerNodes) {
  // 		if (value < this.value) {
  // 			this.leftSubtreeSize++;

  // 			if (this.left == null)
  // 				this.left = new CustomBST(index, value, numberOfSmallerNodes);

  // 			else this.left.insert(index, value, numberOfSmallerNodes);
  // 		}
  // 		else {
  // 			numberOfSmallerNodes += this.leftSubtreeSize;
  // 			if (value > this.value) numberOfSmallerNodes++;

  // 			if (this.right == null)
  // 				this.right = new CustomBST(index, value, numberOfSmallerNodes);

  // 			else this.right.insert(index, value, numberOfSmallerNodes);
  // 		}
  // 	}
  // }

  /**
   * * Brute Force Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // public static List<Integer> rightSmallerThan(List<Integer> array) {
  // 	List<Integer> rightSmallerCounts = new ArrayList<>();

  // 	for (int i = 0; i < array.size(); i++) {
  // 		int rightSmallerCount = 0;
  // 		for (int j = i + 1; j < array.size(); j++) {
  // 			if (array.get(i) > array.get(j))
  // 				++rightSmallerCount;
  // 		}
  // 		rightSmallerCounts.add(rightSmallerCount);
  // 	}

  //   return rightSmallerCounts;
  // }
}
