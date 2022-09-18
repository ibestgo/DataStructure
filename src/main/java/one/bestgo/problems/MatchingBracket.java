package one.bestgo.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * Given an expression string exp, write a program to examine whether the pairs and the orders of
 * “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 *
 * Input: exp = “[()]{}{[()()]()}”
 * Output: Balanced
 *
 * Input: exp = “[(])”
 * Output: Not Balanced
 */
public class MatchingBracket {
  public static void main(String[] args) {
    String[] strs = {"(a)c", "[()]{}{[()()]()}", "[(as]s)ertdf"};

    for(String str: strs) {
      System.out.println(balanced(str));
    }
  }

  private static String balanced(String str) {
    Deque<Character> stack = new ArrayDeque<>();
    for(char ch: str.toCharArray()) {
      switch (ch) {
        case '[':
        case '(':
        case '{':
          stack.push(ch);
          break;
        case ']':
          if(stack.isEmpty() || stack.pop() != '[') return "Not Balanced";
          break;
        case ')':
          if(stack.isEmpty() || stack.pop() != '(') return "Not Balanced";
          break;
        case '}':
          if(stack.isEmpty() || stack.pop() != '{') return "Not Balanced";
          break;
      }
    }
    return "Balanced";
  }
}
