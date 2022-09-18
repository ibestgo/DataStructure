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

// MatchingBracketTest.js
class MatchingBracketTest {
  // Here is the EXPECTED OUTPUT.
  /////////////////////////
  // Balanced
  // Not Balanced: 4
  // Balanced
  // Not Balanced: 10
  // Not Balanced: 1
  // Not Balanced: 4
  ////////////////////////
  solution() {
    const inputArray = ["(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"]
    inputArray.forEach(one => {
      console.log(this.balanced(one))
    })
  }

  balanced(str) {
    let retStr = "Balanced"
    // your solution starts here

    return retStr
  }
}

module.exports = MatchingBracketTest
// end of module definition

// Run the solution.
const MatchinghBracketTest = require(__filename)
const challenge = new MatchingBracketTest()
challenge.solution()