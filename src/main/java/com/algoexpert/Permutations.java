package com.algoexpert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations
{
  public ArrayList<ArrayList<Integer>> getPermutations(List<Integer> a)
  {
    // Write your code here.
    final ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    getPermutationsHelper(a, result, 0, a.size() - 1);
    return result;
  }

  void getPermutationsHelper(
      List<Integer> a,
      ArrayList<ArrayList<Integer>> result,
      int l,
      int r
  )
  {
    if (l == r) {
      result.add(new ArrayList<>(a));
    } else {
      for (int i = l; i <= r; i++) {
        swap(a, l, i);
        getPermutationsHelper(a, result, l + 1, r);
        swap(a, l, i);
      }
    }
  }

  void swap(List<Integer> list, int i, int j)
  {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  @Test
  public void testPermutations()
  {
    final ArrayList<ArrayList<Integer>> permutations = getPermutations(new ArrayList<>(Arrays.asList(1, 2, 3)));
    System.out.println(permutations);
  }
}
