package com.practice.subsets;

import org.junit.Test;

public class SubSetSum {
    boolean isSubSetSum(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }
        return isSubSetSumHelper(arr, sum, dp);
    }

    boolean isSubSetSumHelper(int[] arr, int sum, boolean[][] dp) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    boolean isEqualPartiton(int[] arr, int sum) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0)
            return false;
        else {
            return isSubSetSum(arr, sum / 2);
        }
    }

    @Test
    public void testSubSetSum() {
        System.out.println(isSubSetSum(new int[]{2, 3, 7, 8, 10}, 11));
        final boolean equalPartiton = isEqualPartiton(new int[]{1, 5, 11, 5}, 11);
        System.out.println(equalPartiton);
        assert equalPartiton;
    }

    int countOfSubSetsWithSum(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }
        return countOfSubSetsWithSumHelper(arr, sum, dp);
    }

    int countOfSubSetsWithSumHelper(int[] arr, int sum, int[][] dp) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    @Test
    public void testCountOfSubsets() {
        System.out.println(countOfSubSetsWithSum(new int[]{2, 3, 5, 6, 8, 10}, 10));

    }
}
