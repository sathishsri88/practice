package com.practice.arrays;

import org.junit.Test;

public class PrimeEnumeration
{
  private void printPrimeFrm(int n)
  {
    for (int i = 13; i <= n; i++) {
      if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0 && i % 11 != 0) {
        System.out.print(", " + i);
      }
    }
  }

  private void printPrime(int n)
  {
    System.out.print("2, 3, 5, 7, 11");
    printPrimeFrm(n);
  }

  @Test
  public void testPrintPrime()
  {
    printPrime(18);
    System.out.println();
    printPrime(287);
  }
}
