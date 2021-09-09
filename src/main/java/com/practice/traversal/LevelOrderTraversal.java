package com.practice.traversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        if (root == null) {
            return result;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelValues = traverse(queue);
            result.add(levelValues);
        }
        return result;
    }

    private static List<Integer> traverse(Queue<TreeNode> queue) {
        int levelSize = queue.size();
        List<Integer> levelValues = new ArrayList<>(levelSize);
        for (int i = 0; i < levelSize; i++) {
            final TreeNode currNode = queue.poll();
            assert currNode != null;
            levelValues.add(currNode.val);
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
        return levelValues;
    }

    public static List<List<Integer>> reverseLevelOrderTraversal(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) {
            return result;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final List<Integer> levelValues = traverse(queue);
            result.add(0, levelValues);
        }
        return result;
    }

    public static List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) {
            return result;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                final TreeNode currNode = queue.poll();
                assert currNode != null;
                if (level % 2 == 0) {
                    levelValues.add(currNode.val);
                } else {
                    levelValues.add(0, currNode.val);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(levelValues);
            level++;
        }
        return result;
    }

    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                final TreeNode currNode = queue.poll();
                assert currNode != null;
                levelSum += currNode.val;
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(levelSum / levelSize);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Level order traversal: " + LevelOrderTraversal.levelOrderTraversal(root));
        System.out.println("Reverse Level order traversal: " + LevelOrderTraversal.reverseLevelOrderTraversal(root));
        System.out.println("ZigZag Level order traversal: " + LevelOrderTraversal.zigZagLevelOrderTraversal(root));
        System.out.println(LevelOrderTraversal.findLevelAverages(root));
    }
}
