package com.leetcode.searching;

import org.junit.Test;

public class FindMinSortedArray {
  public int findMin(int[] a) {
    if (a == null || a.length == 0) {
      return -1;
    }
    int L = 0, R = a.length - 1;
    while (L <= R) {
      int M = L + (R - L) / 2;
      if (a[L] < a[M]) {
        if (a[M] > a[R]) {
          L = M + 1;
        } else {
          R = M - 1;
        }
      } else {
        if (a[M] < a[R]) {
          R = M - 1;
        } else {
          L = M + 1;
        }
      }
    }
    return a[L];
  }

  private int findMinAnotherV(int[] a){
    if (a == null || a.length == 0) {
      return -1;
    }
    int L = 0, R = a.length - 1;
    while (L <= R) {
      int M = L + (R - L) / 2;
      if (a[L] < a[M]) {
        if (a[M] > a[R]) {
          L = M + 1;
        } else {
          R = M - 1;
        }
      } else {
        if (a[M] < a[R]) {
          R = M - 1;
        } else {
          L = M + 1;
        }
      }
    }
    return a[L];
  }

  @Test
  public void testFindMin() {
    //TODO wrong result
    System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
    System.out.println(findMin(new int[] {4, 5, 6, 7, 0, -1, 2}));
  }

  @Test
  public void testFindMinAnotherVersion() {
    //TODO wrong result
    System.out.println(findMinAnotherV(new int[] {3, 4, 5, 1, 2}));
    System.out.println(findMinAnotherV(new int[] {4, 5, 6, 7, 0, -1, 2}));
  }
}
