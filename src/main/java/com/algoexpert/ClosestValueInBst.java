package com.algoexpert;

import org.junit.Test;

public class ClosestValueInBst
{
  public static int findClosestValueInBst(BST tree, int target)
  {
    // Write your code here.
    return findClosestValueInBst(tree, target, tree.value);
  }

  private static int findClosestValueInBst(BST tree, int target, int nearestValue)
  {
    if (tree == null) {
      return nearestValue;
    }
    if (tree.value == target) {
      return target;
    } else if (tree.value > target) {
      return findClosestValueInBst(tree.left, target, findNearestValue(target, nearestValue, tree.value));
    } else {
      return findClosestValueInBst(tree.right, target, findNearestValue(target, nearestValue, tree.value));
    }
  }

  private static int findNearestValue(int target, int nearestValue, int currentValue)
  {

    int diff1 = Math.abs(target - nearestValue);
    int diff2 = Math.abs(target - currentValue);
    return diff1 <= diff2 ? nearestValue : currentValue;
  }

  @Test
  public void testFindClosesValue()
  {

  }

  static class BST
  {
    public int value;
    public BST left;
    public BST right;

    public BST(int value)
    {
      this.value = value;
    }
  }
}
