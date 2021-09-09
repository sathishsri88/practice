package com.algoexpert;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree
{

  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
    final Deque<BinaryTree> q = new ArrayDeque<BinaryTree>();
    q.add(tree);
    while(!q.isEmpty()){
      final BinaryTree binaryTree = q.pollFirst();
      if(binaryTree == null)
        continue;
      BinaryTree temp = binaryTree.left;
      binaryTree.left = binaryTree.right;
      binaryTree.right = temp;
      if(binaryTree.left !=null)
        q.addLast(binaryTree.left);
      if(binaryTree.right!=null)
        q.addLast(binaryTree.right);
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
