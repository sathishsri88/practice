package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

import java.util.LinkedList;

public class InOrderTraversal
{

  private void inOrderTraversal(TreeNode node, boolean isAlphabetic)
  {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.getLeft(), isAlphabetic);
    TreeUtils.printValue(node, isAlphabetic);
    inOrderTraversal(node.getRight(), isAlphabetic);
  }


  private void inOrderTraversalIterative(TreeNode node, boolean isAlphabetic)
  {
    final LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    TreeNode curr = node;
    while (!nodeQueue.isEmpty() || curr != null) {
      if (curr != null) {
        nodeQueue.addFirst(curr);
        curr = curr.getLeft();
      } else {
        curr = nodeQueue.removeFirst();
        TreeUtils.printValue(curr, isAlphabetic);
        curr = curr.getRight();
      }
    }
  }

  @Test
  public void testInOrderTraversal()
  {
    final TreeNode node = TreeUtils.stringToTreeNode(
        "314,6,6,271,561,2,272,28,0,null,3,null,1,null,28,null,null,null,null,17,null,401,257,null,null,null,null,"
        + "null,641");
    System.out.println(node);
    inOrderTraversal(node, false);
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    inOrderTraversal(alphaNode, true);
  }

  @Test
  public void testInOrderTraversalIterative()
  {
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    inOrderTraversalIterative(alphaNode, true);
  }

  @Test
  public void testInOrderTraversalIterativeSimple()
  {
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,C");
    System.out.println(alphaNode);
    inOrderTraversalIterative(alphaNode, true);
  }
}
