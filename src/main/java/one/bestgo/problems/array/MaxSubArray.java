package one.bestgo.problems.array;

public class MaxSubArray {

  public static void main(String[] args) {
    int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //int[] A = {9, -1};
    System.out.println("Max subarray sum: "+maxSubArrayV2(A));
  }

  // mine
  public static int maxSubArray(final int[] A) {
    int max = Integer.MIN_VALUE;
    for(int s=0; s<A.length; s++) {
      int tm = A[s];
      if(tm > max) max = tm;    // #1. Make sure this line!
      for(int e=s+1; e<A.length; e++) {
        tm += A[e];
        if(tm > max) max = tm;
      }
    }
    return max;
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
