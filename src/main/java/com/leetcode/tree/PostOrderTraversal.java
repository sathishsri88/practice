package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class PostOrderTraversal
{

  private void postOrderTraversal(TreeNode node, boolean isAlphabetic)
  {
    if (node == null) {
      return;
    }
    postOrderTraversal(node.getLeft(), isAlphabetic);
    postOrderTraversal(node.getRight(), isAlphabetic);
    TreeUtils.printValue(node, isAlphabetic);
  }

  private void postOrderTraversalIterative(TreeNode node, boolean isAlphabetic)
  {
    LinkedList ans = new LinkedList();
    Stack<TreeNode> stack = new Stack<>();
    if (node == null) {
      return;
    }

    stack.push(node);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (isAlphabetic) {
        ans.addFirst(cur.getValue());
      } else {
        ans.addFirst(cur.getVal());
      }

      if (cur.getLeft() != null) {
        stack.push(cur.getLeft());
      }
      if (cur.getRight() != null) {
        stack.push(cur.getRight());
      }
    }
    for (Object obj : ans) {
      System.out.print(obj += " -> ");
    }
  }

  @Test
  public void testPostOrderTraversal()
  {
    final TreeNode node = TreeUtils.stringToTreeNode(
        "314,6,6,271,561,2,272,28,0,null,3,null,1,null,28,null,null,null,null,17,null,401,257,null,null,null,null,"
        + "null,641");
    System.out.println(node);
    postOrderTraversal(node, false);
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    postOrderTraversalIterative(alphaNode, true);
  }

  @Test
  public void testPostOrderTraversalIterative()
  {
    final TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,I,C,F,J,O,D,E,null,G,null,K,null,P,null,null,null,null,H,null,L,N,null,null,null,null,null,M");
    System.out.println(alphaNode);
    postOrderTraversalIterative(alphaNode, true);
  }

  @Test
  public void testPostOrderTraversalIterativeSimple()
  {
    TreeNode alphaNode = TreeUtils.stringToAlphabeticTreeNode(
        "A,B,C");
    System.out.println(alphaNode);
    postOrderTraversalIterative(alphaNode, true);
    System.out.println();
    alphaNode = TreeUtils.stringToTreeNode(
        "1,2,3");
    postOrderTraversalIterative(alphaNode, false);
  }


}
