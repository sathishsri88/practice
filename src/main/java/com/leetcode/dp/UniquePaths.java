package com.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePaths {
  private int uniquePaths(int m, int n) {
    int[][] paths = new int[m][n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (isEdge(row, col)) {
          paths[row][col] = 1;
        } else {
          paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
        }
      }
    }
    return paths[m - 1][n - 1];
  }

  private boolean isEdge(int row, int col) {
    return row == 0 || col == 0;
  }

  @Test
  public void testUniquePaths() {
    System.out.println(uniquePaths(3, 2));
    assertEquals(uniquePaths(3, 2), 3);
    System.out.println(uniquePaths(7, 3));
    assertEquals(uniquePaths(7, 3), 28);
  }
}
