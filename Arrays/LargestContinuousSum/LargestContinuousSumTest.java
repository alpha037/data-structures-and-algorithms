package Arrays.LargestContinuousSum;

public class LargestContinuousSumTest {

  public static void main(String[] args) {

    // should be 29.
    System.out.println(LargestContinuousSum.find(new int[] {1, 2, -1, 3, 4, 10, 10, -10, -1}));

    // should be 7.
    System.out.println(LargestContinuousSum.find(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));

    // should be 1.
    System.out.println(LargestContinuousSum.find(new int[] {-2, 1}));
  }
}
