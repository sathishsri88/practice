package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

import java.util.LinkedList;

public class PreOrderTraversal
{
  private void preOrderTraversal(TreeNode node, boolean isAlphabetic)
  {
    if (node == null) {
      return;
    }
    TreeUtils.printValue(node, isAlphabetic);
    preOrderTraversal(node.getLeft(), isAlphabetic);
    preOrderTraversal(node.getRight(), isAlphabetic);
  }

  private void preOrderTraversalIterative(TreeNode node, boolean isAlphabetic)
  {
    final LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    if (node != null) {
      nodeQueue.addFirst(node);
    }
    while (!nodeQueue.isEmpty()) {
      final TreeNode curr = nodeQueue.removeFirst();
      TreeUtils.printValue(curr, isAlphabetic);
      if (curr.getRight() != null) {
        nodeQueue.addFirst(curr.getRight());
      }
      if (curr.getLeft() != null) {
        nodeQueue.addFirst(curr.getLeft());
      }
    }
  }

  @Test
  public void testPreOrderTraversal()
  {
    final TreeNode node = TreeUtils.stringToTreeNode(
        "314,6,6,271,561,2,272,28,0,null,3,null,1,null,28,null,null,null,null,17,null,401,257,null,null,null,null,"
        + "null,641");
    System.out.println(node);
    preOrderTraversal(node, false);
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    preOrderTraversalIterative(alphaNode, true);
  }

  @Test
  public void testPreOrderTraversalIterative()
  {
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    preOrderTraversalIterative(alphaNode, true);
  }

  @Test
  public void testPreOrderTraversalIterativeSimple()
  {
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,C");
    System.out.println(alphaNode);
    preOrderTraversalIterative(alphaNode, true);
  }
}
