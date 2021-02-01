package one.bestgo;

public class LongestPalindromicSubstring {

  // Official
  public String longestPalindrome(String str) {
    int len = str.length();
    if(len == 1) return str;

    int max = 0;
    int me=0, ms=0;

    for(int i=0; i<len; i++) {
      int length1 = expandAroundCenter(str, i, i);
      int length2 = expandAroundCenter(str, i, i+1);
      int length = Math.max(length1, length2);
      if(length > max) {
        max = length;
        ms = i - (length-1)/2;
        me = i + length/2;
      }
    }

    return str.substring(ms, me+1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  // FAILED with time limit
  public String longestPalindromeFAILED(String str) {
    int len = str.length();
    if(len == 1) return str;

    int max = 0;
    //int e=0, s=0;
    int me=0, ms=0;

    for(int e=0; e<len; e++) {
      System.out.println("A : "+e);
      if(doesMatch(str, 0, e)) {
        System.out.println("A > "+str.substring(0, e+1));
        if(e+1 > max) {
          max = e+1;
          ms = 0;
          me = e;
        }
      }

      for(int s=0; s<e; s++) {
        System.out.println("B : "+s+","+e);
        if(doesMatch(str, s, e)) {
          System.out.println("B > "+str.substring(s, e+1));
          if(e-s+1 > max) {
            max = e-s+1;
            ms = s;
            me = e;
          }
          break;
        }
      }
    }

    return str.substring(ms, me+1);
  }

  private boolean doesMatch(String str, int s, int e) {
    if(s == e) return true;

    int len = e-s+1;
    int m = len/2;
    for(int i=s; i<s+m; i++) {
      if(str.charAt(i) != str.charAt(s+e-i)) return false;
    }
    return true;
  }

}
