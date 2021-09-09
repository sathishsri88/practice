package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
  private double dfs(String f, String s, Map<String, List<Node>> map, Set<String> visited) {
    if (!map.containsKey(f)) return -1;
    visited.add(f);
    if (f.equals(s)) return 1;
    double result = -1;
    for (Node n : map.get(f)) {
      if (!visited.contains(n.node)) {
        result = dfs(n.node, s, map, visited);
        if (result > 0) {
          return result * n.value;
        }
      }
    }
    return result;
  }

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    double[] result = new double[queries.length];
    Set<String> set = new HashSet<>();
    Map<String, List<Node>> map = new HashMap<>();
    for (int i = 0; i < equations.length; i++) {
      String f = equations[i][0];
      String s = equations[i][1];
      double v = values[i];
      set.add(f);
      set.add(s);
      List<Node> t = map.getOrDefault(f, new ArrayList<>());
      t.add(new Node(s, v));
      map.put(f, t);
      t = map.getOrDefault(s, new ArrayList<>());
      t.add(new Node(f, 1 / v));
      map.put(s, t);
    }
    for (int i = 0; i < queries.length; i++) {
      double answer;
      if (!set.contains(queries[i][0]) || !set.contains(queries[i][1])) {
        answer = -1.0;
      } else {
        answer = dfs(queries[i][0], queries[i][1], map, new HashSet<>());
      }
      result[i] = answer;
    }
    return result;
  }

  @Test
  public void testEvaluateDivision() {
    String[][] equations = new String[][] {{"a", "b"}, {"b", "c"}};
    double[] values = new double[] {2.0, 3.0};
    String[][] queries =
        new String[][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
    System.out.println(ArrayUtils.toString(calcEquation(equations, values, queries)));
  }

  private class Node {
    String node;
    double value;

    Node(String node, double value) {
      this.node = node;
      this.value = value;
    }
  }
}
