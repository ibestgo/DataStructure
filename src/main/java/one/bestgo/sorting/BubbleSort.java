package one.bestgo.sorting;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a = {3,4,1,5,2,3,0};
    bubbleSort(a);
    System.out.println(Arrays.toString(a));
  }

  // O(N^2)
  private static void bubbleSort(int[] a) {
    for(int i=0; i<a.length; i++) {
      for(int j=0; j<a.length-1-i; j++) {
        if(a[j] > a[j+1]) swap(a, j, j+1);
      }
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
