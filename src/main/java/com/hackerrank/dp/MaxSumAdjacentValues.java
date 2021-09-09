package com.hackerrank.dp;

import org.junit.Test;

public class MaxSumAdjacentValues {

  private int maxSumAdjacent(int[] arr) {
    if (arr.length == 0) return 0;
    else if (arr.length == 1) return arr[0];
    int[] maxSums = arr.clone();
    maxSums[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++) {
      maxSums[i] = Math.max(maxSums[i - 2], Math.max(maxSums[i - 1], (maxSums[i - 2] + arr[i])));
    }
    return maxSums[arr.length - 1];
  }

  private int maxSumAdjacentReverse(int[] arr) {
    if (arr.length == 0) return 0;
    else if (arr.length == 1) return arr[0];
    int[] maxSums = arr.clone();
    maxSums[arr.length - 2] = Math.max(arr[arr.length - 1], arr[arr.length - 2]);
    for (int i = arr.length - 3; i >= 0; i--) {
      maxSums[i] = Math.max(maxSums[i + 2], Math.max(maxSums[i + 1], (maxSums[i + 2] + arr[i])));
    }
    return maxSums[0];
  }

  @Test
  public void testMaxSumAdjacent() {
    System.out.println(maxSumAdjacent(new int[] {-2, 1, 3, -4, 5}));
    System.out.println(maxSumAdjacent(new int[] {3, 7, 4, 6, 5}));
    System.out.println(maxSumAdjacent(new int[] {2, 1, 5, 8, 4}));
    System.out.println(maxSumAdjacent(new int[] {3, 5, -7, 8, 10}));
  }

  @Test
  public void testMaxSumAdjacentReverse() {
    System.out.println(maxSumAdjacentReverse(new int[] {-2, 1, 3, -4, 5}));
    System.out.println(maxSumAdjacentReverse(new int[] {3, 7, 4, 6, 5}));
    System.out.println(maxSumAdjacentReverse(new int[] {2, 1, 5, 8, 4}));
    System.out.println(maxSumAdjacentReverse(new int[] {3, 5, -7, 8, 10}));
  }
}
