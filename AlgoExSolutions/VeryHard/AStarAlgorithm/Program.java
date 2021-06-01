package AlgoExSolutions.VeryHard.AStarAlgorithm;

import java.util.*;

/**
 * * A* Algorithm
 */
class Program {
  /**
   * * TC: O(w * h * log(w * h))
   * * SC: O(w * h)
   */
  public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
    // Write your code here.
    List<List<Node>> nodes = initializeNode(graph);
    Node startNode = nodes.get(startRow).get(startCol);
    Node endNode = nodes.get(endRow).get(endCol);

    startNode.distanceFromStart = 0;
    startNode.estimatedDistanceToNode = calculateManhattanDistance(startNode, endNode);

    List<Node> nodesToVisit = new ArrayList<>();
    nodesToVisit.add(startNode);
    MinHeap minHeap = new MinHeap(nodesToVisit);

    while (!minHeap.isEmpty()) {
      Node currentNode = minHeap.remove();

      if (currentNode == endNode) break;

      for (Node neighbour : getNeighbours(currentNode, nodes)) {
        if (neighbour.value == 1) continue;

        int tentativeDistanceToNeighbour = currentNode.distanceFromStart + 1;
        if (tentativeDistanceToNeighbour >= neighbour.distanceFromStart) continue;

        neighbour.parent = currentNode;
        neighbour.distanceFromStart = tentativeDistanceToNeighbour;
        neighbour.estimatedDistanceToNode =
            tentativeDistanceToNeighbour + calculateManhattanDistance(neighbour, endNode);

        if (minHeap.containsNode(neighbour)) minHeap.update(neighbour);
        else minHeap.insert(neighbour);
      }
    }

    return reconstructPath(endNode);
  }

  private List<List<Node>> initializeNode(int[][] graph) {
    List<List<Node>> nodes = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      nodes.add(new ArrayList<>());
      for (int j = 0; j < graph[i].length; j++) nodes.get(i).add(new Node(i, j, graph[i][j]));
    }

    return nodes;
  }

  private int calculateManhattanDistance(Node currentNode, Node endNode) {
    return Math.abs(currentNode.row - endNode.row) + Math.abs(currentNode.col - endNode.col);
  }

  private List<Node> getNeighbours(Node node, List<List<Node>> nodes) {
    List<Node> neighbours = new ArrayList<>();

    if (node.row < nodes.size() - 1) neighbours.add(nodes.get(node.row + 1).get(node.col));

    if (node.row > 0) neighbours.add(nodes.get(node.row - 1).get(node.col));

    if (node.col < nodes.get(0).size() - 1) neighbours.add(nodes.get(node.row).get(node.col + 1));

    if (node.col > 0) neighbours.add(nodes.get(node.row).get(node.col - 1));

    return neighbours;
  }

  private int[][] reconstructPath(Node endNode) {
    if (endNode.parent == null) return new int[][] {};

    Node currentNode = endNode;
    List<int[]> path = new ArrayList<>();

    while (currentNode != null) {
      path.add(new int[] {currentNode.row, currentNode.col});
      currentNode = currentNode.parent;
    }

    int[][] res = new int[path.size()][2];

    for (int i = 0; i < res.length; i++) res[i] = path.get(res.length - 1 - i);

    return res;
  }

  static class Node {
    String id;
    int row;
    int col;
    int value;
    int distanceFromStart;
    int estimatedDistanceToNode;
    Node parent;

    public Node(int row, int col, int value) {
      id = row + "," + col;
      this.row = row;
      this.col = col;
      this.value = value;
      distanceFromStart = Integer.MAX_VALUE;
      estimatedDistanceToNode = Integer.MAX_VALUE;
      parent = null;
    }
  }

  static class MinHeap {
    List<Node> heap = new ArrayList<>();
    Map<String, Integer> nodePositions = new HashMap<>();

    public MinHeap(List<Node> array) {
      for (int i = 0; i < array.size(); i++) nodePositions.put(array.get(i).id, i);
      heap = buildHeap(array);
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
      nodePositions.put(heap.get(firstIdx).id, secondIdx);
      nodePositions.put(heap.get(secondIdx).id, firstIdx);
      Node temp = heap.get(firstIdx);
      heap.set(firstIdx, heap.get(secondIdx));
      heap.set(secondIdx, temp);
    }

    public List<Node> buildHeap(List<Node> array) {
      // Write your code here.
      int lastParentIdx = parent(array.size() - 1);

      while (lastParentIdx >= 0) {
        siftDown(lastParentIdx, array.size() - 1, array);
        --lastParentIdx;
      }

      return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Node> heap) {
      // Write your code here.
      int leftIdx = left(currentIdx);
      int rightIdx = right(currentIdx);
      int smallestIdx = currentIdx;

      if (leftIdx <= endIdx
          && heap.get(leftIdx).estimatedDistanceToNode
              < heap.get(currentIdx).estimatedDistanceToNode) smallestIdx = leftIdx;

      if (rightIdx <= endIdx
          && heap.get(rightIdx).estimatedDistanceToNode
              < heap.get(smallestIdx).estimatedDistanceToNode) smallestIdx = rightIdx;

      if (smallestIdx != currentIdx) {
        swap(currentIdx, smallestIdx);
        siftDown(smallestIdx, endIdx, heap);
      }
    }

    public void siftUp(int currentIdx, List<Node> heap) {
      // Write your code here.
      int parentIdx = parent(currentIdx);
      while (currentIdx > 0
          && heap.get(parentIdx).estimatedDistanceToNode
              > heap.get(currentIdx).estimatedDistanceToNode) {
        swap(currentIdx, parentIdx);
        currentIdx = parentIdx;
        parentIdx = parent(currentIdx);
      }
    }

    public Node peek() {
      // Write your code here.
      return heap.get(0);
    }

    public Node remove() {
      // Write your code here.
      if (isEmpty()) return null;

      swap(0, heap.size() - 1);
      Node node = heap.remove(heap.size() - 1);
      nodePositions.remove(node.id);
      siftDown(0, heap.size() - 1, heap);

      return node;
    }

    public void insert(Node node) {
      // Write your code here.
      heap.add(node);
      nodePositions.put(node.id, heap.size() - 1);
      siftUp(heap.size() - 1, heap);
    }

    public void update(Node node) {
      siftUp(nodePositions.get(node.id), heap);
    }

    public boolean containsNode(Node node) {
      return nodePositions.containsKey(node.id);
    }

    public boolean isEmpty() {
      return heap.size() == 0;
    }
  }
}
