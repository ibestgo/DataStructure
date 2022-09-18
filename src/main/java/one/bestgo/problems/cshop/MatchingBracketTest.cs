using System;

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
    public static void Main(string[] args) {
        string[] strs = {"(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"};

        for (int i=0; i< strs.Length; i++) {
            Console.WriteLine(balanced(strs[i]));
        }
    }

    private static string balanced(string str) {
        String retStr = "";
        // your solution starts here

        return retStr;
    }
}
