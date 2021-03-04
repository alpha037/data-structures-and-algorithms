package AlgoExSolutions.Easy.CaesarCipherEncryptor;

// import java.util.*;

/**
 * * Caesar Cipher Encryptor
 */
class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
    if (str == null || str.length() == 0) return key == 0 ? str : "";

    key %= 26;

    char[] ch = str.toCharArray();

    for (int i = 0; i < ch.length; i++) {
      int newPos = key + (ch[i]);
      ch[i] = newPos > 122 ? (char) ('a' + (newPos % 122) - 1) : (char) (newPos);
    }

    return new String(ch);
  }
}
