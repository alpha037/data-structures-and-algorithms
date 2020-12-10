package Recursion.StringReverser;

public class Reverser {

  public static String reverse(String string) {

    // * Base Case
    if (string.length() <= 1) return string;

    return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
  }
}
