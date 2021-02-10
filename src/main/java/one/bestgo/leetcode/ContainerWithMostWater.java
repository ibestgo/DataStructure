package one.bestgo.leetcode;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

  // Passed
  public int maxArea(int[] height) {
    int l = 0;
    int r = height.length-1;
    int max = 0;

    while(l < r) {
      int cap = (r-l) * Math.min(height[l], height[r]);
      if(cap > max) {
        max = cap;
      }

      if(height[l] <= height[r])
        l++;
      else
        r--;
    }
    return max;
  }
}
