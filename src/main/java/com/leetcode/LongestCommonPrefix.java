package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class LongestCommonPrefix
{
  public String longestCommonPrefix1(String[] strs)
  {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    int i = 1;
    while (i < strs.length) {
      int j = 0;
      while (j < strs[i].length() && j < prefix.length()) {
        if (prefix.charAt(j) == strs[i].charAt(j)) {
          j++;
        } else {
          break;
        }
      }
      prefix = prefix.substring(0, j);
      if (prefix.isEmpty()) {
        return "";
      }
      i++;
    }
    return prefix;
  }

  public String longestCommonPrefix(String[] strs)
  {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String pre = strs[0];
    int i = 1;
    while (i < strs.length) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
      }
      i++;
    }
    return pre;
  }

  public String reverse(String a)
  {
    char[] aChar = a.toCharArray();
    int i = 0, j = aChar.length - 1;
    while (i < j) {
      char temp = aChar[i];
      aChar[i] = aChar[j];
      aChar[j] = temp;
      i++;
      j--;
    }
    return new String(aChar);
  }

  public void moveZeroes(int[] nums)
  {
    if (nums == null || nums.length == 0) {
      return;
    }
    int zeroIndex = getNextZeroIndex(nums, 0);
    if (zeroIndex == -1) {
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0 && zeroIndex <= i) {
        int temp = nums[i];
        nums[i] = 0;
        nums[zeroIndex] = temp;
        zeroIndex = getNextZeroIndex(nums, zeroIndex);
      }
    }
  }

  private int getNextZeroIndex(int[] a, int currentPosition)
  {
    while (currentPosition < a.length) {
      if (a[currentPosition] == 0) {
        return currentPosition;
      }
      currentPosition++;
    }
    return -1;
  }


  @Test
  public void testLCS()
  {
    System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    System.out.println(longestCommonPrefix(new String[]{"dog", "dacecar", "dar"}));
  }

  @Test
  public void testReverse()
  {
    System.out.println(reverse("madam"));
    System.out.println(reverse("sathish"));
  }

  @Test
  public void moveZeroes()
  {
    int[] a = new int[]{0, 1, 0, 3, 12};
    moveZeroes(a);
    System.out.println(ArrayUtils.toString(a));
    a = new int[]{1, 0};
    moveZeroes(a);
    System.out.println(ArrayUtils.toString(a));
  }
}
