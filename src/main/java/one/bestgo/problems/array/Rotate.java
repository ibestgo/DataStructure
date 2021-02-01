package one.bestgo.problems.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Rotate {
  public static void main(String[] args) {
    //int[][] a = {{1,2}, {3,4}};
    int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};

    for(int[] r: rotateBetter(a)) {
      System.out.println(Arrays.toString(r));
    }

    /*
    ArrayList<ArrayList<Integer>> b = new ArrayList<>();
    ArrayList<Integer> row1 = new ArrayList<>() {
      {
        add(1);
        add(2);
      }
    };
    b.add(row1);

    ArrayList<Integer> row2 = new ArrayList<>() {
      {
        add(3);
        add(4);
      }
    };
    b.add(row2);

    System.out.println(b);
    rotateV2(b);
    System.out.println(b);
    */
  }

  // rotate 90 degrees. not efficient due to lots of memory usage
  private static int[][] rotate(int[][] a) {
    int n = a.length;
    int[][] ret = new int[n][n];

    for(int r=0; r<n; r++)
      for(int c=0; c<n; c++)
        ret[c][n-1-r] = a[r][c];

    return ret;
  }

  // w/o using much memory
  // 90 rotation: (r,c) -> (c, n-1-r)
  private static int[][] rotateBetter(int[][] a) {
    int n = a.length;
    int[] temp = new int[4];

    for(int r=0; r<n/2; r++) {
      for(int c=r; c<n-1; c++) {
        temp[0] = a[r][c];    // 4 corners
        temp[1] = a[c][n-1-r];
        temp[2] = a[n-1-r][n-1-c];
        temp[3] = a[n-1-c][r];

        a[r][c] = temp[3];
        a[c][n-1-r] = temp[0];
        a[n-1-r][n-1-c] = temp[1];
        a[n-1-c][r] = temp[2];
      }
    }

    return a;
  }

  // worked but bad implementation
  private static void rotateV2(ArrayList<ArrayList<Integer>> a) {
    int n = a.size();
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    for(int i=0; i<n; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      ret.add(row);
      for(int j=0; j<n; j++)  // initialize needed as we will use set() not in order.
        row.add(-1);
    }

    for(int r=0; r<n; r++) {
      ArrayList<Integer> rlist = a.get(r);
      for (int c = 0; c < n; c++) {
        int src = rlist.get(c);
        ret.get(c).set(n - 1 - r, src);
      }
    }

    for(int r=0; r<n; r++) {
      ArrayList<Integer> src = ret.get(r);
      ArrayList<Integer> tar = a.get(r);
      tar.clear();
      for(Integer ele : src)
        tar.add(ele);
    }
  }
}
