package one.bestgo.problems;

// Starting from top-left to bottom-right, you can go to either down or right. What's the sum of the minimum path?
public class MinPathTest {
  public static void main(String[] args) {
    int[][] a = {
        {2, 3, 4},
        {4, 5, 1},
        {9, 6, 1}
    };

    int result = findMinPath(a, 0, 0);
    System.out.println("Sum of MinPath (V1): "+result);

    int[][] memo = new int[a.length][a[0].length];
    result = findMinPathV2(a, memo, 0, 0);
    System.out.println("Sum of MinPath (V2): "+result);
  }
  // O(R*C): Better version by using a mem cache
  private static int findMinPathV2(int[][] a, int[][] memo, int r, int c) {
    int rows = a.length;
    int cols = a[0].length;
    // corner cases:
    // edge elements. So in min(other, MAX_VALUE), other can be selected
    if(r >= rows || c >= cols) return Integer.MAX_VALUE;

    // last element (bottom-right)
    if(r == rows-1 && c == cols-1) return a[r][c];

    // all others
    if(memo[r][c] != 0) return memo[r][c];  // default int value is 0.
    else {
      memo[r][c] = a[r][c] + Math.min(findMinPath(a, r + 1, c), findMinPath(a, r, c + 1));
      return memo[r][c];
    }
  }

  // O(2^(R+C))
  private static int findMinPath(int[][] a, int r, int c) {
    int rows = a.length;
    int cols = a[0].length;
    // corner cases:
    // edge elements. So in min(other, MAX_VALUE), other can be selected
    if(r >= rows || c >= cols) return Integer.MAX_VALUE;

    // last element (bottom-right)
    if(r == rows-1 && c == cols-1) return a[r][c];

    return a[r][c] + Math.min(findMinPath(a, r+1, c), findMinPath(a, r, c+1));
  }

}
