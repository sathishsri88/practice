package com.practice.dp;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return word1 == null ? word2 != null ? word2.length() : 0 : 0;
        }
        if (word1.isEmpty() || word2.isEmpty())
            return word1.isEmpty() ? word2.isEmpty() ? 0 : word2.length() : word1.length();
        int n1 = word1.length();
        int n2 = word2.length();
        int[] prevRow = new int[n1 + 1];
        int[] currRow = new int[n1 + 1];
        for (int i = 1; i <= n1; i++) {
            prevRow[i] = i;
        }
        // Initialize the first column for '#'
        currRow[0] = 1;
        for (int row = 1; row <= n2; row++) {
            for (int col = 1; col <= n1; col++) {
                int leftDownValue = prevRow[col - 1];
                if (word2.charAt(row - 1) == word1.charAt(col - 1)) {
                    leftDownValue = leftDownValue - 1;
                }
                currRow[col] = 1 + Math.min(currRow[col - 1], Math.min(prevRow[col], leftDownValue));
            }
            prevRow = currRow;
            if (row < n2) {
                int nextValue = currRow[0];
                currRow = new int[n1 + 1];
                currRow[0] = nextValue + 1;
            }
        }
//        System.out.println(ArrayUtils.toString(prevRow));
//        System.out.println(ArrayUtils.toString(currRow));
        return currRow[n1];
    }

    public int minDistanceHelper(String s1, String s2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0)
            return 0;
//        if()
        return -1;
    }

    public int minDistanceHelper(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return word1 == null ? word2 != null ? word2.length() : 0 : 0;
        }
        if (word1.isEmpty() || word2.isEmpty())
            return word1.isEmpty() ? word2.isEmpty() ? 0 : word2.length() : word1.length();
        int[][] dp = new int[word1.length() + 1][word1.length() + 1];
        return minDistanceHelper(word1, word2, word1.length(), word2.length(), dp);
    }

    @Test
    public void testMinDistance() {
        System.out.println(minDistance("b", ""));
        System.out.println(minDistance("ab", "abc"));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
