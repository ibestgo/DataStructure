package one.bestgo.sorting;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] a = {3,6,1,8,4,5};
    selctionSort(a);
    System.out.println(Arrays.toString(a));
  }

  private static void selctionSort(int[] a) {
    for(int i=0; i<a.length; i++) {
      int smallest = a[i];
      int six = i;
      for(int j=i+1; j<a.length; j++) {
        if(a[j] < smallest) six = j;
      }
      swap(a, i, six);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
