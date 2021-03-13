package AlgoExSolutions.Medium.MinHeapConstruction;

import java.util.*;

/**
 * * Min Heap Construction
 */

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
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

    private void swap(int firstIdx, int secondIdx, List<Integer> heap) {
      int temp = heap.get(firstIdx);
      heap.set(firstIdx, heap.get(secondIdx));
      heap.set(secondIdx, temp);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      // Write your code here.
      int lastParentIdx = parent(array.size() - 1);

      while (lastParentIdx >= 0) {
        siftDown(lastParentIdx, array.size() - 1, array);
        --lastParentIdx;
      }

      return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // Write your code here.
      int leftIdx = left(currentIdx);
      int rightIdx = right(currentIdx);
      int smallestIdx = currentIdx;

      if (leftIdx <= endIdx && heap.get(leftIdx) < heap.get(currentIdx)) smallestIdx = leftIdx;

      if (rightIdx <= endIdx && heap.get(rightIdx) < heap.get(smallestIdx)) smallestIdx = rightIdx;

      if (smallestIdx != currentIdx) {
        swap(currentIdx, smallestIdx, heap);
        siftDown(smallestIdx, endIdx, heap);
      }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      // Write your code here.
      int parentIdx = parent(currentIdx);
      while (currentIdx > 0 && heap.get(parentIdx) > heap.get(currentIdx)) {
        swap(currentIdx, parentIdx, heap);
        currentIdx = parentIdx;
        parentIdx = parent(currentIdx);
      }
    }

    public int peek() {
      // Write your code here.
      return heap.get(0);
    }

    public int remove() {
      // Write your code here.
      swap(0, heap.size() - 1, heap);
      int min = heap.remove(heap.size() - 1);

      siftDown(0, heap.size() - 1, heap);

      return min;
    }

    public void insert(int value) {
      // Write your code here.
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }
  }
}
