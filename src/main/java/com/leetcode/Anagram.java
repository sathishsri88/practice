package com.leetcode;

import org.junit.Test;

public class Anagram
{

  private boolean isValidAnagram(String s, String t)
  {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int[] freq = new int[65536];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i)]++;
      freq[t.charAt(i)]--;
    }
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidAnagramBest(String s, String t)
  {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int[] freq = new int[128];
    for (char c : s.toCharArray()) {
      freq[c]++;
    }
    for (char c : t.toCharArray()) {
      if (freq[c] == 0) {
        return false;
      }
      freq[c]--;

    }
    return true;
  }

  @Test
  public void testIsValidAnagram()
  {
    System.out.println(isValidAnagram("anagram", "nagaram"));
    System.out.println(isValidAnagram("rat", "car"));
  }

  @Test
  public void testIsValidAnagramBest()
  {
    System.out.println(isValidAnagramBest("anagram", "nagaram"));
    System.out.println(isValidAnagramBest("rat", "car"));
  }
}
