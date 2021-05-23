package AlgoExSolutions.VeryHard.ApartmentHunting;

import java.util.*;

/**
 * * Apartment Hunting
 */
class Program {
  /**
   * * Optimized Approach
   *
   * * TC: O(br)
   * * SC: O(br)
   */
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    // Write your code here.
    int locationIdx = -1, closestDistance = Integer.MAX_VALUE;
    Map<String, List<Integer>> distances = preComputeDistances(blocks, reqs);

    for (int i = 0; i < blocks.size(); i++) {
      int currentDistance = Integer.MIN_VALUE;
      for (String req : reqs)
        currentDistance = Math.max(currentDistance, distances.get(req).get(i));

      if (closestDistance > currentDistance) {
        closestDistance = currentDistance;
        locationIdx = i;
      }
    }

    return locationIdx;
  }

  private static Map<String, List<Integer>> preComputeDistances(
      List<Map<String, Boolean>> blocks, String[] reqs) {
    int len = blocks.size();
    Map<String, List<Integer>> cache = new HashMap<>();

    for (String req : reqs) {
      Integer[] minDistances = new Integer[len];
      int minIdx = -1;

      for (int i = 0; i < len; i++) {
        if (blocks.get(i).get(req)) minIdx = i;
        minDistances[i] = minIdx == -1 ? Integer.MAX_VALUE : distanceBetween(minIdx, i);
      }

      for (int i = len - 1; i >= 0; i--) {
        if (blocks.get(i).get(req)) minIdx = i;
        minDistances[i] = Math.min(minDistances[i], distanceBetween(minIdx, i));
      }

      cache.put(req, new ArrayList<>(Arrays.asList(minDistances)));
    }

    return cache;
  }

  private static int distanceBetween(int start, int end) {
    return Math.abs(start - end);
  }

  /**
   * * Brute Force Approach
   *
   * * TC: O(b^2 * r)
   * * SC: O(b)
   */
  // public static int apartmentHunting(
  // 	List<Map<String, Boolean>> blocks, String[] reqs
  // ) {
  // 	int len = blocks.size();
  // 	int[] maxDistances = new int[len];
  // 	Arrays.fill(maxDistances, -1);

  // 	for (int i = 0; i < len; i++) {
  // 		for (String req : reqs) {
  // 			int currentDistance = Integer.MAX_VALUE;
  // 			for (int j = 0; j < len; j++) {
  // 				if (blocks.get(j).get(req))
  // 					currentDistance = Math.min(currentDistance, Math.abs(j - i));
  // 			}

  // 			maxDistances[i] = Math.max(maxDistances[i], currentDistance);
  // 		}
  // 	}

  //   return getLocationIdx(maxDistances);
  // }

  // private static int getLocationIdx(int[] maxDistances) {
  // 	int locationIdx = -1, minDistance = Integer.MAX_VALUE;
  // 	for (int i = 0; i < maxDistances.length; i++) {
  // 		if (minDistance > maxDistances[i]) {
  // 			minDistance = maxDistances[i];
  // 			locationIdx = i;
  // 		}
  // 	}

  // 	return locationIdx;
  // }
}
