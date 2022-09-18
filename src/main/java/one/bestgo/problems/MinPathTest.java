package one.bestgo.problems;

/*
Starting from top-left to bottom-right, you can go to either down or right. What's the sum of the minimum path?

2 | 3 | 4
4 | 5 | 1
9 | 6 | 1
 */
public class MinPathTest {
  public static void main(String[] args) {
    int[][] data = null;

    int result = findMinPath(data, 0, 0);
    System.out.println("Sum of MinPath (V1): "+result);
  }

  private static int findMinPath(int[][] data, int r, int c) {
    return 0;
  }
}
