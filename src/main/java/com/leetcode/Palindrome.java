package com.leetcode;

import org.junit.Test;

public class Palindrome
{
  private boolean isPalindrome(String s)
  {
    if (s == null) {
      return false;
    }
    if (s.length() == 0 || s.length() == 1) {
      return true;
    }
    s = s.toLowerCase();
    int i = 0, j = s.length() - 1;
    while (i < j) {
      boolean isNonAlphabet = false;
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        i++;
        isNonAlphabet = true;
      }
      if (!Character.isLetterOrDigit(s.charAt(j))) {
        j--;
        isNonAlphabet = true;
      }
      if (isNonAlphabet) {
        continue;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  @Test
  public void testIsPalindrome()
  {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
    System.out.println(isPalindrome("0P"));
  }
}
