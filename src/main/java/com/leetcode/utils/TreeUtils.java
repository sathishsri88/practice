package com.leetcode.utils;

import com.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    //    input = input.substring(0, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item), "");
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.setLeft(new TreeNode(leftNumber, ""));
        nodeQueue.add(node.getLeft());
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.setRight(new TreeNode(rightNumber, ""));
        nodeQueue.add(node.getRight());
      }
    }
    return root;
  }

  public static TreeNode stringToAlphabeticTreeNode(String input) {
    input = input.trim();
    //    input = input.substring(0, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(0, item);
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        node.setLeft(new TreeNode(0, item));
        nodeQueue.add(node.getLeft());
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        node.setRight(new TreeNode(0, item));
        nodeQueue.add(node.getRight());
      }
    }
    return root;
  }

  public static String treeToString(TreeNode node) {
    if (node == null) return "";
    final String NULL_IDENTIFIER = "null";
    final StringBuilder serializedTree = new StringBuilder();
    final Queue<TreeNode> queue = new LinkedList<>();
    serializedTree.append(node.getVal());
    queue.offer(node);
    while (!queue.isEmpty()) {
      final TreeNode queryNode = queue.poll();
      if (queryNode.getLeft() != null) {
        serializedTree.append(",").append(queryNode.getLeft().getVal());
        queue.offer(queryNode.getLeft());
      } else {
        serializedTree.append(",").append(NULL_IDENTIFIER);
      }
      if (queryNode.getRight() != null) {
        serializedTree.append(",").append(queryNode.getRight().getVal());
        queue.offer(queryNode.getRight());
      } else {
        serializedTree.append(",").append(NULL_IDENTIFIER);
      }
    }
    return serializedTree.toString();
  }

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void printValue(TreeNode node, boolean isAlphabetic) {
    if (!isAlphabetic) {
      System.out.print(node.getVal() + " -> ");
    } else {
      System.out.print(node.getValue() + " -> ");
    }
  }

  public static void printValue(TreeNode node1, TreeNode node2, boolean isAlphabetic) {
    if (!isAlphabetic) {
      System.out.print(node1.getVal() + " & " + node2.getVal() + " -> ");
    } else {
      System.out.print(node1.getValue() + " & " + node2.getValue() + " -> ");
    }
  }
}
