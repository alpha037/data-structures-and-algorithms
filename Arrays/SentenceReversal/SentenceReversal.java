package Arrays.SentenceReversal;

import java.util.Stack;

public class SentenceReversal {

  public static String reverse(String sentence) {

    // * Edge Cases
    if (sentence == null || sentence.equals("")) return "";

    // * Regex to take care of multiple consecutive spaces
    String[] words = sentence.trim().split("\\s+");

    /**
     * ? Basic in place reversal algorithm
     */

    // int i = 0, j = words.length - 1;

    // while (i < j) {
    // String temp = words[i];
    // words[i] = words[j];
    // words[j] = temp;

    // i++;
    // j--;
    // }

    // return String.join(" ", words);

    /**
     * ? Stack Implementation
     */
    Stack<String> stack = new Stack<>();

    for (String word : words) stack.push(word);

    String reversedString = "";
    for (int i = 0; i < words.length; i++) reversedString += stack.pop() + " ";

    return reversedString;
  }
}
