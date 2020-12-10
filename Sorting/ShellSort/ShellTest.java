package Sorting.ShellSort;

public class ShellTest {
  public static void main(String[] args) {

    int[] res = Shell.sort(new int[] {20, -1, 15, 124, -56});

    // should be -56, -1, 15, 20, 124
    for (int el : res) System.out.print(el + " ");
  }
}
