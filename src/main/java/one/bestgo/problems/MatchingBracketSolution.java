package one.bestgo.problems;

import java.util.*;

public class MatchingBracketSolution {

  // solution from Natalia
  // close enough but not passed all.
  // failed for "[()]{}{[(){()]()}" - expected "Not Balanced: 10" but printed "Not Balanced: 11"
  public static int balanced(String str) {
    if (str==null || str.equals("")) return -1;
    String inputParantesses = "[{<(";
    String outputParantesses = "]}>)";

    int index = 0;

    LinkedList<Character> stack = new LinkedList<>();

    for (int i=0; i< str.length(); i++){
      if (inputParantesses.contains(""+ str.charAt(i))) {
        char tmp = outputParantesses.charAt(inputParantesses.indexOf(str.charAt(i)));
        stack.push(tmp);
        index = i;
      } else if (outputParantesses.contains(""+ str.charAt(i))) {
        if (stack.size() == 0 ) {
          return i;
        }
        char t = stack.pop();
        if (t != str.charAt(i)) {
          return index;
        }
        continue;
      }
    }
    if (stack.size()!=0) return index;
    return -1;
  }
}
