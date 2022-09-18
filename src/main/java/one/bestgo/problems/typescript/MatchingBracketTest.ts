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
 * Output: Unbalanced: 1
 *
 * Input: exp = “[]()}”
 * Output: Unbalanced: 4
 */

const inputArray: string[] = ["(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"]
interface Solution {
  (input: string[]): string
}

// Create mySolution, which is a type of Solution then execute it by passing the inputArray
// EXPECTED OUTPUT from the Solution
/////////////////////////
// Balanced
// Unbalanced: 4
// Balanced
// Unbalanced: 10
// Unbalanced: 1
// Unbalanced: 4
////////////////////////

const mySolution: Solution = (input: string[]) => {
  let retStr: string = ''

  input.forEach(one => {
    let str = 'Balanced'  // initial output

    // my solution here

    retStr += str+'\n'
  })
  return retStr
}
console.log(mySolution(inputArray))



//////
interface Test {
    solution(): void
}

class MatchingBracketTest {
    solution() {
        const inputArray: string[] = ["(a)c", "(a)c{12", "[()]{}{[()()]()}", "[()]{}{[(){()]()}", "[(as]i)said", "[]()}"]
        inputArray.forEach(one => {
            console.log(this.balanced(one))
        })
    }

    balanced(str: string): string {
        let retStr: string = "Balanced"

        return retStr
    }
}

const challenge: MatchingBracketTest = new MatchingBracketTest()
challenge.solution()