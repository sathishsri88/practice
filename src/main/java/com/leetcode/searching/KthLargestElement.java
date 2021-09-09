package com.leetcode.searching;

import org.junit.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * QuickSelect
 * <p>
 * QuickSelect(A, k)
 * let r be chosen uniformly at random in the range 1 to length(A)
 * let pivot = A[r]
 * let A1, A2 be new arrays
 * # split into a pile A1 of small elements and A2 of big elements
 * for i = 1 to n
 * if A[i] < pivot then
 * append A[i] to A1
 * else if A[i] > pivot then
 * append A[i] to A2
 * else
 * # do nothing
 * end for
 * if k <= length(A1):
 * # it's in the pile of small elements
 * return QuickSelect(A1, k)
 * else if k > length(A) - length(A2)
 * # it's in the pile of big elements
 * return QuickSelect(A2, k - (length(A) - length(A2))
 * else
 * # it's equal to the pivot
 * return pivot
 */
public class KthLargestElement
{
  private int findKthLargest(int[] A, int k)
  {
    return findKth(A, k, (a, b) -> Integer.compare(b, a));
  }

  private int findKth(int[] A, int k, Comparator<Integer> cmp)
  {
    int left = 0, right = A.length - 1;
    Random r = new Random(0);
    while (left <= right) {
      int pivotIdx = r.nextInt(right - left + 1) + left;
      int newPivotIdx = partitionAroundPivot(A, left, right, pivotIdx, cmp);
      if (newPivotIdx == k - 1) {
        return A[newPivotIdx];
      } else if (newPivotIdx > k - 1) {
        right = newPivotIdx - 1;
      } else {
        left = newPivotIdx + 1;
      }
    }
    throw new NoSuchElementException("no k-th node in array A");
  }

  private int partitionAroundPivot(int[] A, int left, int right, int pivotIdx, Comparator<Integer> cmp)
  {
    int pivotValue = A[pivotIdx];
    int newPivotIdx = left;
    swap(A, pivotIdx, right);
    for (int i = left; i < right; i++) {
      if (cmp.compare(A[i], pivotValue) < 0) {
        swap(A, i, newPivotIdx++);
      }
    }
    swap(A, right, newPivotIdx);
    return newPivotIdx;
  }

  private void swap(int[] A, int left, int right)
  {
    int temp = A[left];
    A[left] = A[right];
    A[right] = temp;
  }

  @Test
  public void testKthLargest()
  {
    int[] a = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(a, 2));
    System.out.println(findKthLargest(a, 3));
  }


}
