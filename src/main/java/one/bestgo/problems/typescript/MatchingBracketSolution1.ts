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

const getBadOpenInd = (openParen: number[], openCurly: number[], openSquare: number[], ind: number) => {
  if (openParen.length > 0 || openCurly.length > 0  || openSquare.length > 0) {
    const indices = [];
    if (openParen.length > 0) {
      indices.push(openParen[openParen.length - 1]);
    }
    if (openCurly.length > 0) {
      indices.push(openCurly[openCurly.length - 1]);
    }
    if (openSquare.length > 0) {
      indices.push(openSquare[openSquare.length - 1]);
    }
    return Math.max(...indices);
  }
  return ind;
}

const getUnbalancedDescription = (input: string) => {
  let openParen: number[] = [];
  let openCurly: number[] = [];
  let openSquare: number[] = [];
  let openingChars: string[] = [];

  for (let i=0; i<input.length; i++) {
    const char = input[i];

    switch (char) {
      case '(':
        openingChars.push(char);
        openParen.push(i);
        break;

      case '{':
        openingChars.push(char);
        openCurly.push(i);
        break;

      case '[':
        openingChars.push(char);
        openSquare.push(i);
        break;

      case ')':
        if (openParen.length < 1 || openingChars[openingChars.length - 1] !== '(') {
          return `Unbalanced ${getBadOpenInd(openParen, openCurly, openSquare, i)}`;
        }

        openingChars.pop();
        openParen.pop();
        break;

      case '}':
        if (openCurly.length < 1 || openingChars[openingChars.length - 1] !== '{') {
          return `Unbalanced ${getBadOpenInd(openParen, openCurly, openSquare, i)}`;
        }
        openingChars.pop();
        openCurly.pop();
        break;

      case ']':
        if (openSquare.length < 1 || openingChars[openingChars.length - 1] !== '[') {
          return `Unbalanced ${getBadOpenInd(openParen, openCurly, openSquare, i)}`;
        }
        openingChars.pop();
        openSquare.pop();
        break;
    }
  }

  if (openParen.length > 0 || openCurly.length > 0  || openSquare.length > 0) {
    const indices = [];
    if (openParen.length > 0) {
      indices.push(openParen[openParen.length - 1]);
    }
    if (openCurly.length > 0) {
      indices.push(openCurly[openCurly.length - 1]);
    }
    if (openSquare.length > 0) {
      indices.push(openSquare[openSquare.length - 1]);
    }
    return `Unbalanced ${Math.min(...indices)}`;
  }

  return 'Balanced';
}

const mySolution: Solution = (input: string[]) => {
  return input.map(str => getUnbalancedDescription(str)).join('\n');
}

console.log(mySolution(inputArray))
