package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

public class ValidateBST {

  private boolean isValid(TreeNode root) {
    return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBSTHelper(TreeNode node, long leftVal, long rightVal) {
    if (node == null) {
      return true;
    }
    System.out.println(
        "Received node -> "
            + node.getVal()
            + ", leftVal -> "
            + leftVal
            + ", rightVal -> "
            + rightVal);
    if (node.getVal() <= leftVal || node.getVal() >= rightVal) {
      return false;
    }
    boolean leftValid = isValidBSTHelper(node.getLeft(), leftVal, node.getVal());
    return leftValid && isValidBSTHelper(node.getRight(), node.getVal(), rightVal);
  }

  @Test
  public void testIsValid() {
    // [5,1,4,null,null,3,6]
    //    final TreeNode node = TreeUtils.stringToTreeNode("5,1,4,null,null,3,6");
    //    System.out.println(node);

    final TreeNode node = TreeUtils.stringToTreeNode("2,1,3");
    System.out.println(node);
    System.out.println(isValid(node));
    System.out.println(isValid(TreeUtils.stringToTreeNode("5,1,4,null,null,3,6")));
  }

  @Test
  public void testIsValidBSTForIdenticalValue() {
    System.out.println(isValid(TreeUtils.stringToTreeNode("1,1")));
    System.out.println(isValid(TreeUtils.stringToTreeNode("2147483647")));
  }

  @Test
  public void testTreeSerializer() {
    final TreeNode node = TreeUtils.stringToTreeNode("5,1,4,null,null,3,6");
    final String str = TreeUtils.treeToString(node);
    System.out.println(str);
    System.out.println(TreeUtils.stringToTreeNode(str));
  }
}
