package Sorting.HeapSort;

public class HeapTest {
  public static void main(String[] args) {
    Heap heap = new Heap();

    int[] arr = {10, -12, 56, -147, 0, 21, 45, 65, 788};
    heap.sort(arr);

    for (int el : arr) System.out.print(el + " ");

    System.out.println();
  }
}
