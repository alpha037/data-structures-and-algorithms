package Recursion.StringReverser;

public class ReverserTest {
  public static void main(String[] args) {

    // should be "dlrow olleh"
    System.out.println("hello world -> " + Reverser.reverse("hello world"));

    // should be "olleh"
    System.out.println("hello -> " + Reverser.reverse("hello"));

    // should be "9876543210"
    System.out.println("0123456789 -> " + Reverser.reverse("0123456789"));
  }
}
