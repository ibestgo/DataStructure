package one.bestgo.misc;

import java.util.Arrays;

public class ArrayTest {

  public static void main(String[] args) {
//    int[] nums = { 7, 5, 9, 3, 2, 1, 0, 4 };
//    new ArrayTest().reverse(nums, 2, 4);
//    System.out.println(Arrays.toString(nums));

    //int[] nums = { 7, 5, 9, 7, 6, 4, 2};  // should be 4
    int[] nums = { 7, 1, 9, 7, 6, 4, 2};    // should be 6
    System.out.println(new ArrayTest().findNextGreat(nums, 1));
  }

  public int findNextGreat(int[] nums, int x) {
    int v = nums[x];  // target.
    // find the index of the next great in the already reverse sorted array
    // from x+1 to end, ie.

    for(int i=x+1; i<nums.length; i++) {
      if(nums[i] <= v) {
        return --i;
      }
    }
    return nums.length-1;
  }

  ///////
  public void reverse(int[] nums, int x, int y) {
    int m = (y-x+1)/2 -1;
    for(int i=x; i<=x+m; i++) {
      swap(nums, i, y-(i-x));
    }
  }

  public void swap(int[] nums, int x, int y) {
    int t = nums[y];
    nums[y] = nums[x];
    nums[x] = t;
  }
}
