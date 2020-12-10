package Recursion.SplitPhrase;

public class SplitPhraseTest {
  public static void main(String[] args) {

    // should be ["the", "man", "ran"]
    System.out.println(
        SplitPhrase.split("themanran", new String[] {"the", "man", "ran"}).toString());
    SplitPhrase.clearList();

    // should be ["i", "love", "dogs", "John"]
    System.out.println(
        SplitPhrase.split(
                "ilovedogsJohn", new String[] {"i", "am", "a", "dogs", "lover", "love", "John"})
            .toString());
    SplitPhrase.clearList();

    // should be []
    System.out.println(
        SplitPhrase.split("themanran", new String[] {"clown", "man", "ran"}).toString());
    SplitPhrase.clearList();
  }
}
