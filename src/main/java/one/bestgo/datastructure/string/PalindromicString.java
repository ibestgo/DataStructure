package one.bestgo.datastructure.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromicString {
  public static void main(String[] args) {
    String[] strs = {"forgeeksskeegfor", "Geeks"};
    for(String str: strs) {
      System.out.println(str+": "+findLongestPalindromicString(str));
    }
  }

  private static List<String> findLongestPalindromicString(String str) {
    char[] cs = str.toCharArray();
    int max = 1;  // all single char has max palindromic size, 1
    List<String> list = new ArrayList<>();

    // all substrings between at i and j
    for(int i=0; i<cs.length; i++) {
      for(int j=i; j<cs.length; j++) {
        if(palindromic(cs, i, j)) { // then palindromic and returned the size.
          int len = (j-i)+1;
          if(len > max) {
            max = len;  // *** don't forget it!!!
            list.clear();
            list.add(str.substring(i, j+1));
          } else if(len == max) {
            list.add(str.substring(i, j+1));
          }
        }
      }
    }
    return list;
  }

  private static boolean palindromic(char[] cs, int start, int end) {
    int m = (start+end)/2;
    for(int i=start; i<=m; i++) {    // **** i<=m...... NOT i<m
      if(cs[i] != cs[end-(i-start)]) return false;
    }
    return true;
  }
}
