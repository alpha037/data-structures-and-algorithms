package AlgoExSolutions.VeryHard.RectangleMania;

import java.util.*;

/**
 * * Rectangle Mania
 */
class Program {
  static String UP = "up";
  static String DOWN = "down";
  static String LEFT = "left";
  static String RIGHT = "right";

  public static int rectangleMania(List<Integer[]> coords) {
    // Write your code here.
    return getRectangleCount(coords, getCoordsMap(coords));
  }

  /**
   * * HashMap Approach
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  private static int getRectangleCount(List<Integer[]> coords, Map<String, Boolean> coordsMap) {
    int countOfRectangles = 0;

    for (Integer[] coord1 : coords) {
      int p1x = coord1[0], p1y = coord1[1];
      for (Integer[] coord2 : coords) {
        int p2x = coord2[0], p2y = coord2[1];
        boolean areValidPoints = p2x > p1x && p2y > p1y;

        if (!areValidPoints) continue;

        String p3 = toStr(p1x, p2y), p4 = toStr(p2x, p1y);
        if (coordsMap.containsKey(p3) && coordsMap.containsKey(p4)) ++countOfRectangles;
      }
    }

    return countOfRectangles;
  }

  private static Map<String, Boolean> getCoordsMap(List<Integer[]> coords) {
    Map<String, Boolean> coordsMap = new HashMap<>();
    for (Integer[] coord : coords) coordsMap.put(toStr(coord[0], coord[1]), true);
    return coordsMap;
  }

  private static String toStr(int x, int y) {
    return x + "," + y;
  }

  /**
   * * DFS Approach (Space Optimized)
   *
   * * TC: O(n^2)
   * * SC: O(n)
   */
  // private static int getRectangleCount(
  // 	List<Integer[]> coords, Map<String, Map<Integer, List<Integer[]>>> coordsMap
  // ) {
  // 	int countOfRectangles = 0;
  // 	for (Integer[] coord : coords) {
  // 		int lowerLeftY = coord[1];
  // 		countOfRectangles +=
  // 			clockwiseCountRectangles(coord, UP, coordsMap, lowerLeftY);
  // 	}
  // 	return countOfRectangles;
  // }

  // private static int clockwiseCountRectangles(
  // 	Integer[] coord1, String direction,
  // 	Map<String, Map<Integer, List<Integer[]>>> coordsMap, int lowerLeftY
  // ) {
  // 	if (direction.equals(DOWN)) {
  // 		for (Integer[] coord2 : coordsMap.get("x").get(coord1[0])) {
  // 			int lowerRightY = coord2[1];
  // 			if (lowerLeftY == lowerRightY) return 1;
  // 		}
  // 		return 0;
  // 	}
  // 	else {
  // 		int countOfRectangles = 0;
  // 		if (direction.equals(UP)) {
  // 			for (Integer[] coord2 : coordsMap.get("x").get(coord1[0])) {
  // 				boolean isAbove = coord2[1] > coord1[1];
  // 				if (isAbove)
  // 					countOfRectangles += clockwiseCountRectangles(
  // 						coord2, RIGHT, coordsMap, lowerLeftY
  // 					);
  // 			}
  // 		}
  // 		else if (direction.equals(RIGHT)) {
  // 			for (Integer[] coord2 : coordsMap.get("y").get(coord1[1])) {
  // 				boolean isRight = coord2[0] > coord1[0];
  // 				if (isRight)
  // 					countOfRectangles += clockwiseCountRectangles(
  // 						coord2, DOWN, coordsMap, lowerLeftY
  // 					);
  // 			}
  // 		}

  // 		return countOfRectangles;
  // 	}
  // }

  /**
   * * DFS Approach
   *
   * * TC: O(n^2)
   * * SC: O(n^2)
   */
  // private static Map<String, Map<Integer, List<Integer[]>>> getCoordsMap(
  // 	List<Integer[]> coords
  // ) {
  // 	Map<String, Map<Integer, List<Integer[]>>> coordsMap = new HashMap<>();
  // 	coordsMap.put("x", new HashMap<>());
  // 	coordsMap.put("y", new HashMap<>());

