package one.bestgo.sorting;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

public class QuickSortKim {
  public static void main(String[] args) {
    int size = 50000;
    int[] a = new int[size];
    for(int i=0; i<size; i++) {
      a[i] = (int)(Math.random()*10000);
    }

    //long start = System.currentTimeMillis();
    // OR use Instant.now() and Duration.between()
    Instant start = Instant.now();
    quickSort(a, 0, a.length-1);
    Instant end = Instant.now();

    long duration = Duration.between(start, end).toMillis();
    System.out.println("Took "+duration+"ms");
    System.out.println(Arrays.toString(a));
  }

  private static void quickSort(int[] a, int begin, int end) {
    if(begin < end) {   // *** not while but if
      int pix = partition(a, begin, end);
      quickSort(a, begin, pix - 1);
      quickSort(a, pix + 1, end);
    }
  }

  private static int partition(int[] a, int begin, int end) {
    int pivot = a[end];
    int i = (begin-1);  // small index

    for(int j=begin; j<end; j++) {
      if(a[j] < pivot) {
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i+1, end);
    return i+1;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
