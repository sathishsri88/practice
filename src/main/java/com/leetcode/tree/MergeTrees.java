package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

public class MergeTrees
{

  private TreeNode mergeTrees(TreeNode t1, TreeNode t2)
  {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeUtils.printValue(t1, t2, false);
    t1.setVal(t1.getVal() + t2.getVal());
    t1.setLeft(mergeTrees(t1.getLeft(), t2.getLeft()));
    t1.setRight(mergeTrees(t1.getRight(), t2.getRight()));
    return t1;
  }

  @Test
  public void testMergeTrees()
  {
    final TreeNode t1 = TreeUtils.stringToTreeNode(
        "1,2,null");
    final TreeNode t2 = TreeUtils.stringToTreeNode(
        "3,1,4");
    final TreeNode x = mergeTrees(t1, t2);
    System.out.println();
    System.out.println(x);
  }
}
