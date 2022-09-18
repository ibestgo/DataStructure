package one.bestgo.search.binary;

import one.bestgo.sorting.QuickSort;

public class BinarySerachTest {
  public static void main(String[] args) {
    int size = 50;
    int[] a = new int[size];
    for(int i=0; i<size; i++) {
      a[i] = (int)(Math.random()*50);
    }
    QuickSort.sort(a);

    System.out.println(search(a, a[25]));
    System.out.println(search(a, 51));
  }

  private static int search(int[] a, int target) {
    return binarySearch(a, 0, a.length-1, target);
  }

  private static int binarySearch(int[] a, int begin, int end, int target) {
    if(begin > end) return -1;

    int m = (begin+end)/2;

    if(target == a[m]) return target;
    if(target < a[m])
      return binarySearch(a, begin, m-1, target);
    else
      return binarySearch(a, m+1, end, target);

  }

}
