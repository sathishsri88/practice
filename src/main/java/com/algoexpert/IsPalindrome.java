package com.algoexpert;

import org.junit.Test;

public class IsPalindrome
{
  boolean isPalindrome(String a)
  {
    if (a == null) {
      return false;
    }
    int middle = a.length() / 2;
    int L = 0;
    if (a.length() % 2 == 0) {
      if (a.charAt(middle - 1) != a.charAt(middle)) {
        return false;
      }
      L = middle - 2;
    } else {
      L = middle - 1;
    }
    int R = middle + 1;
    while (L <= 0 && R < a.length()) {
      if (a.charAt(L) != a.charAt(R)) {
        return false;
      }
      L--;
      R++;
    }
    return true;
  }

  @Test
  public void testPalindrome()
  {
    System.out.println(isPalindrome("abb"));
    System.out.println(isPalindrome("abcdcba"));
    System.out.println(isPalindrome("abcdecba"));
    System.out.println(isPalindrome("madam"));
    System.out.println(isPalindrome("a"));
    System.out.println(isPalindrome("ab"));
    System.out.println(isPalindrome("aa"));
    System.out.println(isPalindrome("aaaaaa"));
  }
}
