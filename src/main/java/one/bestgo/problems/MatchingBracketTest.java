package one.bestgo.problems;

import java.util.*;

/**
 * Given a string expression, write a program (balanced() method) to examine whether the pairs and the orders of
 * “{“, “}”, “(“, “)”, “[“, “]” are correct in exp (all other chars are ignored). If they are correct, it is balanced.
 * If balanced, just return "Balanced".
 * If not balanced, return "Not Balanced: <problem-index>", where problem-index is the index of the first bracket
 * that caused un-balancing.
 *
 * Examples:
 * Input: exp = “[()] {} { [()()] () }”
 * Output: Balanced
 *
 * Input: exp = “[(abc] x)”
 * Output: Not Balanced: 1
 *
 * Input: exp = “[]()}”
 * Output: Not Balanced: 4
 */

public class MatchingBracketTest {
  // Here is the EXPECTED OUTPUT.
  /////////////////////////
  // Balanced
  // Not Balanced: 4
  // Balanced
  // Not Balanced: 10
  // Not Balanced: 1
  // Not Balanced: 4
  ////////////////////////
  public static void main(String[] args) {
    String[] strs = {"(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"};

    for (String str : strs) {
      System.out.println(balanced(str));
    }
  }

  private static String balanced(String str) {
    String retStr = "Balanced";
    // your solution starts here

    return retStr;
  }
}

/*
package code;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMatchingBrackets {

  /////////////////////////
  // Balanced
  // Not Balanced: 4
  // Balanced
  // Not Balanced: 10
  // Not Balanced: 1
  // Not Balanced: 4
  ////////////////////////
  String[] strs = {"(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"};

	@Test()
	public void testCode() {
    MatchingBrackets mb = new MatchingBrackets();
    String retStr = mb.balanced(strs[0]);
    System.out.println("Out: "+retStr);

		Assert.assertNotNull(retStr);
	}

}
 */

// python
// (Python):
// strs = ["(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"]
// print(MatchingBracketTest().ifListBalanced(strs))

/*

class MatchingBracketTest:

    def ifListBalanced(self, lStrings):
        for strElm in lStrings:
            if not self.ifBalance(strElm):
                return False
        return True;

    def ifBalance(self, listElm):


strs = ["(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"]
print(MatchingBracketTest().ifListBalanced(strs))



 #* Given an expression string exp, write a program to examine whether the pairs and the orders of
 #* “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 #*
 #* Input: exp = “[()]{}{[()()]()}”
 #* Output: Balanced

 #* Input: exp = “[(])”
 #* Output: Not Balanced

 #  {"(a)c", "[()]{}{[()()]()}", "[(as]s)ertdf"}

class MatchingBracketTest:

    def __init__(self):
        pass
    def ifBalance(self, listElm):
        if not listElm:
            return True
        lMatch = [["(", ")"], ["[","]"], ["{","}"]]
        lQueue = []
        for elm in listElm:
            if elm in list(map(lambda x: x[0], lMatch)):
                lQueue.append(elm)
            if elm in list(map(lambda x: x[1], lMatch)):
                for i in lMatch:
                    if i[1]==elm:
                        if not lQueue:
                            return False
                        if lQueue.pop(len(lQueue)-1) !=i[0]:
                            return False
        if lQueue:
            return False
        return True


    def ifListBalanced(self, lStrings):
        for strElm in lStrings:
            if not self.ifBalance(strElm):
                return False
        return True;


print(MatchingBracketTest().ifListBalanced(["(a)c", "[()]{}{[()()]()}", "[(as]s)ertdf"]))
 */


/*  /// Working version: Good
import java.util.*;

public class MatchingBracketTest {
  static Map<String,String> symbolsMap;
  static{
    symbolsMap = new HashMap<>();
    symbolsMap.put("{","}");
    symbolsMap.put("[","]");
    symbolsMap.put("(",")");
  }
  public static void main(String[] args) {
    // Balanced, Balanced, Not Balanced: 1, Not Balanced: 4
    String[] strs = {"(a)c", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"};

    for (String str : strs) {
      System.out.println(balanced(str));
    }
  }

  private static String balanced(String str) {
    String retStr = "";
    // your solution starts here


    List<String> expectedSymbol = new ArrayList<>();
    List<Integer> symbolLocation = new ArrayList<>();
    int index = -1;

    char[] chararray = str.toCharArray();
    // int expectedIndex =-1;
    int i =0;
    for(;i<chararray.length;i++){
      String symbox = chararray[i]+"";
      if(symbolsMap.containsKey(symbox)){
        expectedSymbol.add(symbolsMap.get(symbox));
        symbolLocation.add(i);
      }else  if(symbolsMap.containsValue(symbox)){
        if(expectedSymbol.size()>0){
          if(!symbox.equals(expectedSymbol.get(expectedSymbol.size()-1))){
            return "Not Balanced: "+symbolLocation.get(symbolLocation.size()-1);
          }
          else{
            // expectedIndex=-1;
            expectedSymbol.remove(expectedSymbol.size()-1);
            symbolLocation.remove(symbolLocation.size()-1);
          }
        }else{

          return "Not Balanced: "+i;
        }
      }
    }
    retStr = "Balanced";
    return retStr;
  }
}
 */

