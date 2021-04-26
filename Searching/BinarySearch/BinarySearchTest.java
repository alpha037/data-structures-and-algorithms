package Searching.BinarySearch;

public class BinarySearchTest {
  public static void main(String[] args) {

    int position = BinarySearch.search(new int[] {2, 6, 8, 10, 12, 13}, 10);

    // should be 3
    System.out.println(
        position < 0 ? "\nValue not found in the array" : "\nValue found at position: " + position);

    position = BinarySearch.search(new int[] {2, 6, 8, 10, 12, 13}, 20);

    // Not found
    System.out.println(
        position < 0 ? "\nValue not found in the array" : "\nValue found at position: " + position);
  }
}
