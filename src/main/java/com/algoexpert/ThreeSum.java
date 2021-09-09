package com.algoexpert;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ThreeSum
{
  public int[] findThreeLargestNumbers(int[] array)
  {
    // Write your code here.
    int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int i = 0; i < array.length; i++) {
      compareAndShift(max, array[i]);
    }
    return max;
  }


  void compareAndShift(int[] max, int no)
  {
    for (int i = max.length - 1; i >= 0; i--) {
      if (no >= max[i]) {
        shift(max, no, i);
        break;
      }
    }
  }

  void shift(int[] max, int no, int index)
  {
    for (int i = index; i >= 0; i--) {
      int temp = max[i];
      max[i] = no;
      no = temp;
    }
  }

  @Test
  public void testThreeSum()
  {
    System.out.println(ArrayUtils.toString(findThreeLargestNumbers(new int[]{141, 1, 7, -7, 8})));
    System.out.println(ArrayUtils.toString(findThreeLargestNumbers(new int[]{141, 1})));
  }
}
