package Arrays.FindMissingElement;

public class FindMissingElement {

  public static int finder(int[] array, int[] shuffledArray) {

    // * This could cause an overflow if the numbers are too big or too small or
    // * if the array is too long.

    // int sum = array[0];

    // for (int i = 1; i < array.length; i++)
    // sum += array[i];

    // for (int i = 0; i < shuffledArray.length; i++)
    // sum -= shuffledArray[i];

    // * XOR-ing a number with itself is -> 0,
    // * XOR-ing a number with 0 is -> the number itself
    int sum = 0;

    for (int el : array) sum ^= el;

    for (int el : shuffledArray) sum ^= el;

    return sum;
  }
}
