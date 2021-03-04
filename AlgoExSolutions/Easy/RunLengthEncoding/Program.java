package AlgoExSolutions.Easy.RunLengthEncoding;

// import java.util.*;

/**
 * * Run-Length Encoding
 */
class Program {
  public String runLengthEncoding(String string) {
    // Write your code here.
    if (string == null || string.length() == 0) return "";

    int count = 1;
    String rLEString = "";

    for (int i = 1; i < string.length(); i++) {
      if (string.charAt(i - 1) != string.charAt(i) || count == 9) {
        rLEString += count + "" + string.charAt(i - 1);
        count = 0;
      }
      ++count;
    }

    rLEString += count + "" + string.charAt(string.length() - 1);

    return rLEString;
  }
}
