package Sorting.SelectionSort;

public class SelectionTest {
  public static void main(String[] args) {

    int[] res = Selection.sort(new int[] {20, -1, 15, 124, -56});

    // should be -56, -1, 15, 20, 124
    for (int el : res) System.out.print(el + " ");
  }
}
