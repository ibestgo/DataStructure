package one.bestgo.leetcode;

import java.util.ArrayDeque;

// https://leetcode.com/problems/palindrome-number/
public class PalindromNumber {

  public static void main(String[] args) {
  }

  // Better than official
  // Time:  O(log10(n)). We divided the input by 10 for every iteration, so the time complexity is O(log10(n))
  public boolean isPalindromeKim2(int x) {
    // all corner cases for faster result
    if(x < 0 || (x % 10 == 0 && x != 0)) return false;
    if(x >= 0 && x < 10) return true;

    // now all positive at least 2 digits
    int reversed = 0;
    while (x > reversed) {
      int r = x%10;
      // no need to check the MAX cases because we just half reverse
      //if(reversed > (Integer.MAX_VALUE/10-r)) return false;
      reversed = reversed*10 + r;
      x = x/10;
    }
    return (x == reversed || x == (reversed/10));
  }

  // Official
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

  // Kim: Works
  public boolean isPalindromeKim1(int x) {
    if(x < 0 || (x % 10 == 0 && x != 0)) return false;
    if(x >= 0 && x < 10) return true;

    // now all positive at least 2 digits
    int orgX = x;
    int reversed = 0;
    while (x > 0) {
      int r = x%10;
      // check if the following could over the max integer
      if(reversed + (r/10) > Integer.MAX_VALUE/10) return false;
      reversed = reversed*10 + r;
      x = x/10;
    }
    return orgX == reversed;
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
