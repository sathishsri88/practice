package com.leetcode.searching;

import org.junit.Test;

public class Search2DMatrix {
  private boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0)
      return false;
    int L = 0, m = matrix.length, n = matrix[0].length;
    int R = (m * n) - 1;
    while (L <= R) {
      int M = L + (R - L) / 2;
      int val = matrix[M / n][M % n];
      if (val == target) return true;
      else if (val > target) {
        R = M - 1;
      } else {
        L = M + 1;
      }
    }
    return false;
  }

  @Test
  public void testSearch() {
    int[][] a = new int[][] {{1, 3}, {5, 7}};
    System.out.println(searchMatrix(a, 7));
    System.out.println(searchMatrix(a, 2));
  }
}
