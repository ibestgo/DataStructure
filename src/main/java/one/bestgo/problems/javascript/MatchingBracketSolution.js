// Solution 1
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
    const inputArray =
      [
        "(a)c",
        "(a)c{12",
        "[()]{}{[()()]()}",
        "[()]{}{[(){()]()}",
        "[(as]i)said",
        "[]()}"
      ];
    inputArray.forEach(one => {
      console.log(this.balanced(one))
    });
  }

  balanced(str) {
    let retStr = "Balanced"
    // your solution starts here
    const stack = [];
    let indexesInCheck = [];
    const chars = str.split("");
    let misMatch = false;

    chars.forEach((char, index) => {
      if(stack.length === 0 && (char === ")" || char === "}" || char === "]") && (index === chars.length - 1)) {
        retStr = `Not Balanced: ${index}`;
        return;
      }
      if(char === "(" || char === "{" || char === "[") {
        stack.push(char);
        indexesInCheck.push(index);
      } else {
        switch(stack[stack.length - 1]) {
          case "(":
            if(char === ")") {
              stack.pop();
              indexesInCheck.pop();
            } else if(char === "]" || char === "}") {
              retStr = `Not Balanced: ${indexesInCheck[indexesInCheck.length - 1]}`;
              misMatch = true;
            }
            break;
          case "[":
            if(char === "]") {
              stack.pop();
              indexesInCheck.pop();
            } else if(char === ")" || char === "}") {
              retStr = `Not Balanced: ${indexesInCheck[indexesInCheck.length - 1]}`;
              misMatch = true;
            }
            break;
          case "{":
            if(char === "}") {
              stack.pop();
              indexesInCheck.pop();
            } else if(char === ")" || char === "]") {
              retStr = `Not Balanced: ${indexesInCheck[indexesInCheck.length - 1]}`;
              misMatch = true;
            }
            break;
          default:
            break;
        }
      }
    });

    if(stack.length !== 0 && !misMatch) {
      retStr = `Not Balanced: ${indexesInCheck[indexesInCheck.length - 1]}`;
    }

    return retStr;
  }
}
module.exports = MatchingBracketTest
// end of module definition

// Run the solution.
const MatchinghBracketTest = require(__filename)
const challenge = new MatchinghBracketTest()
challenge.solution()