package Sorting.MergeSort;

public class MergeTest {
  public static void main(String[] args) {
    Merge merge = new Merge();

    int[] arr = {10, -12, 56, -147, 0, 21, 45, 65, 788};
    merge.sort(arr);

    for (int el : arr) System.out.print(el + " ");

    System.out.println();
  }
}
