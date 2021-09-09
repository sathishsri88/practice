package com.leetcode;

import org.junit.Test;

public class PivotIndex
{
  public int pivotIndex2(int[] nums)
  {
    if (nums.length < 1) {
      return -1;
    }
    if (nums.length == 1) {
      return 1;
    }
    int i = 0, j = nums.length - 1;
    int leftSum = nums[i], rightSum = nums[j];
    while (i < j) {
      if (leftSum < rightSum) {
        i++;
        leftSum += nums[i];
      } else if (leftSum > rightSum) {
        j--;
        rightSum += nums[j];
      } else {
        i++;
        j--;
        leftSum += nums[i];
        rightSum += nums[j];
      }
    }
    return i == j && leftSum == rightSum ? i : -1;
  }

  int pivotIndex(int[] nums)
  {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int pivotSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum - nums[i] == 2 * pivotSum) {
        return i;
      }
      pivotSum += nums[i];
    }
    return -1;
  }

  @Test
  public void testPivotIndex()
  {
    System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
  }
}
