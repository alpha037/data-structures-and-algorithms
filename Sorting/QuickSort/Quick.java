package Sorting.QuickSort;

public class Quick {

  public void sort(int[] arr) {
    quicksort(arr, 0, arr.length - 1);
  }

  private void quicksort(int[] arr, int low, int high) {
    if (low < high) {

      int pivot = partition(arr, low, high);

      quicksort(arr, low, pivot - 1);
      quicksort(arr, pivot + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high) {
    int i = low - 1;

    for (int j = low; j <= (high - 1); j++)
      if (arr[j] <= arr[high]) {
        ++i;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }
}
