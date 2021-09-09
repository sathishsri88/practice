package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

public class SymmetricTree
{
  private boolean isSymmetricNonWorking(TreeNode node)
  {
    if (node == null) {
      return true;
    }
    System.out.println("Received node -> " + node.getVal()
                       + ", leftVal -> " + node.getLeft()
                       + ", rightVal -> " + node.getRight());
    if (node.getLeft() == null && node.getRight() == null) {
      return true;
    } else if ((node.getLeft() != null && node.getRight() == null) || (node.getLeft() == null
                                                                       && node.getRight() != null)) {
      return false;
    } else if (node.getLeft().getVal() != node.getRight().getVal()) {
      return false;
    }
    return isSymmetricNonWorking(node.getLeft()) && isSymmetricNonWorking(node.getRight());
  }

  private boolean isSymmetric(TreeNode node)
  {
    return node == null || isSymmetricHelper(node, node.getLeft(), node.getRight());
  }

  private boolean isSymmetricHelper(TreeNode node, TreeNode left, TreeNode right)
  {
    System.out.println("Comparing -> " + node.getVal()
                       + " leftVal -> " + left
                       + ", rightVal -> " + right);
    if (left == null || right == null) {
      return left == right;
    }
    if (left.getVal() != right.getVal()) {
      return false;
    }
    return isSymmetricHelper(left, left.getLeft(), right.getRight())
           && isSymmetricHelper(right, left.getRight(), right.getLeft());
  }

  public boolean isSymmetricOpti(TreeNode root)
  {

    if (root == null) {
      return true;
    }

    if (root.getLeft() == null && root.getRight() == null) {
      return true;
    }

    return check(root.getLeft(), root.getRight());


  }

  public boolean check(TreeNode left, TreeNode right)
  {

    if ((left == null && right != null) || (left != null && right == null)) {
      return false;
    }

    if (left == null) {
      return true;
    }

    if (left.getVal() == right.getVal()) {
      return check(left.getLeft(), right.getRight()) && check(left.getRight(), right.getLeft());
    }

    return false;

  }

  @Test
  public void testIsMirror()
  {
    System.out.println(isSymmetric(TreeUtils.stringToTreeNode("1,2,2")));
    System.out.println(isSymmetric(TreeUtils.stringToTreeNode("1,2,2,3,4,4,3")));
  }

  @Test
  public void testIsMirrorOpti()
  {
    System.out.println(isSymmetricOpti(TreeUtils.stringToTreeNode("1,2,2")));
    System.out.println(isSymmetricOpti(TreeUtils.stringToTreeNode("1,2,2,3,4,4,3")));
  }
}
