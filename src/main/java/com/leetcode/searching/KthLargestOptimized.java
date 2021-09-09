package com.leetcode.searching;

import org.junit.Test;

public class KthLargestOptimized
{
  public int findKthLargest(int[] nums, int k)
  {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      return -1;
    }
    return partition(0, nums.length - 1, nums, nums.length - k);
  }

  private int partition(int start, int end, int[] nums, int k)
  {
    if (start >= end) {
      return nums[start];
    }
    int pivot = nums[(start + end) / 2];
    int left = start, right = end;
    while (left <= right) {
      while (left <= right && nums[left] < pivot) {
        left++;
      }
      while (left <= right && nums[right] > pivot) {
        right--;
      }
      if (left <= right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        left++;
        right--;
      }
    }
    if (k <= right) {
      return partition(start, right, nums, k);
    }
    if (k >= left) {
      return partition(left, end, nums, k);
    }
    return nums[k];

  }

  @Test
  public void testKthLargest()
  {
    int[] a = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(a, 2));
    System.out.println(findKthLargest(a, 3));
  }
}
