package AlgoExSolutions.VeryHard.MergeSort;

// import java.util.*;

/**
 * * Merge Sort
 */
class Program {
  /**
   * * TC: O(n log(n)) [Best, Average and Worst]
   * * SC: O(n) [Best, Average and Worst]
   */
  public static int[] mergeSort(int[] array) {
    // Write your code here.
    if (array.length <= 1) return array;

    mergeSort(array, 0, array.length - 1, array.clone());
    return array;
  }

  private static void mergeSort(int[] mainArray, int low, int high, int[] auxArray) {
    if (low < high) {
      int mid = low + (high - low) / 2;

      mergeSort(auxArray, low, mid, mainArray);
      mergeSort(auxArray, mid + 1, high, mainArray);
      merge(mainArray, low, mid, high, auxArray);
    }
  }

  private static void merge(int[] mainArray, int low, int mid, int high, int[] auxArray) {
    int i = low, j = mid + 1, k = low;

    while (i <= mid && j <= high) {
      if (auxArray[i] <= auxArray[j]) mainArray[k++] = auxArray[i++];
      else mainArray[k++] = auxArray[j++];
    }

    while (i <= mid) mainArray[k++] = auxArray[i++];

    while (j <= high) mainArray[k++] = auxArray[j++];
  }

  /**
   * * TC: O(n log(n)) [Best, Average and Worst]
   * * SC: O(n log(n)) [Best, Average and Worst]
   */
  // public static int[] mergeSort(int[] array) {
  // 	if (array.length <= 1) return array;

  // 	mergeSort(array, 0, array.length - 1);
  //   return array;
  // }

  // private static void mergeSort(int[] array, int low, int high) {
  // 	if (low < high) {
  // 		int mid = low + (high - low) / 2;

  // 		mergeSort(array, low, mid);
  // 		mergeSort(array, mid + 1, high);
  // 		merge(array, low, mid, high);
  // 	}
  // }

  // private static void merge(int[] array, int low, int mid, int high) {
  // 	int lowerBound = mid - low + 1, upperBound = high - mid;
  // 	int[] lowerBoundArray = new int[lowerBound];
  // 	int[] upperBoundArray = new int[upperBound];

  // 	for (int i = 0; i < lowerBound; i++) lowerBoundArray[i] = array[low + i];

  // 	for (int j = 0; j < upperBound; j++) upperBoundArray[j] = array[mid + 1 + j];

  // 	int i = 0, j = 0, k = low;

  // 	while (i < lowerBound && j < upperBound) {
  // 		if (lowerBoundArray[i] <= upperBoundArray[j])
  // 			array[k++] = lowerBoundArray[i++];
  // 		else  array[k++] = upperBoundArray[j++];
  // 	}

  // 	while (i < lowerBound) array[k++] = lowerBoundArray[i++];

  // 	while (j < upperBound) array[k++] = upperBoundArray[j++];
  // }
}
