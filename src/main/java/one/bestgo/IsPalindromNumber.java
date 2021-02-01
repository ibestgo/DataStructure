package one.bestgo;

import java.util.ArrayDeque;

// Official: best solution
public class IsPalindromNumber {
  public boolean isPalindrome(int x) {
    if(x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while(x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    return x == revertedNumber || x == revertedNumber/10;

  }

  public boolean isPalindrome2(int x) {
    if(x < 0) return false;
    String str = String.valueOf(x);
    int len = str.length();
    int m = len/2;

    for(int i=0; i<m; i++) {
      if(str.charAt(i) != str.charAt(len-i-1)) return false;
    }

    return true;
  }

  public boolean isPalindrome1(int x) {
    if(x < 0) return false;

    String str = String.valueOf(x);
    ArrayDeque<Character> stack = new ArrayDeque<>();

    for(int i=0; i<str.length(); i++) {
      stack.push(str.charAt(i));
    }

    for(int i=0; i<str.length(); i++) {
      char ch = stack.pop();
      if(str.charAt(i) != ch) return false;
    }

    return true;
  }

}
