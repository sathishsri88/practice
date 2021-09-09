package com.leetcode.backtracking;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, -100, n);
    return ans;
  }

  private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
    if (comb.size() == k && n == 0) {
      List<Integer> li = new ArrayList<Integer>(comb);
      ans.add(li);
      return;
    }
    for (int i = start; i <= 100; i++) {
      comb.add(i);
      combination(ans, comb, k, i + 1, n - i);
      comb.remove(comb.size() - 1);
    }
  }

  @Test
  public void testCombinationSum() {
    System.out.println(combinationSum3(3, 0));
  }

  @Test
  public void testCombin() {
    System.out.println(ArrayUtils.toString(solution(4)));
    System.out.println(ArrayUtils.toString(solution(5)));
    System.out.println(getLeastNumeric(4));
    System.out.println(getLeastNumeric(3));

    String a = "str";
    String b = new String("str");
    String c = a;
    System.out.println(a == b);
    System.out.println(a == c);
    System.out.println(b.equals(c));
    String ab;
    System.out.println("s");
    System.out.println(new AB().ab);
    int[] arr = new int[]{1,2};
    try{
      System.out.println(arr[3]);
    }catch (Exception e){
      System.out.println("E");
    }
  }

  private class AB {
    String name;
    int ab;
    protected String woof;

  }
  private int[] solution(int N) {
    // write your code in Java SE 8
    if (N < 0 || N > 100) {
      return new int[0];
    }
    int[] result = new int[N];
    boolean isEven = N % 2 == 0;
    int index = 0;
    for (int i = (N / 2) * -1; i <= N / 2; i++) {
      if (i == 0 && isEven) continue;
      result[index++] = i;
    }
    return result;
  }

  private int leastNumber(int N) {
    if (N <= 0) return 0;
    int digits = 0;
    while (N > 0) {
      digits++;
      N = N / 10;
    }
    return getLeastNumeric(digits);
  }

  private int getLeastNumeric(int digits) {
    int res = 1;
    while (digits > 1) {
      res *= 10;
      digits--;
    }
    return res;
  }
}

abstract class S1 {}

abstract class S2 {}

class c1 implements Serializable, Cloneable {}
