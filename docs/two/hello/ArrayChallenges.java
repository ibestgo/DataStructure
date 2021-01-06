package com.bestgo.hello;

import java.util.Scanner;

public class ArrayChallenges extends MyBase {

  public ArrayChallenges() {

  }

  // https://www.hackerrank.com/challenges/crush/problem

  public long arrayManipulationCrazy(Scanner in) {
    return 1;
  }

  // naive implementation
  public long arrayManipulation(Scanner in) {
    // array initialization
    int n = in.nextInt();
    if(n<3 || n>Math.pow(10,7)) {
      throw new IllegalArgumentException("invalid data");
    }
    long[] arr = new long[n]; // int[] arr = new int[n]; IS NOT OK
    for(int i=0; i<n; i++) arr[i] = 0;

    // m: # of data lines
    int m = in.nextInt();
    if(m<1 || m>2*Math.pow(10,5)) {
      throw new IllegalArgumentException("invalid data");
    }

    for(int i=0; i<m; i++) {
      // load a data line and check the constraints.
      int a = in.nextInt();
      int b = in.nextInt();
      int k = in.nextInt();
      if(a<1 || b<1 || a>b || b>n || k<0 || k>Math.pow(10,9)) {
        throw new IllegalArgumentException("invalid data");
      }

      // add k
      for(int j=a-1; j<=b-1; j++) {
        arr[j] += k;
      }
      System.out.println(i+": "+toString(arr));
    }

    in.close();

    // get the max value in arr.
    long max = arr[0];
    for(int i=1; i<n; i++) {
      if(arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }

  //https://www.hackerrank.com/challenges/arrays-ds
  public String printReverse(int[] arr) {
    if(arr == null || arr.length < 1 || arr.length>Math.pow(10,3)) {
      throw new IllegalArgumentException("Invalid array input passed");
    }

    for(int one:arr) {
      if(one <1 || one > Math.pow(10,4)) {
        throw new IllegalArgumentException("Invalid array input passed");
      }
    }

    String ret = "";

    for(int i=arr.length-1; i>=0; i--) {
      ret += (arr[i]+" ");
    }

    return ret.substring(0, ret.length()-1);
  }
}
