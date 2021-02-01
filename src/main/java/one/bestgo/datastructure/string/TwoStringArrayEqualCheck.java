package one.bestgo.datastructure.string;

public class TwoStringArrayEqualCheck {
  public static void main(String[] args) {

  }

  // word1 = ["ab", "c"]
  // word2 = ["a", "b", c"]
  // return true
  private static boolean arrayStringsAreEquals(String[] word1, String[] word2) {
    if(word1 == null || word2 == null) throw new IllegalArgumentException("");

    // to track outer and internal index of word1 array
    int wd1 = 0;
    int i = 0;

    // to track outer and internal index of word1 array
    int wd2 = 0;
    int j = 0;

    while(wd1 < word1.length && wd2 < word2.length) {   // *** &&
      while(i < word1[wd1].length() && j < word2[wd2].length()) {   // *** &&
        if(word1[wd1].charAt(i) != word2[wd2].charAt(j)) return false;
        i++;
        j++;
      }

      if(i == word1[wd1].length()) {  // we increase wd1 or wd2 conditionally... not always.
        i=0;                          // when both reach to end, outer while will be broken.
        wd1++;
      }
      if(j == word2[wd2].length()) {
        j=0;
        wd2++;
      }
    }

    return wd1 == word1.length && wd2 == word2.length; // or return true?
  }
}
