package Arrays.StringCompression;

public class StringCompressionTest {
  public static void main(String[] args) {

    // should be A4B4C5D2E4A2B2C5
    System.out.println(StringCompression.compress("AAAABBBBCCCCCDDEEEEAABBCCCCC"));

    // should be A4a4
    System.out.println(StringCompression.compress("AAAAaaaa"));

    // should be A2B1
    System.out.println(StringCompression.compress("AAB"));

    // should be blank
    System.out.println(StringCompression.compress(""));

    // should be blank
    System.out.println(StringCompression.compress(null));

    // should be S1
    System.out.println(StringCompression.compress("S"));
  }
}
