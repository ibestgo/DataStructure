package one.bestgo.datastructure.string;

/*
  Given two strings s and t, return the minimum window in s which will contain all the characters in t.
  If there is no such window in s that covers all characters in t, return the empty string "".
  Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

  Given a string as a "source" string, find the smallest substring of source such that it contains all characters
  in "search" string (which contains distinct characters).
  For example, for search string ['a','b','c'], source string "aefbcgaxy", the shortest string is "bcga".
 */
public class FaceBookTest {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";

//    System.out.println(">"+s.substring(0,0)+"<"); // returned empty

    System.out.println(minWindow(s, t));
  }

  private static String minWindow(String s, String t) {
    char[] ss = s.toCharArray();
    char[] tt = t.toCharArray();
    int len = t.length();

    String rstr = "";
    int smallest = Integer.MAX_VALUE;

    for(int i=0; i<ss.length; i++) {
      for(int j=i+1; j<ss.length+1; j++) {   // *** from j=i+1 to j<ss.length+1
        String substr = s.substring(i, j);

        int count = 0;
        for(int k=0; k<tt.length; k++) {
          if(substr.indexOf(tt[k]) != -1)
            count++;  // *** CAN"T substr.contains(char). Valid is contains(str)
        }
        if(count == len) {  // found. check if it is smallest
          if(substr.length() < smallest) {
            smallest = substr.length();
            rstr = substr;
          }
        }
      }
    }
    return rstr;
  }
}
