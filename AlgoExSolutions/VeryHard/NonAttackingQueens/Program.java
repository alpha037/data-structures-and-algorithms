package AlgoExSolutions.VeryHard.NonAttackingQueens;

import java.util.*;

/**
 * * Non Attacking Queens
 */
class Program {
  /**
   * * TC: O(n!)
   * * SC: O(n)
   */
  public int nonAttackingQueens(int n) {
    // Write your code here.
    return getNonAttackingQueensPlacements(0, new HashMap<>(), new HashMap<>(), new HashMap<>(), n);
  }

  private int getNonAttackingQueensPlacements(
      int row,
      Map<Integer, Boolean> visitedColumns,
      Map<Integer, Boolean> visitedUpDiagonals,
      Map<Integer, Boolean> visitedDownDiagonals,
      int n) {
    if (row == n) return 1;

    int totalPlacements = 0;
    for (int col = 0; col < n; col++) {
      if (isNotSafeToPlaceQueen(row, col, visitedColumns, visitedUpDiagonals, visitedDownDiagonals))
        continue;
      placeQueen(row, col, visitedColumns, visitedUpDiagonals, visitedDownDiagonals);
      totalPlacements +=
          getNonAttackingQueensPlacements(
              row + 1, visitedColumns, visitedUpDiagonals, visitedDownDiagonals, n);
      removeQueen(row, col, visitedColumns, visitedUpDiagonals, visitedDownDiagonals);
    }

    return totalPlacements;
  }

  private boolean isNotSafeToPlaceQueen(
      int row,
      int col,
      Map<Integer, Boolean> visitedColumns,
      Map<Integer, Boolean> visitedUpDiagonals,
      Map<Integer, Boolean> visitedDownDiagonals) {
    return visitedColumns.containsKey(col)
        || visitedUpDiagonals.containsKey(row + col)
        || visitedDownDiagonals.containsKey(row - col);
  }

  private void placeQueen(
      int row,
      int col,
      Map<Integer, Boolean> visitedColumns,
      Map<Integer, Boolean> visitedUpDiagonals,
      Map<Integer, Boolean> visitedDownDiagonals) {
    visitedColumns.put(col, true);
    visitedUpDiagonals.put(row + col, true);
    visitedDownDiagonals.put(row - col, true);
  }

  private void removeQueen(
      int row,
      int col,
      Map<Integer, Boolean> visitedColumns,
      Map<Integer, Boolean> visitedUpDiagonals,
      Map<Integer, Boolean> visitedDownDiagonals) {
    visitedColumns.remove(col);
    visitedUpDiagonals.remove(row + col);
    visitedDownDiagonals.remove(row - col);
  }

  /**
   * * TC: Ω(n!)
   * * SC: O(n)
   */
  // public int nonAttackingQueens(int n) {
  // 	int[] colPlacements = new int[n];
  //   return getNonAttackingQueensPlacements(0, colPlacements, n);
  // }

  // private int getNonAttackingQueensPlacements(
  // 	int row, int[] colPlacements, int n
  // ) {
  // 	if (row == n) return 1;

  // 	int totalPlacements = 0;

  // 	for (int col = 0; col < n; col++) {
  // 		if (isNotSafeToPlaceQueen(row, col, colPlacements)) continue;

  // 		colPlacements[row] = col;
  // 		totalPlacements +=
  // 			getNonAttackingQueensPlacements(row + 1, colPlacements, n);
  // 	}

  // 	return totalPlacements;
  // }

  // private boolean isNotSafeToPlaceQueen(int row, int col, int[] colPlacements) {
  // 	for (int i = 0; i < row; i++) {
  // 		int currentColumn = colPlacements[i];
  // 		boolean isSameColumn = currentColumn == col;
  // 		boolean isSameDiagonal = Math.abs(currentColumn - col) == row - i;
  // 		if (isSameColumn || isSameDiagonal) return true;
  // 	}

  // 	return false;
  // }
}
