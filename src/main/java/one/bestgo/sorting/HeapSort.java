package one.bestgo.sorting;

import java.util.Arrays;

public class HeapSort {
  public static void main(String[] args) {
    //int[] a = { 12, 11, 13, 5, 6, 7 };
    int[] a = { 13, 12, 13, 7, 5, 0 };

    heapSort(a);
    System.out.println(Arrays.toString(a));
  }

  // Time : O(NLogN). Unlike quicksort, no worst-case O(n^2) complexity. In practice Quicksort is faster
  // Space: O(1)
  public static void heapSort(int[] a) {
    int len = a.length;
    while(len > 1) {
      heapify(a, len, 0);   // build max heap.
      swap(a, 0, len-1);      // swap the first(max value) to the last of unsorted
      len--;
    }

//    WRONG!!!
//    for(int i=0; i< a.length-i; i++) {
//      heapify(a, i);
//      swap(a, i, a.length-1-i);
//      System.out.println(i+") "+Arrays.toString(a));
//    }
  }

  private static void heapify(int[] a, int len, int parent) {
    if(parent*2+2 >= len) return;

    int left = parent*2 + 1;
    int right = parent*2 + 2;

    if(a[left] > a[parent]) {
      swap(a, left, parent);
    }

    if(a[right] > a[parent]) {
      swap(a, right, parent);
    }

    heapify(a, len, left);
    heapify(a, len, right);
  }

  private static void swap(int[] a, int i, int j) {
    if(i == j) return;
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
