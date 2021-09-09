package com.leetcode.searching;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TopKFrequentWordsWithInt
{
  public List<Integer> topKFrequent(int[] nums, int k)
  {
    List<Integer> res = new ArrayList<>();
    int len = 0, temp;
    for (int n : nums) {
      temp = Math.abs(n);
      if (temp > len) {
        len = temp;
      }
    }
    int[] A = new int[len * 2 + 1];
    for (int n : nums) {
      A[n + len]++;
    }
    for (int i = 0; i < k; i++) {
      temp = getMax(A, len, 0);
      res.add(temp - len);
      A[temp] = 0;
    }
    return res;
  }

  private int getMax(int[] A, int len, int index)
  {
    int max = 0;
    for (int i = 0; i <= len * 2; i++) {
      if (A[i] > max) {
        max = A[i];
        index = i;
      }
    }
    return index;
  }

  @Test
  public void testTopKFrequent()
  {
    int[] a = {1, 1, 1, 2, 2, 3};
    List<Integer> res = topKFrequent(a, 2);
    System.out.println(res);
    int[] a1 = {1, 1, 1, 2, 2, 33333333};
    System.out.println(topKFrequent(a1, 2));
  }

}
