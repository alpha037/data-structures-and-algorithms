package Sorting.QuickSort;

public class QuickTest {
  public static void main(String[] args) {
    Quick quick = new Quick();

    int[] arr = {10, -12, 56, -147, 0, 21, 45, 65, 788};
    quick.sort(arr);

    for (int el : arr) System.out.print(el + " ");

    System.out.println();
  }
}
