package one.bestgo.problems.array;

import java.util.Arrays;

public class MaxSubArray {

  public static void main(String[] args) {
    int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //int[] A = {9, -1}
    //
    // ;

    System.out.println(Arrays.toString(maxSubArray(A)));
    //System.out.println("Max subarray sum: "+maxSubArrayV2(A));
  }

  // mine
  public static int[] maxSubArray(final int[] A) {
    int start = 0;
    int end = 0;
    int max = Integer.MIN_VALUE;
    for(int s=0; s<A.length; s++) {
      int tm = A[s];
      if(tm > max) { max = tm; start=s; end=s; }    // #1. Make sure this line!
      for(int e=s+1; e<A.length; e++) {
        tm += A[e];
        if(tm > max) { max = tm; start=s; end=e; }
      }
    }

    System.out.println("start: "+start+" end: "+end);

    int[] maxSubArray = new int[end-start+1];
    System.arraycopy(A, start, maxSubArray, 0, end-start+1);

    return maxSubArray;
  }

  // other
  public static int maxSubArrayV2(final int[] arr) {
    int n = arr.length;
    int maxend = 0, maxsofar = Integer.MIN_VALUE;

    for(int i=0; i<n; i++){
      maxend = maxend + arr[i];
      if(maxend < arr[i]) maxend = arr[i];
      if(maxsofar < maxend) maxsofar = maxend;
    }
    return maxsofar;
  }
}
