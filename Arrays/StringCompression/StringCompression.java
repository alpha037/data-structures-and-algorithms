package Arrays.StringCompression;

public class StringCompression {
  public static String compress(String string) {

    // * Edge cases
    if (string == null || string.length() == 0) return "";

    if (string.length() == 1) return string + 1;

    String compressedString = "";

    // Tracking variables
    int i = 0;
    // int j = 1;

    int count = 1, length = string.length() - 1;

    /**
     * ? Brute Force Solution
     */
    // for (i = 0; i < length; i = j) {
    // for (j = i + 1; j < string.length(); j++)
    // if (string.charAt(i) == string.charAt(j))
    // ++count;
    // else
    // break;

    // compressedString += String.valueOf(string.charAt(i)) + count;
    // count = 1;
    // }

    /**
     * ? Optimized Solution (Run Length Encoding)
     */
    while (i < length) {
      if (string.charAt(i) == string.charAt(i + 1)) ++count;
      else {
        compressedString += String.valueOf(string.charAt(i)) + count;
        count = 1;
      }

      i++;
    }

    compressedString += String.valueOf(string.charAt(i)) + count;

    return compressedString;
  }
}
