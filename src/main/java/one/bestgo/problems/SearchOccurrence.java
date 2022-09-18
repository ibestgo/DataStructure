package one.bestgo.problems;

import java.util.Arrays;

public class SearchOccurrence {
  public static void main(String[] args) {
    // a is sorted
    int[] a = {1,3,3,4,5,5,5,6,7,7,9};

    int target = 5;
    int num = searchOccurrence(a, target, 0, a.length-1);
    System.out.println(target+" appeared "+ num+" times in "+ Arrays.toString(a));
  }

  // O(N) due to the last statement (worst case is when all are same)
  private static int searchOccurrence(int[] a, int k, int start, int end) {
    if(start > end) return 0;   // #1: NOT >=. Even if start and end same, below has to run.
    int mid = (start+end)/2;

    if(k < a[mid]) return searchOccurrence(a, k, start, mid-1);
    if(k > a[mid]) return searchOccurrence(a, k, mid+1, end);

    // if k == a[mid]. Found (hence 1) but the same might happen in either side.
    return 1 + searchOccurrence(a, k, start, mid-1) + searchOccurrence(a, k, mid+1, end);
  }
}
