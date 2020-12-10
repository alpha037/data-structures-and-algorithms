package Arrays.SentenceReversal;

public class SentenceReversalTest {
  public static void main(String[] args) {

    // best the is this
    System.out.println(SentenceReversal.reverse("This is the    best"));

    // here space
    System.out.println(SentenceReversal.reverse("  space here"));

    // here space
    System.out.println(SentenceReversal.reverse("space here  "));

    // go? to ready you are John, Hi
    System.out.println(SentenceReversal.reverse("Hi John,   are you ready to go?"));

    // blank
    System.out.println(SentenceReversal.reverse("         "));

    // blank
    System.out.println(SentenceReversal.reverse(null));
  }
}
