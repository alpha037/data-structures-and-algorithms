package AlgoExSolutions.Medium.PhoneNumberMnemonics;

import java.util.*;

/**
 * * Phone Number Mnemonics
 */
class Program {
  private final String[] KEYPAD = {
    "0", "1", "abc", "def", "ghi",
    "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  private void phoneNumberMnemonics(
      String phoneNumber, int index, StringBuilder current, ArrayList<String> mnemonics) {
    /**
     * Base Case.
     */
    if (index == phoneNumber.length()) {
      mnemonics.add(current.toString());
      return;
    }

    char[] keypadLetters = KEYPAD[phoneNumber.charAt(index) - '0'].toCharArray();
    for (char letter : keypadLetters) {
      // First, we append the
      // current letter
      current.append(letter);

      // Then, we try out all
      // the possibilities
      phoneNumberMnemonics(phoneNumber, index + 1, current, mnemonics);

      // Then, we remove the letter
      current.deleteCharAt(current.length() - 1);
    }
  }

  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    // Write your code here.
    ArrayList<String> mnemonics = new ArrayList<>();

    phoneNumberMnemonics(phoneNumber, 0, new StringBuilder(""), mnemonics);

    return mnemonics;
  }
}
