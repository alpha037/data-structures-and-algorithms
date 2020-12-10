package Arrays.FindMissingElement;

public class FindMissingElementTest {
  public static void main(String[] args) {

    // should be 5
    System.out.println(
        FindMissingElement.finder(
            new int[] {
              1, 2, 3, 4, 5, 6, 7,
            },
            new int[] {3, 7, 2, 1, 4, 6}));

    // should be 145
    System.out.println(
        FindMissingElement.finder(
            new int[] {98, 99, 100, 120, 158, 145}, new int[] {120, 158, 98, 99, 100}));

    // should be 548545154
    System.out.println(
        FindMissingElement.finder(
            new int[] {988888889, 989898578, 458713549, 488752554, 548545154, 548488554},
            new int[] {989898578, 458713549, 548488554, 988888889, 488752554}));

    // should be 6
    System.out.println(
        FindMissingElement.finder(
            new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[] {9, 8, 7, 5, 4, 3, 2, 1}));
  }
}
