package AlgoExSolutions.Hard.DiskStacking;

import java.util.*;

/**
 * * Disk Stacking
 */
class Program {
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    // Write your code here.
    disks.sort((disk1, disk2) -> disk1[2] - disk2[2]);
    return longestIncreasingSubsequence(disks);
  }

  private static List<Integer[]> longestIncreasingSubsequence(List<Integer[]> disks) {
    int len = disks.size(), maxHeight = 0, end = 0;
    int[] dpHeights = new int[len];

    for (int i = 0; i < len; i++) dpHeights[i] = disks.get(i)[2];

    for (int i = 1; i < len; i++) {
      Integer[] currentDisk = disks.get(i);
      for (int j = 0; j < i; j++) {
        Integer[] otherDisk = disks.get(j);
        if (areValidDimensions(currentDisk, otherDisk)
            && dpHeights[i] <= dpHeights[j] + currentDisk[2])
          dpHeights[i] = dpHeights[j] + currentDisk[2];
      }
      if (maxHeight < dpHeights[i]) {
        maxHeight = dpHeights[i];
        end = i;
      }
    }

    return buildSequence(disks, maxHeight, dpHeights, end);
  }

  private static boolean areValidDimensions(Integer[] c, Integer[] o) {
    return c[0] > o[0] && c[1] > o[1] && c[2] > o[2];
  }

  private static List<Integer[]> buildSequence(
      List<Integer[]> disks, int maxHeight, int[] dpHeights, int end) {
    List<Integer[]> seq = new ArrayList<>();
    seq.add(0, disks.get(end));
    int currentHeight = dpHeights[end] - disks.get(end)[2];

    while (end >= 0) {
      if (currentHeight == dpHeights[end]) {
        seq.add(0, disks.get(end));
        currentHeight = dpHeights[end] - disks.get(end)[2];
      }

      --end;
    }

    return seq;
  }
}
