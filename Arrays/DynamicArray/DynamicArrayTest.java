package Arrays.DynamicArray;

public class DynamicArrayTest {
  public static void main(String[] args) {
    DynamicArray array = new DynamicArray();

    array.add(1);
    array.add(2);
    array.add(3);
    array.add(4);
    array.add(5);
    array.add(6);
    array.add(7);

    System.out.println("Length: " + array.length()); // should be 7

    System.out.println("Element at 1st index: " + array.get(0)); // should be 1
    System.out.println("Element at 2nd index: " + array.get(1)); // should be 2
    System.out.println("Element at 3rd index: " + array.get(2)); // should be 3
    System.out.println("Element at 4th index: " + array.get(3)); // should be 4
    System.out.println("Element at 5th index: " + array.get(4)); // should be 5
    System.out.println("Element at 6th index: " + array.get(5)); // should be 6
    System.out.println("Element at 7th index: " + array.get(6)); // should be 7

    // should throw an ArrayIndexOutOfBounds Exception
    System.out.println("Element at 8th index: " + array.get(8));
  }
}
