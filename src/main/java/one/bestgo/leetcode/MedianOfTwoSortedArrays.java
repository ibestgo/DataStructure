package one.bestgo.leetcode;

import java.util.*;

// https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {

  }

  // Baechul's
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    if(len1 == 0 && len2 == 0) return (double)0;
    if(len1 == 0 && len2 == 1) return (double)nums2[0];
    if(len1 == 1 && len2 == 0) return (double)nums1[0];

    int[] ret = new int[len1 + len2];   // now ret.length at least 2
    int i=0, j=0, k=0;

    while(i < len1 && j < len2) {
      if(nums1[i] <= nums2[j]) {
        ret[k++] = nums1[i++];
      } else {
        ret[k++] = nums2[j++];
      }
    }

    if(i == len1 && j < len2) { // copy remaining nums2
      for(int l=j; l<len2; l++) ret[k++] = nums2[l];
    }

    if(i < len1 && j == len2) { // copy remaining nums1
      for(int l=i; l<nums1.length; l++) ret[k++] = nums1[l];
    }

    int m = ret.length/2;
    return (ret.length % 2 == 0)? (ret[m-1]+ret[m])/2.0 : ret[m];
  }
}
