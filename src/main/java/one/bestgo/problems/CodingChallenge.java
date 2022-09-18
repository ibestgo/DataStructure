package one.bestgo.problems;

/**
 * Given a string str, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Examples:
 * input: str = "bcabc"
 * Output: "abc"
 * input: str = "cbacdcbc"
 * Output: "acdb"
 */
public class CodingChallenge {
  public static void main(String[] args) {
    String[] strs = {"bcabc", "cbacdcbc"};
    for (String str : strs) {
      System.out.println(solution(str));
    }
  }

  private static String solution(String str) {
    return "";
  }
}
