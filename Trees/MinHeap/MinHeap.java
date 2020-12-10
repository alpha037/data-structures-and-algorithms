package Trees.MinHeap;

import java.util.Arrays;

public class MinHeap {
  private int capacity;
  private int size;
  private int[] arr;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.arr = new int[capacity];
  }

  public MinHeap(int capacity, int[] arr) {
    this.capacity = capacity;
    this.size = arr.length;
    this.arr = new int[capacity];
    fillArray(arr);
    buildHeap();
  }

  public int capacity() {
    return this.capacity;
  }

  public int size() {
    return this.size;
  }

  // * ----- Private Helper Methods -----

  private int parent(int i) {
    return (int) Math.floor((i - 1) / 2);
  }

  private int left(int i) {
    return (int) Math.floor((2 * i) + 1);
  }

  private int right(int i) {
    return (int) Math.floor((2 * i) + 2);
  }

  private void fillArray(int[] arr) {
    Arrays.fill(this.arr, 0);
    for (int i = 0; i < arr.length; i++) this.arr[i] = arr[i];
  }

  private void swap(int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  // A.K.A percolateDown(i)
  private void heapify(int i) {
    int left = left(i);
    int right = right(i);
    int smallest = i;

    if (left < size && arr[left] < arr[i]) smallest = left;

    if (right < size && arr[right] < arr[smallest]) smallest = right;

    if (smallest != i) {
      swap(i, smallest);
      heapify(smallest);
    }
  }

  private void buildHeap() {
    int i = (int) Math.floor(size / 2);
    while (i >= 0) {
      heapify(i);
      i--;
    }
  }

  private void percolateUp(int i) {
    while (i != 0 && arr[parent(i)] > arr[i]) {
      swap(parent(i), i);
      i = parent(i);
    }
  }

  // * ----- END -----

  public void insert(int value) {
    if (size == capacity) throw new IndexOutOfBoundsException("Overflow: Cannot insert key");

    ++size;
    int i = size - 1;
    arr[i] = value;
    percolateUp(i);
    ;
  }

  public int extractMin() {
    int min = arr[0];
    arr[0] = arr[size - 1];
    arr[size - 1] = 0;
    --size;
    heapify(0);
    return min;
  }

  public int getMin() {
    return arr[0];
  }

  public void decreaseKey(int i, int newVal) {
    // if (newVal > arr[i]) {
    //   System.out.println("Associated key is less than new value");
    //   return;
    // }

    arr[i] = newVal;
    percolateUp(i);
  }

  public int delete(int i) {
    if (i >= size) throw new IndexOutOfBoundsException("Overflow: Cannot delete key");

    if (i < 0) throw new IndexOutOfBoundsException("Underflow: Cannot delete key");

    int deletedKey = arr[i];
    decreaseKey(i, Integer.MIN_VALUE);
    extractMin();
    return deletedKey;
  }

  public void display() {
    System.out.print("\nHeap -> ");
    for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");

    System.out.println("\n");
  }
}
