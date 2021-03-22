package AlgoExSolutions.Hard.MinRewards;

import java.util.*;

/**
 * * Min Rewards
 */
class Program {
  /**
   * * Peaks and Valleys, but Simpler
   * * TC: O(n)
   * * SC: O(n)
   */
  public static int minRewards(int[] scores) {
    // Write your code here.
    int len = scores.length;
    int[] rewards = new int[len];
    Arrays.fill(rewards, 1);

    for (int i = 1; i < len; i++) {
      if (scores[i] > scores[i - 1]) rewards[i] += rewards[i - 1];
    }

    for (int i = len - 2; i >= 0; i--) {
      if (scores[i] > scores[i + 1]) rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
    }

    int minRewards = 0;
    for (int reward : rewards) minRewards += reward;

    return minRewards;
  }

  /**
   * * Peaks and Valleys Approach
   * * TC: O(n)
   * * SC: O(n)
   */
  // public static int minRewards(int[] scores) {
  //   int len = scores.length, minRewards = 0;
  //   int[] rewards = new int[len];
  // 	Arrays.fill(rewards, 1);
  //   List<Integer> localMinIndices = getLocalMinIndices(scores, len);

  //   for(int localMinIdx : localMinIndices)
  //     expandFromLocalMinIndex(localMinIdx, scores, rewards);

  //   for (int reward : rewards) minRewards += reward;

  //   return minRewards;
  // }

  // private static List<Integer> getLocalMinIndices(int[] scores, int len) {
  //   List<Integer> localMinIndices = new ArrayList<>();

  //   if (len == 1) {
  //     localMinIndices.add(0);
  //     return localMinIndices;
  //   }

  //   for (int i = 0; i < len; i++) {
  //     if (i == 0 && scores[i] < scores[i + 1]) localMinIndices.add(i);
  //     if (i == len - 1 && scores[i] < scores[i - 1]) localMinIndices.add(i);
  //     if (i == 0 || i == len - 1) continue;
  //     if (scores[i] < scores[i - 1] && scores[i] < scores[i + 1])
  //       localMinIndices.add(i);
  //   }

  //   return localMinIndices;
  // }

  // private static void expandFromLocalMinIndex(
  //   int localMinIdx, int[] scores, int[] rewards
  // ) {
  //   int leftIdx = localMinIdx - 1;
  //   while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
  //     rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
  //     --leftIdx;
  //   }

  //   int rightIdx = localMinIdx + 1;
  //   while (rightIdx < scores.length && scores[rightIdx] > scores[rightIdx - 1]) {
  //     rewards[rightIdx] = Math.max(rewards[rightIdx], rewards[rightIdx - 1] + 1);
  //     ++rightIdx;
  //   }
  // }

  /**
   * * Brute Force Approach
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // public static int minRewards(int[] scores) {
  //   int len = scores.length, minRewards = 0;
  //   int[] rewards = new int[len];
  //   Arrays.fill(rewards, 1);

  //   for (int i = 1; i < len; i++) {
  //     if (scores[i] > scores[i - 1]) rewards[i] = rewards[i - 1] + 1;

  //     else {
  //       int j = i - 1;

  //       while (j >= 0 && scores[j] > scores[j + 1]) {
  //         rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
  //         --j;
  //       }
  //     }
  //   }

  //   for (int reward : rewards) minRewards += reward;

  //   return minRewards;
  // }
}
