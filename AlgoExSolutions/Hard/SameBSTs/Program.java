package AlgoExSolutions.Hard.SameBSTs;

import java.util.*;

/**
 * * Same BSTs
 */
class Program {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
    return sameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * * TC: O(n^2)
   * * SC: O(d)
   */
  private static boolean sameBsts(
      List<Integer> arrayOne,
      List<Integer> arrayTwo,
      int rootIdxOne,
      int rootIdxTwo,
      int minValue,
      int maxValue) {
    if (rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;

    if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) return false;

    int leftRootIdxOne = getFirstSmallerIdx(arrayOne, rootIdxOne, minValue);
    int leftRootIdxTwo = getFirstSmallerIdx(arrayTwo, rootIdxTwo, minValue);
    int rightRootIdxOne = getFirstBiggerOrEqualIdx(arrayOne, rootIdxOne, maxValue);
    int rightRootIdxTwo = getFirstBiggerOrEqualIdx(arrayTwo, rootIdxTwo, maxValue);

    int currentValue = arrayOne.get(rootIdxOne);
    boolean leftAreSame =
        sameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, currentValue);
    boolean rightAreSame =
        sameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxValue);

    return leftAreSame && rightAreSame;
  }

  private static int getFirstSmallerIdx(List<Integer> array, int startIdx, int minValue) {
    for (int i = startIdx + 1; i < array.size(); i++)
      if (array.get(i) < array.get(startIdx) && array.get(i) >= minValue) return i;

    return -1;
  }

  private static int getFirstBiggerOrEqualIdx(List<Integer> array, int startIdx, int maxValue) {
    for (int i = startIdx + 1; i < array.size(); i++)
      if (array.get(i) >= array.get(startIdx) && array.get(i) < maxValue) return i;

    return -1;
  }

  /**
   * * TC: O(n^2)
   * * SC: O(n^2)
   */
  // public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
  // 	if (arrayOne.size() !=  arrayTwo.size()) return false;

  // 	if (arrayOne.size() == 0 && arrayTwo.size() == 0) return true;

  // 	if (arrayOne.get(0) != arrayTwo.get(0)) return false;

  // 	List<Integer> lstOne = getSmallerLST(arrayOne);
  // 	List<Integer> lstTwo = getSmallerLST(arrayTwo);
  // 	List<Integer> rstOne = getBiggerOrEqualRST(arrayOne);
  // 	List<Integer> rstTwo = getBiggerOrEqualRST(arrayTwo);

  //   return sameBsts(lstOne, lstTwo) && sameBsts(rstOne, rstTwo);
  // }

  // private static List<Integer> getSmallerLST(List<Integer> array) {
  // 	int root = array.get(0);
  // 	List<Integer> leftSubTree = new ArrayList<>();

  // 	for (int i = 1; i < array.size(); i++)
  // 		if (root > array.get(i)) leftSubTree.add(array.get(i));

  // 	return leftSubTree;
  // }

  // private static List<Integer> getBiggerOrEqualRST(List<Integer> array) {
  // 	int root = array.get(0);
  // 	List<Integer> rightSubTree = new ArrayList<>();

  // 	for (int i = 1; i < array.size(); i++)
  // 		if (root <= array.get(i)) rightSubTree.add(array.get(i));

  // 	return rightSubTree;
  // }
}
