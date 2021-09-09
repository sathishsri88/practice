package com.practice.backtracking;

import org.junit.Test;

public class BackTrackingTest
{

  @Test
  public void backTrackingSample()
  {
    System.out.println("Hello Interview !!!");
  }

  @Test
  public void testNQueen()
  {
    NQueen.Position[] positions = new NQueen().solve(6);
    for (NQueen.Position position : positions) {
      System.out.println(position);
    }
    System.out.println("----------------------------------------");
    positions = new NQueen().solve(8);
    for (NQueen.Position position : positions) {
      System.out.println(position);
    }
    System.out.println("----------------------------------------");
    positions = new NQueen().solve(4);
    for (NQueen.Position position : positions) {
      System.out.println(position);
    }
  }


}
