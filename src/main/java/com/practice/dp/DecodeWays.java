package com.practice.dp;

import org.junit.Test;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current = oneBack;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    @Test
    public void testDecodeWays() {
        System.out.println(numDecodings("12"));
    }

    int findWays(int[] nums, int n, int[] dp) {
        /*int[] ways = new int[n + 1];
        ways[0] = 1;
//        ways[1] = 1;
//        ways[2] = 1;
//        ways[3] = 2;
//        ways[4] = 3;
//        ways[5] = 5;
        int noOfWays = 0;
        for (int num : nums) {
            if (n - num >= 0) {
                noOfWays += ways[n - num];
            } else {
                n = n - num;
            }
        }
        ways[n - 1] = noOfWays;
        return noOfWays;*/
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = findWays(nums, n - 1, dp) + findWays(nums, n - 3, dp) + findWays(nums, n - 5, dp);
        return dp[n];
    }

    @Test
    public void testFindWaysToReturnN() {
        int n = 7;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
//        System.out.println(findWays(new int[]{1, 3, 5}, 1));
        System.out.println(findWays(new int[]{1, 3, 5}, n, dp));
    }
}
