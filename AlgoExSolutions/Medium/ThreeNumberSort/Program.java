package AlgoExSolutions.Medium.ThreeNumberSort;

// import java.util.*;

/**
 * * Three Number Sort
 */
class Program {
  private void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
    // 		int firstValCount = 0, secondValCount = 0, thirdValCount = 0;
    // 		int idx = 0;

    // 		for (int val : array) {
    // 			if (val == order[0]) ++firstValCount;
    // 			if (val == order[1]) ++secondValCount;
    // 			if (val == order[2]) ++thirdValCount;
    // 		}

    // 		for (int i = 0; i < firstValCount; ++i)
    // 			array[idx++] = order[0];

    // 		for (int i = 0; i < secondValCount; ++i)
    // 			array[idx++] = order[1];

    // 		for (int i = 0; i < thirdValCount; ++i)
    // 			array[idx++] = order[2];

    // 		int firstIdx = 0, lastIdx = array.length - 1;

    // 		for (int idx = 0; idx < array.length; idx++) {
    // 			if (array[idx] == order[0]) {
    // 				swap(array, firstIdx, idx);
    // 				++firstIdx;
    // 			}
    // 		}

    // 		for (int idx = array.length - 1; idx >= 0; idx--) {
    // 			if (array[idx] == order[2]) {
    // 				swap(array, lastIdx, idx);
    // 				--lastIdx;
    // 			}
    // 		}

    int firstIdx = 0, secondIdx = 0, thirdIdx = array.length - 1;

    while (secondIdx <= thirdIdx) {
      if (array[secondIdx] == order[0]) {
        swap(array, firstIdx, secondIdx);
        ++firstIdx;
        ++secondIdx;
      } else if (array[secondIdx] == order[1]) ++secondIdx;
      else {
        swap(array, secondIdx, thirdIdx);
        --thirdIdx;
      }
    }

    return array;
  }
}
