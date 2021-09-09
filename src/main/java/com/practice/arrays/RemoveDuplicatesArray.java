package com.practice.arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesArray
{

  private int removeDuplicates(int[] a)
  {
    if (a.length == 0) {
      return 0;
    }
    int writeIndex = 1;
    for (int i = 1; i < a.length; i++) {
      if (a[writeIndex - 1] != a[i]) {
        a[writeIndex++] = a[i];
      }
    }
    return writeIndex;
  }

  @Test
  public void testRemoveDuplicates()
  {
    int[] a = new int[]{2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
    int result = removeDuplicates(a);
    System.out.println(ArrayUtils.toString(a));
    System.out.println(result);
  }

  private int removeDuplicates(int[] a, int m, boolean minOrMax)
  {
    if (a.length == 0) {
      return 0;
    }
    int writeIndex = 1, currentValueCnt = 1;
    int min = minOrMax ? Math.min(2, m) : Math.max(2, m);
    for (int i = 0; i < a.length; i++) {
      if (a[writeIndex - 1] != a[i]) {
        a[writeIndex++] = a[i];
        currentValueCnt = 1;
      } else {
        if (currentValueCnt < min) {
          a[writeIndex++] = a[i];
        }
        currentValueCnt++;
      }
    }
    return writeIndex;
  }

  @Test
  public void testRemoveDuplicatesWithMin()
  {
    int[] a = new int[]{2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
    int result = removeDuplicates(a, 2, false);
    System.out.println(ArrayUtils.toString(a));
    System.out.println(result);
    assert (Arrays.equals(a, new int[]{2, 2, 3, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9}));
    assert result == 10;
    a = new int[]{2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
    result = removeDuplicates(a, 3, false);
    System.out.println(ArrayUtils.toString(a));
    System.out.println(result);
    assert result == 12;
    assert (Arrays.equals(a, new int[]{2, 2, 2, 5, 5, 5, 6, 7, 8, 9, 9, 9, 9}));
    a = new int[]{2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
    result = removeDuplicates(a, 1, false);
    System.out.println(ArrayUtils.toString(a));
    System.out.println(result);
    assert (Arrays.equals(a, new int[]{2, 2, 3, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9}));
    assert result == 10;
    a = new int[]{2, 2, 3, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9};
    result = removeDuplicates(a, 1, true);
    System.out.println(ArrayUtils.toString(a));
    System.out.println(result);
    assert (Arrays.equals(a, new int[]{2, 3, 5, 6, 7, 8, 9, 6, 7, 8, 9, 9, 9}));
    assert result == 7;
  }
}
