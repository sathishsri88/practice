package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class MergeSortedArray
{
  private void merge(int[] nums1, int m, int[] nums2, int n)
  {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }

  @Test
  public void testSortedArray()
  {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    merge(nums1, 3, nums2, 3);
    System.out.println(ArrayUtils.toString(nums1));
  }

  @Test
  public void testSortedArrayIdenticalElem()
  {
//    [0,0,0,0,0]
//    0
//        [1,2,3,4,5]
//    5
    int[] nums1 = {0, 0, 0, 0, 0};
    int[] nums2 = {1, 2, 3, 4, 5};
    merge(nums1, 0, nums2, 5);
    System.out.println(ArrayUtils.toString(nums1));
  }

}
