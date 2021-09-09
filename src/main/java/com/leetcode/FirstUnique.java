package com.leetcode;

import org.junit.Test;

public class FirstUnique
{
  private int firstUniqChar(String s)
  {
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (freq[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }

  int firstUniqCharTry(String s)
  {
    int result = Integer.MAX_VALUE;
    for (char c = 'a'; c <= 'z'; c++) {
      int id = s.indexOf(c);
      if (id != -1 && id == s.lastIndexOf(c)) {
        result = Math.min(id, result);
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private int firstUniqCharBest(String s)
  {
    int result = Integer.MAX_VALUE;
    for (char c = 'a'; c <= 'z'; c++) {
      int id = s.indexOf(c);
      if (id != -1 && id == s.lastIndexOf(c)) {
        result = Math.min(result, id);
      }
    }
    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  @Test
  public void testFirstUniqCharBest()
  {
    System.out.println(firstUniqCharBest("leetcode"));
    System.out.println(firstUniqCharBest("loveleetcode"));
    System.out.println(firstUniqCharBest("aabbsd"));
    System.out.println(firstUniqCharBest("aabbdd"));
  }

  @Test
  public void testFirstUniqChar()
  {
    System.out.println(firstUniqCharTry("leetcode"));
    System.out.println(firstUniqCharTry("loveleetcode"));
    System.out.println(firstUniqCharTry("aabbsd"));
    System.out.println(firstUniqCharTry("aabbdd"));
  }


}
