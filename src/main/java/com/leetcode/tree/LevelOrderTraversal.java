package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal
{

  private List<List<Integer>> levelOrder(TreeNode root)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Deque<TreeNode> treeNodes = new ArrayDeque<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      List<Integer> nodeValues = new ArrayList<>();
      List<TreeNode> nodes = new ArrayList<>();
      final Iterator<TreeNode> it = treeNodes.iterator();
      while (it.hasNext()) {
        final TreeNode next = it.next();
        nodeValues.add(next.getVal());
        if (next.getLeft() != null) {
          nodes.add(next.getLeft());
        }
        if (next.getRight() != null) {
          nodes.add(next.getRight());
        }
        it.remove();
      }
      result.add(nodeValues);
      treeNodes.addAll(nodes);
    }
    return result;
  }

  private List<List<Integer>> levelOrderOpti(TreeNode node)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (node == null) {
      return result;
    }
    final LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.addFirst(node);
    while (!nodes.isEmpty()) {
      int level = nodes.size();
      final List<Integer> subResult = new ArrayList<>();
      for (int i = 0; i < level; i++) {
        final TreeNode curr = nodes.removeFirst();
        subResult.add(curr.getVal());
        if (curr.getRight() != null) {
          nodes.addFirst(curr.getRight());
        }
        if (curr.getLeft() != null) {
          nodes.addFirst(curr.getLeft());
        }
      }
      result.add(subResult);
    }
    return result;
  }

  private List<List<Integer>> zigZagOrderFailed(TreeNode node)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (node == null) {
      return result;
    }
    boolean isLeftToRight = false;
    final LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.addFirst(node);
    while (!nodes.isEmpty()) {
      int level = nodes.size();
      final List<Integer> subResult = new ArrayList<>();
      for (int i = 0; i < level; i++) {
        final TreeNode curr = nodes.removeFirst();
        subResult.add(curr.getVal());
        if (isLeftToRight) {
          if (curr.getLeft() != null) {
            nodes.add(curr.getLeft());
          }
          if (curr.getRight() != null) {
            nodes.add(curr.getRight());
          }
          isLeftToRight = false;
        } else {
          if (curr.getRight() != null) {
            nodes.add(curr.getRight());
          }
          if (curr.getLeft() != null) {
            nodes.add(curr.getLeft());
          }
          isLeftToRight = true;
        }
      }
      result.add(subResult);
    }
    return result;
  }

  private List<List<Integer>> zigZagOrder(TreeNode node)
  {
    List<List<Integer>> result = new ArrayList<>();
    if (node == null) {
      return result;
    }
    boolean isLeftToRight = false;
    final LinkedList<TreeNode> nodes = new LinkedList<>();
    nodes.offer(node);
    while (!nodes.isEmpty()) {
      int level = nodes.size();
      isLeftToRight = !isLeftToRight;
      final LinkedList<Integer> subResult = new LinkedList<>();
      while (level > 0) {
        final TreeNode curr = nodes.poll();
        if (isLeftToRight) {
          subResult.add(curr.getVal());
        } else {
          subResult.addFirst(curr.getVal());
        }
        if (curr.getLeft() != null) {
          nodes.offer(curr.getLeft());
        }
        if (curr.getRight() != null) {
          nodes.offer(curr.getRight());
        }
        level--;
      }
      result.add(subResult);
    }
    return result;
  }

  @Test
  public void testLevelOrderTraversal()
  {
    System.out.println(levelOrder(TreeUtils.stringToTreeNode("3,9,20,null,null,15,7")));
  }

  @Test
  public void testLevelOrderTraversalOptimized()
  {
    System.out.println(levelOrderOpti(TreeUtils.stringToTreeNode("3,9,20,null,null,15,7")));
  }

  @Test
  public void testZigZagTraversal()
  {
    System.out.println(zigZagOrder(TreeUtils.stringToTreeNode("3,9,20,null,null,15,7")));
    System.out.println(zigZagOrderFailed(TreeUtils.stringToTreeNode("3,9,20,null,null,15,7")));
  }

  @Test
  public void testZigZagTraversalSimplified()
  {
    System.out.println(zigZagOrder(TreeUtils.stringToTreeNode("3,9,20")));
  }

  @Test
  public void testZigZagTraversalFailed()
  {
    final TreeNode node = TreeUtils.stringToTreeNode("1,2,3,4,5");
    System.out.println(node);
    System.out.println(zigZagOrder(node));
  }
}
