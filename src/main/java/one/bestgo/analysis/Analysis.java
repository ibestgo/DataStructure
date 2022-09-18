package one.bestgo.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analysis {
  public static void main(String[] args) {
    int[] a = {1,3,9,4,5,2,3,9,10,3, 9};
    System.out.println("mode\t" + mode(a));
    System.out.println("mean\t" + mean(a));

    int[] b = {1, 3, 6, 7, 25, 34, 35, 50};
    System.out.println("median\t" + median(b));
  }

  private static double mean(int[] a) {
    if(a.length == 0) throw new IllegalArgumentException();

    double sum = 0;
    for(int one : a) sum += one;
    return sum/a.length;
  }

  private static double median(int[] a) {
    // assume it is sorted.
    int m = a.length/2;

    if(a.length%2 == 1) { // odd
      return a[m];
    } else {              // even
      return (a[m-1]+a[m])/2;
    }
  }

  // Mode: The value that appears most frequently in a data set
  private static Set<Integer> mode(int[] a) {
    if(a.length == 0) return null;
    //List<Integer> mode = new ArrayList<>();
    Set<Integer> mode = new HashSet<>();    // Set can shrink all the same as one.
    int maxCount = 0;

    for(int i=0; i<a.length; i++) {
      int count = 0;
      for(int j=0; j<a.length; j++) {
        if(a[i] == a[j]) count++;
      }

      if(count == maxCount) {
        mode.add(a[i]);
      } else if(count > maxCount) {
        maxCount = count;
        mode.clear();
        mode.add(a[i]);
      }
    }
    return mode;
  }
}
