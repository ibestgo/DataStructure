package one.bestgo.sorting;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    //int[] a = { 13, 12, 13, 7};
    //int[] a = { 6, 5, 9, 10, 13, 20, 15, 2, 1, 0, 13};
    int size = 5;
    int[] a = new int[size];
    for(int i=0; i<size; i++) {
      a[i] = (int)(Math.random()*1000);
    }

    System.out.println(Arrays.toString(a));
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void sort(int[] a) {
    quickSort(a, 0, a.length-1);
  }

  private static void quickSort(int[] a, int begin, int end) {
    if(begin < end) {
      int pix = partition1(a, begin, end);
      quickSort(a, begin, pix-1);   // NOT quickSort(a, begin, pix);
      quickSort(a, pix+1, end);
    }
  }

  // https://www.geeksforgeeks.org/quick-sort/
  // this impl picks the last as a pivot but other imple could pick the first or any other.
  private static int partition1(int a[], int begin, int end) {
    int pivot = a[end];
    int i = (begin-1); // index of smaller element
    for (int j=begin; j<end; j++) {   // *** loop from begin to end-1. end is pivot
      // If current element is smaller than the pivot
      if (a[j] < pivot) { // 3,7,5
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i+1, end);  // swap arr[i+1] and arr[high] (or pivot)
    return i+1;
  }

  // TODO: Need to fix
  private static int partition(int[] a, int begin, int end) {
    int left=begin, right=end;  // index
    int pivot = a[begin];       // value: first value will be picked as a pivot

    while(true) {
      // Didn't Work for { 13, 12, 13, 7, 5, 1 } where 13 appears twice.
      // a[left], a[right] and pivot all 13!!!
//      while (a[left] < pivot && a[left] != pivot) left++;
//      while (pivot < a[right] && pivot != a[right]) right--;
      while (a[left] < pivot && left != right) left++;
      while (pivot <= a[right] && left != right) right--; // [0, 1, 2, 5, 20, 6, 9, 10, 13, 15]
      //while (pivot < a[right] && left != right) right--;  // [0, 1, 2, 5, 6, 9, 10, 13, 15, 20]

      if (left == right) {
        return left;
      } else {
        swap(a, left, right);
      }
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
