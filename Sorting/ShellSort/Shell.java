package Sorting.ShellSort;

public class Shell {

  public static int[] sort(int[] arr) {

    if (arr.length <= 1) return arr;

    int n = arr.length;

    for (int gap = n / 2; gap > 0; gap /= 2)
      for (int i = gap; i < n; i++) {
        int currentKey = arr[i];
        int j;

        for (j = i; j >= gap && currentKey < arr[j - gap]; j -= gap) arr[j] = arr[j - gap];

        arr[j] = currentKey;
      }

    return arr;
  }
}
