package one.bestgo.sorting;

import java.util.Arrays;

public class HeapSortKim {
  public static void main(String[] args) {
    int size = 10;
    int[] a = new int[size];
    for(int i=0; i<size; i++) {
      a[i] = (int)(Math.random()*100);
    }

    System.out.println(Arrays.toString(a));
    heapSort(a);
    System.out.println(Arrays.toString(a));
  }

  // TODO: Some Failed
  private static void heapSort(int[] a) {
    int len = a.length;
    while(len > 1) {
      heapify(a, len, 0);
      swap(a, 0, len-1);
      len--;
    }
  }

  private static void heapify(int[] a, int len, int parent) {
    if(parent*2+2 >= len) return;

    int left = parent*2+1;
    int right = parent*2+2;

    if(a[left] > a[parent]) swap(a, parent, left);
    if(a[right] > a[parent]) swap(a, parent, right);
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
