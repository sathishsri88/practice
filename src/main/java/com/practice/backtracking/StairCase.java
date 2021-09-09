package com.practice.backtracking;

import org.junit.Test;

import java.util.Arrays;

public class StairCase
{

  int howManySteps(int remainder)
  {
    if (remainder < 0) {
      return 0;
    }
    if (remainder == 0) {
      return 1;
    }
    return howManySteps(remainder - 1) + howManySteps(remainder - 2) + howManySteps(remainder - 3);
  }

  int howManySteps(int remainder, int[] memo)
  {
    if (remainder < 0) {
      return 0;
    }
    if (remainder == 0) {
      return 1;
    }
    if (memo[remainder] > -1) {
      return memo[remainder];
    }
    memo[remainder] = howManySteps(remainder - 1, memo) + howManySteps(remainder - 2, memo)
                      + howManySteps(remainder - 3, memo);
    return memo[remainder];
  }

  int computeSteps(int steps)
  {
    int[] memo = new int[steps + 1];
    Arrays.fill(memo, -1);
    return howManySteps(steps, memo);
  }

  @Test
  public void measureStairCase()
  {
    System.out.println(howManySteps(3));
    System.out.println(howManySteps(5));
  }

  @Test
  public void measureStairCaseMemo()
  {
    System.out.println(computeSteps(3));
    System.out.println(computeSteps(5));
  }
}
