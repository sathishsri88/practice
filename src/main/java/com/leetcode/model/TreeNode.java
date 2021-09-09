package com.leetcode.model;

import java.util.StringJoiner;

public class TreeNode
{
  int val;
  String value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int x, String value)
  {
    val = x;
    this.value = value;
  }

  public int getVal()
  {
    return val;
  }

  public void setVal(int val)
  {
    this.val = val;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public TreeNode getLeft()
  {
    return left;
  }

  public void setLeft(TreeNode left)
  {
    this.left = left;
  }

  public TreeNode getRight()
  {
    return right;
  }

  public void setRight(TreeNode right)
  {
    this.right = right;
  }

  @Override
  public String toString()
  {
    return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
        .add("val=" + val)
        .add("value='" + value + "'")
        .add("left=" + left)
        .add("right=" + right)
        .toString();
  }
}