  // 	for (Integer[] coord : coords) {
  // 		int x = coord[0], y = coord[1];
  // 		if (!coordsMap.get("x").containsKey(x))
  // 			coordsMap.get("x").put(x, new ArrayList<>());

  // 		if (!coordsMap.get("y").containsKey(y))
  // 			coordsMap.get("y").put(y, new ArrayList<>());

  // 		coordsMap.get("x").get(x).add(coord);
  // 		coordsMap.get("y").get(y).add(coord);
  // 	}

  // 	return coordsMap;
  // }

  // private static int getRectangleCount(
  // 	List<Integer[]> coords, Map<String, Map<String, List<Integer[]>>> coordsMap
  // ) {
  // 	int countOfRectangles = 0;
  // 	for (Integer[] coord : coords)
  // 		countOfRectangles += clockwiseCountOfRectangles(coord, coordsMap, UP, coord);
  // 	return countOfRectangles;
  // }

  // private static int clockwiseCountOfRectangles(
  // 	Integer[] coord, Map<String, Map<String, List<Integer[]>>> coordsMap,
  // 	String direction, Integer[] origin
  // ) {
  // 	String coordString = toStr(coord[0], coord[1]);
  // 	if (direction.equals(LEFT)) {
  // 		boolean isRectangleFound = coordsMap
  // 			.get(coordString).get(LEFT).contains(origin);
  // 		return isRectangleFound ? 1 : 0;
  // 	}
  // 	else {
  // 		int countOfRectangles = 0;
  // 		String nextDirection = getNextClockwiseDirection(direction);
  // 		for (Integer[] nextCoord : coordsMap.get(coordString).get(direction))
  // 			countOfRectangles +=
  // 				clockwiseCountOfRectangles(nextCoord, coordsMap, nextDirection, origin);
  // 		return countOfRectangles;
  // 	}
  // }

  // private static String getNextClockwiseDirection(String direction) {
  // 	if (direction.equals(UP)) return RIGHT;
  // 	if (direction.equals(RIGHT)) return DOWN;
  // 	if (direction.equals(DOWN)) return LEFT;
  // 	return "";
  // }

  // private static Map<String, Map<String, List<Integer[]>>> getCoordsMap(
  // 	List<Integer[]> coords
  // ) {
  // 	Map<String, Map<String, List<Integer[]>>> coordsMap = new HashMap<>();
  // 	for (Integer[] coord1 : coords) {
  // 		Map<String, List<Integer[]>> coord1Directions = new HashMap<>();
  // 		coord1Directions.put(UP, new ArrayList<>());
  // 		coord1Directions.put(DOWN, new ArrayList<>());
  // 		coord1Directions.put(LEFT, new ArrayList<>());
  // 		coord1Directions.put(RIGHT, new ArrayList<>());

  // 		for (Integer[] coord2 : coords) {
  // 			String direction = getDirection(coord1, coord2);
  // 			if (coord1Directions.containsKey(direction))
  // 				coord1Directions.get(direction).add(coord2);
  // 		}
  // 		String coord1String = toStr(coord1[0], coord1[1]);
  // 		coordsMap.put(coord1String, coord1Directions);
  // 	}
  // 	return coordsMap;
  // }

  // private static String toStr(int x, int y) {
  // 	return x + "," + y;
  // }

  // private static String getDirection(Integer[] coord1, Integer[] coord2) {
  // 	int x1 = coord1[0], x2 = coord2[0], y1 = coord1[1], y2 = coord2[1];
  // 	if (x2 == x1) {
  // 		if (y2 > y1) return UP;
  // 		else if (y2 < y1) return DOWN;
  // 	}
  // 	else if (y1 == y2) {
  // 		if (x2 > x1) return RIGHT;
  // 		else if (x2 < x1) return LEFT;
  // 	}
  // 	return  "";
  // }
}
