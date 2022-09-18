package one.bestgo.problems.array;

import java.util.*;

/**
 * Given an array of integers, find a sub array whose sum of elements are biggest.
 */
public class MaxSubArrayTest {

  /////////////////////////
  // 1) Input
  // {-2, 1, -3, 4, -1, 2, 1, -5, 4}
  //
  // 2) Expected Output
  // start index: 3, end index: 6
  // Max sum: 6
  // [4, -1, 2, 1]
  ////////////////////////

  public static void main(String[] args) {
    int[] testArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(Arrays.toString(solution(testArray)));
  }

  private static int[] solution(final int[] testArray) {
    int[] maxSubArray = null;
    int start;
    int end;
    int max;

    System.out.println("start index: "+start+", end index: "+end);
    System.out.println("Max sum: " + max);
    return maxSubArray;
  }
}
