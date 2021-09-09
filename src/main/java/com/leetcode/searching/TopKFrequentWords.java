package com.leetcode.searching;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords
{
  private List<Integer> topKFrequentTmp(int[] nums, int k)
  {

    List<Integer>[] bucket = new List[nums.length + 1];
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    for (int n : nums) {
      frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }

    for (int key : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();

    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
      if (bucket[pos] != null) {
        res.addAll(bucket[pos]);
      }
    }
    return res;
  }

  private List<Integer> topKFrequent(int[] nums, int k)
  {
    List<Integer> res = new ArrayList<>();
    int length = nums.length;
    if (length > 0) {
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      int maxFreq = Integer.MIN_VALUE;
      int minFreq = Integer.MAX_VALUE;
      for (int n : nums) {
        if (n > max) {
          max = n;
        }
        if (n < min) {
          min = n;
        }
      }

      int range = max - min + 1;
      int[] frequency = new int[range];

      for (int n : nums) {
        frequency[n - min]++;
        if (frequency[n - min] > maxFreq) {
          maxFreq = frequency[n - min];
        }
        if (frequency[n - min] < minFreq) {
          minFreq = frequency[n - min];
        }
      }

      List<Integer>[] freqList = new ArrayList[maxFreq - minFreq + 1];
      for (int i = 0; i < range; ++i) {
        if (frequency[i] > 0) {
          if (freqList[frequency[i] - minFreq] == null) {
            freqList[frequency[i] - minFreq] = new ArrayList<>();
          }
          freqList[frequency[i] - minFreq].add(i + min);
        }
      }

      for (int i = freqList.length - 1; i >= 0 && res.size() < k; --i) {
        if (freqList[i] != null) {
          res.addAll(freqList[i]);
        }
      }
    }
    return res;
  }

  @Test
  public void testTopKFrequent()
  {
    int[] b = {1, 1, 1, 2, 2, 3};
    System.out.println(topKFrequent(b, 2));
    int[] b1 = {1, 1, 1, 2, 2, 33333333};
    System.out.println(topKFrequent(b1, 2));
  }

}
