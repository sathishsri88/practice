package com.algoexpert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci
{
  static Map<Integer, Integer> store = new HashMap<Integer, Integer>();

  public static int getNthFib(int n)
  {
    // Write your code here.
    if (!store.containsKey(n)) {
      store.put(n, getFib(n));
    }
    return store.get(n);
  }

  private static int getFib(int n)
  {
    if (n <= 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    return getFib(n - 1) + getFib(n - 2);
  }

  public static int getFibIterative(int target)
  {
    if(target <=1)
      return 0;
    else if(target == 2)
      return 1;
    else if(target == 3)
      return 1;
    int prev = 1, curr = 1;
    int n = 4;
    while (n <= target) {
      int next = curr + prev;
      prev = curr;
      curr = next;
      n += 1;
    }
    return curr;
  }

  @Test
  public void testNthFibonacci()
  {
    System.out.println(getNthFib(3));
    store.clear();
    System.out.println(getNthFib(1));
    System.out.println(getFibIterative(3));
    System.out.println(getFibIterative(4));
    System.out.println(getFibIterative(5));
  }
}
