package com.bestgo.hello;

public class Sorting {

  public Sorting() {
  }

  public void bubbleSort2(int[] org) {
    if(org == null || org.length < 1) {
      throw new IllegalArgumentException("null or empty array passed");
    }

    int it = 0;
    if(org.length > 1) {
      int n = org.length;
      for (int i=n; i>1; i--) {
        for (int j=0; j<i-1; j++) {
          if (org[j] > org[j+1]) {
            swap(org, j, j+1);
          }
          System.out.println("TEMP("+(it++)+")"+toString(org));
        }
      }
    }
  }

  public void bubbleSort1(int[] org) {
    if(org == null || org.length < 1) {
      throw new IllegalArgumentException("null or empty array passed");
    }

    int it = 0;
    if(org.length > 1) {
      int n = org.length;
      for (int i=0; i< n; i++) { // same iterations for (int i=0; i< n-1; i++) {
        for (int j=0; j< n-1-i; j++) {
          if (org[j] > org[j+1]) {
            swap(org, j, j+1);
          }
          System.out.println("TEMP("+(it++)+")"+toString(org));
        }
      }
    }
  }

  public void bubbleSort3(int[] org) {
    if(org == null || org.length < 1) {
      throw new IllegalArgumentException("null or empty array passed");
    }

    int it = 0;
    if(org.length > 1) {
      int n = org.length;
      for (int i=0; i< n; i++) { // same iterations for (int i=0; i< n-1; i++) {
        boolean swapped = false;
        for (int j=0; j< n-1-i; j++) {
          if (org[j] > org[j+1]) {
            swap(org, j, j+1);
            swapped = true;
          }
          System.out.println("TEMP("+(it++)+")"+toString(org));
        }
        if(!swapped) break;
      }
    }
  }

  public void insertSort(int[] org) {
    for(int i=1; i<org.length; i++) {
      for(int j=0; j<i; j++) {
        if(org[j] > org[i]) {
          insert(org, i, j);
        }
      }
    }
  }

  ///////////////////////////////
  // Private & Protected Methods
  ///////////////////////////////

  protected void insert(int[] org, int from, int to) {
    int temp = org[from];
    for(int i= from; i>to; i--) {
      org[i] = org[i-1];
    }
    org[to] = temp;
  }

  protected void swap(int[] org, int first, int second) {
    if(org == null || org.length < 1 || first < 0 || second < 0 || first > org.length-1 || second > org.length-1) {
      throw new IllegalArgumentException("Arguments are not valid");
    }

    if(first != second) {
      int temp = org[first];
      org[first] = org[second];
      org[second] = temp;
    }
  }

  protected String toString(int[] org) {
    String ret = "[";
    for(int one: org) {
      ret += (one + ", ");
    }
    return (ret.endsWith(", "))? ret.substring(0, ret.length()-2) + "]" :  ret+"]";
  }
}
