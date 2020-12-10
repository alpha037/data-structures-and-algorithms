package Arrays.ArrayPairSum;

public class ArrayPairSumTest {
  public static void main(String[] args) {

    // should be 2
    ArrayPairSum.getUniquePairs(new int[] {1, 2, 3, 2, 6, 6}, 4);

    // should be 2
    ArrayPairSum.getUniquePairs(new int[] {1, 5, 7, -1, 5}, 6);

    // should be 2
    ArrayPairSum.getUniquePairs(new int[] {2, 3, 4, -2, 6, 8, 9, 11}, 6);
  }
}
