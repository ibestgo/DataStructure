package one.bestgo.sorting;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] a = { 13, 12, 13, 7, 5, 0 };
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  private static void sort(int[] a) {
    mergeSort(a, 0, a.length-1);
  }

  private static void mergeSort(int[] a, int begin, int end) {
    if(begin == end) return;

    int m = (end+begin)/2;
    mergeSort(a, begin, m);
    mergeSort(a, m+1, end);
    merge(a, begin, m, end);
  }

  // when end=begin+1, i.e one element is already sorted.
  private static void merge(int[] a, int begin, int m, int end) {
    int[] la = new int[m-begin+1];  // begin...m
    int[] ra = new int[end-m];      // m+1..end

    // copy 2 data sections to the temp arrays.
    for(int i=0; i<la.length; i++) la[i] = a[begin+i];
    for(int i=0; i<ra.length; i++) ra[i] = a[m+1+i];

    // merge la/ra then copy back to a
    int i=0, j=0, k=begin;
    while(i<la.length && j<ra.length) {
      if(la[i] <= ra[j]) {
        a[k++] = la[i++];
      } else {
        a[k++] = ra[j++];
      }
    }

    // copy any left over when the length of 2 arrays are different
    // only 1 while will be executed
    while(i<la.length) {
      a[k++] = la[i++];
    }
    while(j<ra.length) {
      a[k++] = ra[j++];
    }
  }
}
