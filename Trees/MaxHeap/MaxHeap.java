package Trees.MaxHeap;

import java.util.Arrays;

public class MaxHeap {

  private int capacity;
  private int size;
  private int[] arr;

  public MaxHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.arr = new int[capacity];
  }

  public MaxHeap(int capacity, int[] arr) {
    this.capacity = capacity;
    this.size = arr.length;
    this.arr = new int[capacity];

    fillArray(arr);
    buildHeap();
  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return this.capacity;
  }

  // * ----- Private Helper Methods -----

  private int left(int i) {
    return (int) Math.floor((2 * i) + 1);
  }

  private int right(int i) {
    return (int) Math.floor((2 * i) + 2);
  }

  private int parent(int i) {
    return (int) Math.floor((i - 1) / 2);
  }

  private void swap(int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  private void fillArray(int[] arr) {
    Arrays.fill(this.arr, 0);
    for (int i = 0; i < arr.length; i++) this.arr[i] = arr[i];
  }

  private void percolateUp(int i) {
    while (i != 0 && arr[parent(i)] < arr[i]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  // A.K.A percolateDown(i)
  private void heapify(int i) {
    int left = left(i);
    int right = right(i);
    int largest = i;

    if (left < size && arr[i] < arr[left]) largest = left;

    if (right < size && arr[largest] < arr[right]) largest = right;

    if (largest != i) {
      swap(largest, i);
      heapify(largest);
    }
  }

  private void buildHeap() {
    int i = (int) Math.floor(size / 2);
    while (i >= 0) {
      heapify(i);
      i--;
    }
  }
  // * ----- END -----

  public void insert(int value) {
    if (size == capacity) throw new IndexOutOfBoundsException("Overflow: cannot insert value");

    ++size;
    int i = size - 1;
    arr[i] = value;
    percolateUp(i);
  }

  public int extractMax() {
    int max = arr[0];
    arr[0] = arr[size - 1];
    arr[size - 1] = 0;
    --size;

    heapify(0);
    return max;
  }

  public int getMax() {
    return arr[0];
  }

  public void increaseKey(int i, int newVal) {
    arr[i] = newVal;
    percolateUp(i);
  }

  public void decreaseKey(int i, int newVal) {
    arr[i] = newVal;
    heapify(i);
  }

  public int delete(int i) {
    if (i >= size) throw new IndexOutOfBoundsException("Overflow: Cannot delete key");

    if (i < 0) throw new IndexOutOfBoundsException("Underflow: Cannot delete key");

    int deletedKey = arr[i];
    increaseKey(i, Integer.MAX_VALUE);
    extractMax();
    return deletedKey;
  }

  public void display() {
    System.out.print("\nHeap -> ");
    for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");

    System.out.println();
  }
}
