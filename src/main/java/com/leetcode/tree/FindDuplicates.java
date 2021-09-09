package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.TreeUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
  private List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> res = new LinkedList<>();
    postorder(root, new HashMap<>(), res);
    return res;
  }

  private String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
    if (cur == null) return "#";
    String serial =
        cur.getValue()
            + ","
            + postorder(cur.getLeft(), map, res)
            + ","
            + postorder(cur.getRight(), map, res);
    if (map.getOrDefault(serial, 0) == 1) res.add(cur);
    map.put(serial, map.getOrDefault(serial, 0) + 1);
    return serial;
  }

  @Test
  public void testFindDuplicateSubTrees() {
    System.out.println(
        findDuplicateSubtrees(
            TreeUtils.stringToTreeNode("1,2,3,4,null,2,4,null,null,4,null,null,null,null")));
  }
}
