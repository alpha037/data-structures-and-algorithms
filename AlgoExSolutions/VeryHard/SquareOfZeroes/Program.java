package AlgoExSolutions.VeryHard.SquareOfZeroes;

import java.util.*;

/**
 * * Square Of Zeroes
 */
class Program {
  /**
   * * [Iterative] Optimized
   *
   * * TC: O(n^3)
   * * SC: O(n^2)
   */
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    int len = matrix.size();
    List<List<InfoMatrixItem>> infoMatrix = preComputeNumOfZeroes(matrix);
    for (int topRow = 0; topRow < len; topRow++) {
      for (int leftCol = 0; leftCol < len; leftCol++) {
        int squareLength = 2;

        while (squareLength <= len - topRow && squareLength <= len - leftCol) {
          int bottomRow = topRow + squareLength - 1;
          int rightCol = leftCol + squareLength - 1;

          if (isSquareOfZeroes(infoMatrix, topRow, leftCol, bottomRow, rightCol)) return true;

          ++squareLength;
        }
      }
    }

    return false;
  }

  private static List<List<InfoMatrixItem>> preComputeNumOfZeroes(List<List<Integer>> matrix) {
    List<List<InfoMatrixItem>> infoMatrix = new ArrayList<>();
    int len = matrix.size();

    for (int row = 0; row < len; row++) {
      infoMatrix.add(row, new ArrayList<>());
      for (int col = 0; col < len; col++) {
        int numZeroes = matrix.get(row).get(col) == 0 ? 1 : 0;
        infoMatrix.get(row).add(new InfoMatrixItem(numZeroes, numZeroes));
      }
    }

    for (int row = len - 1; row >= 0; --row) {
      for (int col = len - 1; col >= 0; --col) {
        if (matrix.get(row).get(col) == 1) continue;
        else {
          if (row < len - 1)
            infoMatrix.get(row).get(col).numZeroesBelow +=
                infoMatrix.get(row + 1).get(col).numZeroesBelow;

          if (col < len - 1)
            infoMatrix.get(row).get(col).numZeroesRight +=
                infoMatrix.get(row).get(col + 1).numZeroesRight;
        }
      }
    }

    return infoMatrix;
  }

  private static boolean isSquareOfZeroes(
      List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2) {
    int squareLength = c2 - c1 + 1;
    boolean hasTopBorder = infoMatrix.get(r1).get(c1).numZeroesRight >= squareLength;
    boolean hasLeftBorder = infoMatrix.get(r1).get(c1).numZeroesBelow >= squareLength;
    boolean hasBottomBorder = infoMatrix.get(r2).get(c1).numZeroesRight >= squareLength;
    boolean hasRightBorder = infoMatrix.get(r1).get(c2).numZeroesBelow >= squareLength;

    return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
  }

  static class InfoMatrixItem {
    int numZeroesBelow;
    int numZeroesRight;

    public InfoMatrixItem(int numZeroesBelow, int numZeroesRight) {
      this.numZeroesBelow = numZeroesBelow;
      this.numZeroesRight = numZeroesRight;
    }
  }

  /**
   * * [Recursive] Optimized
   *
   * * TC: O(n^3)
   * * SC: O(n^3)
   */
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // 	int len = matrix.size() - 1;
  // 	List<List<InfoMatrixItem>> infoMatrix = preComputeNumOfZeroes(matrix);

  // 	return hasSquaresOfZeroes(
  // 		infoMatrix, 0, 0, len, len, new HashMap<>()
  // 	);
  // }

  // private static List<List<InfoMatrixItem>> preComputeNumOfZeroes(
  // 	List<List<Integer>> matrix
  // ) {
  // 	List<List<InfoMatrixItem>> infoMatrix = new ArrayList<>();
  // 	int len = matrix.size();

  // 	for (int row = 0; row < len; row++) {
  // 		infoMatrix.add(row, new ArrayList<>());
  // 		for (int col = 0; col < len; col++) {
  // 			int numZeroes = matrix.get(row).get(col) == 0 ? 1 : 0;
  // 			infoMatrix.get(row).add(new InfoMatrixItem(numZeroes, numZeroes));
  // 		}
  // 	}

  // 	for (int row = len - 1; row >= 0; --row) {
  // 		for (int col = len - 1; col >= 0; --col) {
  // 			if (matrix.get(row).get(col) == 1) continue;
  // 			else {
  // 				if (row < len - 1)
  // 					infoMatrix.get(row).get(col).numZeroesBelow +=
  // 						infoMatrix.get(row + 1).get(col).numZeroesBelow;

  // 				if (col < len - 1)
  // 					infoMatrix.get(row).get(col).numZeroesRight +=
  // 						infoMatrix.get(row).get(col + 1).numZeroesRight;
  // 			}
  // 		}
  // 	}

  // 	return infoMatrix;
  // }

  // private static boolean hasSquaresOfZeroes(
  // 	List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2,
  // 	Map<String, Boolean> cache
  // ) {
  // 	if (r1 >= r2 || c1 >= c2) return false;

  // 	String key = getKey(r1, c1, r2, c2);
  // 	if (cache.containsKey(key)) return cache.get(key);

  // 	cache.put(
  // 		key,
  // 		isSquareOfZeroes(infoMatrix, r1, c1, r2, c2)
  // 		|| hasSquaresOfZeroes(infoMatrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
  // 		|| hasSquaresOfZeroes(infoMatrix, r1 + 1, c1, r2, c2 - 1, cache)
  // 		|| hasSquaresOfZeroes(infoMatrix, r1, c1 + 1, r2 - 1, c2, cache)
  // 		|| hasSquaresOfZeroes(infoMatrix, r1 + 1, c1 + 1, r2, c2, cache)
  // 		|| hasSquaresOfZeroes(infoMatrix, r1, c1, r2 - 1, c2 - 1, cache)
  // 	);

  // 	return cache.get(key);
  // }

  // private static String getKey(int r1, int c1, int r2, int c2) {
  // 	return r1 + ":" + c1 + ":" + r2 + ":" + c2;
  // }

  // private static boolean isSquareOfZeroes(
  // 	List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2
  // ) {
  // 	int squareLength = c2 - c1 + 1;
  // 	boolean hasTopBorder =
  // 		infoMatrix.get(r1).get(c1).numZeroesRight >= squareLength;
  // 	boolean hasLeftBorder =
  // 		infoMatrix.get(r1).get(c1).numZeroesBelow >= squareLength;
  // 	boolean hasBottomBorder =
  // 		infoMatrix.get(r2).get(c1).numZeroesRight >= squareLength;
  // 	boolean hasRightBorder =
  // 		infoMatrix.get(r1).get(c2).numZeroesBelow >= squareLength;

  // 	return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
  // }

  // static class InfoMatrixItem {
  // 	int numZeroesBelow;
  // 	int numZeroesRight;

  // 	public InfoMatrixItem(int numZeroesBelow, int numZeroesRight) {
  // 		this.numZeroesBelow = numZeroesBelow;
  // 		this.numZeroesRight = numZeroesRight;
  // 	}
  // }

  /**
   * * [Iterative] Brute Force
   *
   * * TC: O(n^4)
   * * SC: O(n^3)
   */
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // 	int len = matrix.size();
  // 	for (int topRow = 0; topRow < len; topRow++) {
  // 		for (int leftCol = 0; leftCol < len; leftCol++) {
  // 			int squareLength = 2;

  // 			while (
  // 				squareLength <= len - topRow && squareLength <= len - leftCol
  // 			) {
  // 				int bottomRow = topRow + squareLength - 1;
  // 				int rightCol = leftCol + squareLength - 1;

  // 				if (isSquareOfZeroes(matrix, topRow, leftCol, bottomRow, rightCol))
  // 					return true;

  // 				++squareLength;
  // 			}
  // 		}
  // 	}

  // 	return false;
  // }

  // private static boolean isSquareOfZeroes(
  // 	List<List<Integer>> matrix, int r1, int c1, int r2, int c2
  // ) {
  // 	for (int row = r1; row < r2 + 1; row++)
  // 		if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0)
  // 			return false;

  // 	for (int col = c1; col < c2 + 1; col++)
  // 		if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0)
  // 			return false;

  // 	return true;
  // }

  /**
   * * [Recursive] Brute Force
   *
   * * TC: O(n^4)
   * * SC: O(n^2)
   */
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // 	int len = matrix.size() - 1;
  //   return hasSquaresOfZeroes(
  // 		matrix, 0, 0, len, len, new HashMap<>()
  // 	);
  // }

  // private static boolean hasSquaresOfZeroes(
  // 	List<List<Integer>> matrix, int r1, int c1, int r2, int c2,
  // 	Map<String, Boolean> cache
  // ) {
  // 	if (r1 >= r2 || c1 >= c2) return false;

  // 	String key = getKey(r1, c1, r2, c2);
  // 	if (cache.containsKey(key)) return cache.get(key);

  // 	cache.put(
  // 		key,
  // 		isSquareOfZeroes(matrix, r1, c1, r2, c2)
  // 		|| hasSquaresOfZeroes(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
  // 		|| hasSquaresOfZeroes(matrix, r1 + 1, c1, r2, c2 - 1, cache)
  // 		|| hasSquaresOfZeroes(matrix, r1, c1 + 1, r2 - 1, c2, cache)
  // 		|| hasSquaresOfZeroes(matrix, r1 + 1, c1 + 1, r2, c2, cache)
  // 		|| hasSquaresOfZeroes(matrix, r1, c1, r2 - 1, c2 - 1, cache)
  // 	);

  // 	return cache.get(key);
  // }

  // private static String getKey(int r1, int c1, int r2, int c2) {
  // 	return r1 + ":" + c1 + ":" + r2 + ":" + c2;
  // }

  // private static boolean isSquareOfZeroes(
  // 	List<List<Integer>> matrix, int r1, int c1, int r2, int c2
  // ) {
  // 	for (int row = r1; row < r2 + 1; row++)
  // 		if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0)
  // 			return false;

  // 	for (int col = c1; col < c2 + 1; col++)
  // 		if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0)
  // 			return false;

  // 	return true;
  // }
}
