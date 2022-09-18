package one.bestgo.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    //new LongestSubstringWithoutRepeatingCharacters().test("abcabcbb");
  }

  public int lengthOfLongestSubstring(String s) {
    int len = s.length();
    if(len < 2) return len;     // would be better

    int max = 0;                // Now at least 2
    int b = 0;
    for(int e = 1; e < len; e++) {
      for(int j=b; j<e; j++) {
        if(s.charAt(j) == s.charAt(e)) {
          b = j+1;
          break;
        }
      }
      max = Math.max(max, e-b+1);
    }

//         while(b < e && e < len) {
//             for(int i=b; i<e; i++) {
//                 if(s.charAt(i) == s.charAt(e)) {
//                     b = i+1;
//                     break;
//                 }
//             }

//             // System.out.println(s.substring(b, e+1)); // note e+1
//             //int l = e-b+1;            // OK but use Math.max() for simple
//             //if(l > max) max = l;
//             max = Math.max(max, e-b+1);
//             e++;
//         }

    return max;
  }

  // Official Solution: Best Solution
  // Time: O(n)
  public int lengthOfLongestSubstringOfficial(String str) {
    int len = str.length();
    int max = 0;
    int[] index = new int[128];

    for(int e=0, s=0; e<len; e++) {
      s = Math.max(s, index[str.charAt(e)]);
      index[str.charAt(e)] = e+1;
      max = Math.max(max, e-s+1);
    }

    return max;
  }


  // Official Solution
  // time: O(2n)
  // space: mainly due to Set. it can hold max 26. O(min(length of str, 26))
  public int lengthOfLongestSubstring2(String str) {
    if(str.length() < 2) return str.length();

    int max = 1;
    int len = str.length();
    int s = 0;
    int e = 0;
    Set<Character> set = new HashSet<>();

    while(s < len && e < len) {
      if(!set.contains(str.charAt(e))) {  // unique
        set.add(str.charAt(e++));
        max = Math.max(max, e-s);
      } else {
        set.remove(str.charAt(s++));
      }
    }
    return max;
  }


  // PASSED: Mine
  public int lengthOfLongestSubstringMine(String str) {
    if(str.length() < 2) return str.length();

    int max = 1;
    char[] a = str.toCharArray();
    int s = 0;
    int e = 0;
    int len = a.length;

    while(e < len-1) {  // if(e == len-1) break;
      //System.out.println("+1: "+s+","+e);
      while(e < len-1) {
        if(!isDup(a, s, e)) {
          max = Math.max(e-s+1, max);
          //int l= e-s+1;
          //if(l > max) max = l;
          e++;
        } else {
          break;
        }
      }
      //System.out.println("+2: "+s+","+e);

      while(s < len-1) {
        if(isDup(a, s, e)) {
          s++;
        } else {
          max = Math.max(e-s+1, max);
          //int l= e-s+1;
          //if(l > max) max = l;
          break;
        }

      }
      //System.out.println("+3: "+s+","+e);
    }

    return max;
  }

  private boolean isDup(char[] a, int s, int e) {
    for(int i=s; i<=e; i++) {
      if(i != s && a[s] == a[i]) return true;
      if(i != e && a[e] == a[i]) return true;
    }
    return false;
  }

  // Failed: Time limit for very long string.
  public int lengthOfLongestSubstringBAD(String s) {
    if(s.length() == 0) return 0;

    char[] a = s.toCharArray();
    int max = Integer.MIN_VALUE;

    for(int i=0; i<a.length; i++) {
      for(int j=0; j<a.length; j++) {
        int len = getUniqueLen(a, i, j);
        if(len != -1 && len > max) {
          max = len;
        }
      }
    }
    return max;
  }

  private int getUniqueLen(char[] a, int i, int j) {
    if(i == j) return 1;
    boolean repeated = false;
    for(int k=i; k<=j; k++) {
      for(int l=k+1; l<=j; l++) {
        if(a[k] == a[l]) {
          return -1;
        }
      }
    }
    return j-i+1;
  }

  //  public void test2(String s) {
//    int len = s.length();
//    int b = 0;  // begin index
//    int e = 0;  // end index
//    while (e < len) {  // end index
//      for(int j=b; j<e; j++) {    // whenever e is increased, search [b, e-1] for s[e]
//        if(s.charAt(j) == s.charAt(e)) {
//          b = j+1;
//          break;
//        }
//      }
//      System.out.println(s.substring(b, e+1));
//      e++;
//    }
//  }
//
//  public void test(String s) {
//    int len = s.length();
//    int b = 0;  // begin index
//
//    for(int e=0; e < len; e++) {  // end index
//      for(int j=b; j<e; j++) {    // whenever e is increased, search [b, e-1] for s[e]
//        if(s.charAt(j) == s.charAt(e)) {
//          b = j+1;
//          break;
//        }
//      }
//      System.out.println(s.substring(b, e+1));
//    }
//  }
}
