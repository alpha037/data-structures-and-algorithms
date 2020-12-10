package Sorting.HeapSort;

public class Heap {
  private void heapify(int[] arr, int i, int length) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;

    if (left < length && arr[left] > arr[largest]) largest = left;

    if (right < length && arr[right] > arr[largest]) largest = right;

    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      heapify(arr, largest, length);
    }
  }

  private void buildHeap(int[] arr, int length) {
    int i = (int) Math.floor(length / 2);
    while (i >= 0) {
      heapify(arr, i, length);
      --i;
    }
  }

  private void heapSort(int[] arr, int length) {
    buildHeap(arr, length);

    for (int i = length - 1; i > 0; --i) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, 0, i);
    }
  }

  public void sort(int[] arr) {
    heapSort(arr, arr.length);
  }
}
