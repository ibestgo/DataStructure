package one.bestgo.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
  public static void main(String[] args) {
  }
  // Passed
  public void nextPermutation(int[] nums) {
    if(nums.length == 1) return;

    // now at least 2 in length
    boolean isMax = true;
    for(int i=nums.length-1; i>=1; i--) {
      if(nums[i-1] < nums[i]) {
        isMax = false;
        int t = nums[i-1];

        int k = nums.length-1;  // index of next great value
        for(int j=i; j<nums.length; j++) {  // already reverse sorted
          if(t >= nums[j]) {
            k = j-1;
            break;
          }
        }
        swap(nums, i-1, k);
        reverse(nums, i, nums.length-1);
        break;  // *** Don't forget this.
      }
    }

    if(isMax) Arrays.sort(nums);
  }

  private void reverse(int[] nums, int x, int y) {
    int m = (y-x+1)/2 -1;
    for(int i=x; i<=x+m; i++) {
      swap(nums, i, y-(i-x));
    }
  }

  private void swap(int[] nums, int x, int y) {
    int t = nums[y];
    nums[y] = nums[x];
    nums[x] = t;
  }
}
