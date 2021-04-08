package AlgoExSolutions.Hard.DijkstrasAlgorithm;

import java.util.*;

/**
 * * Dijkstra's Algorithm
 */
class Program {
  /**
   * * O((v + e) * log v) time | O(v) space
   */
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
    int len = edges.length;

    int[] minDistances = new int[len];
    Arrays.fill(minDistances, Integer.MAX_VALUE);
    minDistances[start] = 0;

    List<Item> minDistancesPairs = new ArrayList<>();
    for (int i = 0; i < len; i++) minDistancesPairs.add(new Item(i, Integer.MAX_VALUE));

    MinHeap minHeap = new MinHeap(minDistancesPairs);
    minHeap.update(start, 0);

    while (!minHeap.isEmpty()) {
      Item minItem = minHeap.remove();
      int srcVertex = minItem.vertex;
      int currentMinDistance = minItem.distance;

      if (currentMinDistance == Integer.MAX_VALUE) break;

      for (int[] edge : edges[srcVertex]) {
        int destVertex = edge[0];
        int newPathDistance = edge[1] + currentMinDistance;

        if (newPathDistance < minDistances[destVertex]) {
          minDistances[destVertex] = newPathDistance;
          minHeap.update(destVertex, newPathDistance);
        }
      }
    }

    replaceInfinities(minDistances);

    return minDistances;
  }

  /**
   * * O(v^2) time | O(v) space
   */
  // public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
  // 	int[] minDistances = new int[edges.length];
  // 	Arrays.fill(minDistances, Integer.MAX_VALUE);
  // 	minDistances[start] = 0;

  // 	Set<Integer> visited = new HashSet<>();

  // 	while (visited.size() != edges.length) {
  // 		int[] vertexInfo = getVertexWithMinDistance(minDistances, visited);
  // 		int srcVertex = vertexInfo[0], currentMinDistance = vertexInfo[1];

  // 		if (currentMinDistance == Integer.MAX_VALUE) break;

  // 		visited.add(srcVertex);

  // 		for (int[] edge : edges[srcVertex]) {
  // 			int destVertex = edge[0], newPathDistance = edge[1] + currentMinDistance;

  // 			if (visited.contains(destVertex)) continue;

  // 			if (newPathDistance < minDistances[destVertex])
  // 				minDistances[destVertex] = newPathDistance;
  // 		}
  // 	}

  // 	replaceInfinities(minDistances);

  //   return minDistances;
  // }

  // private int[] getVertexWithMinDistance(int[] distances, Set<Integer> visited) {
  // 	int minVertex = -1, minDistance = Integer.MAX_VALUE;

  // 	for (int vertex = 0; vertex < distances.length; vertex++) {
  // 		if (visited.contains(vertex)) continue;

  // 		if (distances[vertex] <= minDistance) {
  // 			minDistance = distances[vertex];
  // 			minVertex = vertex;
  // 		}
  // 	}

  // 	return new int[] {minVertex, minDistance};
  // }

  private void replaceInfinities(int[] distances) {
    for (int idx = 0; idx < distances.length; idx++) {
      if (distances[idx] == Integer.MAX_VALUE) distances[idx] = -1;
    }
  }

  static class Item {
    int vertex;
    int distance;

    public Item(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }
  }

  static class MinHeap {
    Map<Integer, Integer> vertexMap;
    List<Item> heap;

    public MinHeap(List<Item> array) {
      vertexMap = buildVertexMap(array);
      heap = buildHeap(array);
    }

    private List<Item> buildHeap(List<Item> array) {
      // Write your code here.
      int lastParentIdx = parent(array.size() - 1);

      while (lastParentIdx >= 0) {
        siftDown(lastParentIdx, array.size() - 1, array);
        --lastParentIdx;
      }

      return array;
    }

    private Map<Integer, Integer> buildVertexMap(List<Item> array) {
      Map<Integer, Integer> vertexMap = new HashMap<>();

      for (int i = 0; i < array.size(); i++) {
        Item item = array.get(i);
        vertexMap.put(item.vertex, item.vertex);
      }

      return vertexMap;
    }

    private int parent(int index) {
      return (int) Math.floor((index - 1) / 2);
    }

    private int left(int index) {
      return (int) Math.floor((2 * index) + 1);
    }

    private int right(int index) {
      return (int) Math.floor((2 * index) + 2);
    }

    private void swap(int firstIdx, int secondIdx) {
      vertexMap.put(heap.get(firstIdx).vertex, secondIdx);
      vertexMap.put(heap.get(secondIdx).vertex, firstIdx);
      Item temp = heap.get(firstIdx);
      heap.set(firstIdx, heap.get(secondIdx));
      heap.set(secondIdx, temp);
    }

    private void siftDown(int currentIdx, int endIdx, List<Item> heap) {
      // Write your code here.
      int leftIdx = left(currentIdx);
      int rightIdx = right(currentIdx);
      int smallestIdx = currentIdx;

      if (leftIdx <= endIdx && heap.get(leftIdx).distance < heap.get(currentIdx).distance)
        smallestIdx = leftIdx;

      if (rightIdx <= endIdx && heap.get(rightIdx).distance < heap.get(smallestIdx).distance)
        smallestIdx = rightIdx;

      if (smallestIdx != currentIdx) {
        swap(currentIdx, smallestIdx);
        siftDown(smallestIdx, endIdx, heap);
      }
    }

    private void siftUp(int currentIdx, List<Item> heap) {
      // Write your code here.
      int parentIdx = parent(currentIdx);
      while (currentIdx > 0 && heap.get(parentIdx).distance > heap.get(currentIdx).distance) {
        swap(currentIdx, parentIdx);
        currentIdx = parentIdx;
        parentIdx = parent(currentIdx);
      }
    }

    public Item peek() {
      // Write your code here.
      return heap.get(0);
    }

    public Item remove() {
      // Write your code here.
      if (isEmpty()) return null;

      swap(0, heap.size() - 1);
      Item lastItem = heap.remove(heap.size() - 1);

      vertexMap.remove(lastItem.vertex);
      siftDown(0, heap.size() - 1, heap);

      return lastItem;
    }

    public void update(int vertex, int value) {
      // Write your code here.
      heap.set(vertexMap.get(vertex), new Item(vertex, value));
      siftUp(vertexMap.get(vertex), heap);
    }

    public boolean isEmpty() {
      return heap.size() == 0;
    }
  }
}
