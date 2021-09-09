package com.algoexpert;

import org.junit.Test;

public class BinarySearch
{
  int binarySearch(int[] array, int target)
  {
    int L = 0, R = array.length - 1;
    int result = -1;
    while (L < R) {
      int M = (L + R) / 2;
      if (array[M] == target) {
        result = M;
        break;
      } else if (array[M] > target) {
        R = M;
      } else {
        L = M + 1;
      }
    }
    return L == R && array[L] == target ? L : result;
  }

  private int binarySearchRecursively(int[] array, int target, int left, int right)
  {
    if (left == right && array[left] == target) {
      return -1;
    } else if (left == right && array[left] != target) {
      return -1;
    } else if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > target) {
      return binarySearchRecursively(array, target, left, mid);
    } else {
      return binarySearchRecursively(array, target, mid + 1, right);
    }
  }

  private int binarySearch(int[] array, int target, int left, int right)
  {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > target) {
      return binarySearch(array, target, left, mid - 1);
    } else {
      return binarySearch(array, target, mid + 1, right);
    }
  }

  private int binarySearchCyclic(int[] a, int target)
  {
    int L = 0, R = a.length - 1;
    while (L < R) {
      int M = L + (R - L) / 2;
      if (a[M] < target) {
        if (a[L] >= target) {
          L = M + 1;
        } else {
          R = M;
        }
      } else {
        if (a[R] <= target) {
          R = M;
        } else {
          L = M + 1;
        }
      }
    }
    return L == R && a[L] == target ? L : -1;
  }


  private int bSearch(int[] array, int target)
  {
    return binarySearch(array, target, 0, array.length - 1);
  }

  @Test
  public void testBSearch()
  {
    int a[] = {1, 2, 3, 4, 5};
    System.out.println(binarySearch(a, 4));
    System.out.println(binarySearch(a, 5));
    System.out.println(binarySearch(a, -3));
    System.out.println(binarySearch(a, 2));
    System.out.println(binarySearch(a, 1));
    System.out.println(binarySearch(a, 6));
  }

  @Test
  public void testBSearchRecursively()
  {
    int a[] = {1, 2, 3, 4, 5};
    System.out.println(bSearch(a, 4));
    System.out.println(bSearch(a, 5));
    System.out.println(bSearch(a, -3));
    System.out.println(bSearch(a, 2));
    System.out.println(bSearch(a, 1));
    System.out.println(bSearch(a, 6));
  }

  @Test
  public void testCyclicBinarySearch()
  {
    int a[] = {378, 478, 550, 631, 103, 203, 220, 234, 279, 365};
    System.out.println(binarySearchCyclic(a, 631));
  }
}
