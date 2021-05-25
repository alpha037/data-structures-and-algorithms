package AlgoExSolutions.VeryHard.MinimumAreaRectangle;

import java.util.*;

/**
 * * Minimum Area Rectangle
 */
class Program {
  /**
   * * Diagonal Mapping Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  public int minimumAreaRectangle(int[][] points) {
    // Write your code here.
    Map<String, Boolean> pointsMap = getPointsMap(points);
    int minArea = Integer.MAX_VALUE;

    for (int i = 0; i < points.length; i++) {
      int p1x = points[i][0], p1y = points[i][1];
      for (int j = 0; j < i; j++) {
        int p2x = points[j][0], p2y = points[j][1];
        boolean areInvalidPoints = p1x == p2x || p1y == p2y;

        if (areInvalidPoints) continue;

        String p3 = toStr(p1x, p2y), p4 = toStr(p2x, p1y);

        if (pointsMap.containsKey(p3) && pointsMap.containsKey(p4)) {
          int currentArea = area(p1x, p2x, p1y, p2y);
          minArea = Math.min(minArea, currentArea);
        }
      }
    }

    return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }

  private Map<String, Boolean> getPointsMap(int[][] points) {
    Map<String, Boolean> map = new HashMap<>();
    for (int[] point : points) map.put(toStr(point[0], point[1]), true);
    return map;
  }

  private String toStr(int x, int y) {
    return x + "," + y;
  }

  /**
   * * Edge Recognition Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // public int minimumAreaRectangle(int[][] points) {
  // 	Map<Integer, List<Integer>> xColumns = getPointsOrderedByXValue(points);
  // 	Map<String, Integer> pointsParallelToYAxis = new HashMap<>();
  // 	List<Integer> sortedXPoints = new ArrayList<>(xColumns.keySet());
  // 	Collections.sort(sortedXPoints);
  // 	int minArea = Integer.MAX_VALUE;

  // 	for (int x1 : sortedXPoints) {
  // 		List<Integer> yPoints = xColumns.get(x1);
  // 		Collections.sort(yPoints);

  // 		for (int i = 0; i < yPoints.size(); i++) {
  // 			int y2 = yPoints.get(i);
  // 			for (int j = 0; j < i; j++) {
  // 				int y1 = yPoints.get(j);
  // 				String pointString = y1 + "," + y2;

  // 				if (pointsParallelToYAxis.containsKey(pointString)) {
  // 					int x2 = pointsParallelToYAxis.get(pointString);
  // 					int currentArea = area(x1, x2, y1, y2);
  // 					minArea = Math.min(minArea, currentArea);
  // 				}

  // 				pointsParallelToYAxis.put(pointString, x1);
  // 			}
  // 		}
  // 	}

  //   return minArea == Integer.MAX_VALUE ? 0 : minArea;
  // }

  // private Map<Integer, List<Integer>> getPointsOrderedByXValue(int[][] points) {
  // 	Map<Integer, List<Integer>> map = new HashMap<>();
  // 	for (int[] point : points) {
  // 		int x = point[0], y = point[1];
  // 		if (!map.containsKey(x)) map.put(x, new ArrayList<>());
  // 		map.get(x).add(y);
  // 	}

  // 	return map;
  // }

  private int area(int x1, int x2, int y1, int y2) {
    return Math.abs(x1 - x2) * Math.abs(y1 - y2);
  }
}
