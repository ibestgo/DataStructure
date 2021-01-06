package com.bestgo.hello;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/hexagonal-grid/problem
public class HexagonalGridChallenge {
  public HexagonalGridChallenge() {
  }

  // "6 6 010000 000010 2 00 00 2 00 10 2 00 01 2 00 11 2 10 00"
  public String[] hexagonalGridChallenge(String src) {
    Scanner sc = new Scanner(src);
    int tests = sc.nextInt();
    if(tests < 1 || tests > 100) {
      throw new IllegalArgumentException("");
    }
    String[] result = new String[tests];

    for(int i=0; i<tests; i++) {
      System.out.print("\nTest "+(i+1)+": ");
      int length = sc.nextInt();
      int[][] grid = new int[2][length];

      // grid initialization
      for(int r=0; r<2; r++) {
        String str = sc.next();
        for (int c = 0; c<length; c++) {
          if (str.charAt(c) == '0') {
            grid[r][c] = 0;
          } else if (str.charAt(c) == '1') {
            grid[r][c] = 1;   // black
          } else {
            throw new IllegalArgumentException("Invalid argument");
          }
        }
      }

      // lay the tiles
      for(int r=0; r<2; r++) {
        if(r == 0) {
          // preferred check order: An-1An, AnBn-1, AnBn,  AnAn+1 for An
          for (int n = 0; n < length; n++) {
            if (grid[0][n] != 1) {
              if(n-1 >= 0 && grid[0][n-1] != 1) {
                grid[0][n-1] = 1;
                grid[0][n] = 1;
              } else if(n-1 >= 0 && grid[1][n-1] != 1) {
                grid[0][n] = 1;
                grid[1][n-1] = 1;
              } else if(grid[1][n] != 1) {
                grid[0][n] = 1;
                grid[1][n] = 1;
              } else if(n+1 < length && grid[0][n+1] != 1) {
                grid[0][n] = 1;
                grid[0][n+1] = 1;
              }
            }
          }
        } else if(r == 1) {
          // preferred check order: Bn-1Bn, AnBn, An+1Bn,  BnBn+1 for Bn
          for (int n = 0; n < length; n++) {
            if (grid[1][n] != 1) {
              if(n-1 >= 0 && grid[1][n-1] != 1) {
                grid[1][n-1] = 1;
                grid[1][n] = 1;
              } else if(grid[0][n] != 1) {
                grid[0][n] = 1;
                grid[1][n] = 1;
              } else if(n+1 < length && grid[0][n+1] != 1) {
                grid[0][n+1] = 1;
                grid[1][n] = 1;
              } else if(n+1 < length && grid[1][n+1] != 1) {
                grid[1][n] = 1;
                grid[1][n+1] = 1;
              }
            }
          }
        }
      }

      // check if any missing
      boolean ret = true;
      for(int r=0; r<2; r++) {
        for (int n = 0; n < length; n++) {
          if(grid[r][n] == 0) {
            ret = false;
            break;
          }
        }
      }

      String str = ret? "YES" : "NO";
      System.out.print(str);
      result[i] = str;
    }
    return result;
  }

}
