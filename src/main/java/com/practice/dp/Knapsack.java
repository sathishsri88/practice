package com.practice.dp;

import java.util.Arrays;

public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        int knapsackStartElement = 0;
        int maxProfit = 0;
        int currWeight = 0, currProfit = 0;
        for (int i = 0; i < weights.length; i++) {
            currWeight += weights[i];
            currProfit += profits[i];
            while (currWeight > capacity) {
                currWeight -= weights[knapsackStartElement - capacity + 1];
                currProfit -= profits[knapsackStartElement - capacity + 1];
                knapsackStartElement++;
            }
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        //TODO: Write - Your - Code
        if (capacity <= 0 && profits.length == 0 && profits.length != weights.length)
            return 0;
        int[][] dp = new int[weights.length][capacity + 1];
        // Populate the first row
        for (int i = 1; i <= capacity; ) {
            if (weights[i] >= capacity) {
                dp[0][i] = profits[i];

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
//        int maxProfit = ks.solveKnapsack(profits, weights, 7);
//        System.out.println("Total knapsack profit ---> " + maxProfit);
//        maxProfit = ks.solveKnapsack(profits, weights, 6);
//        System.out.println("Total knapsack profit ---> " + maxProfit);
//        int[] profits = {1, 6};
//        int[] weights = {1, 2};
        final int currentCapacity = 7;
        int maxProfit = ks.solveKnapsackHelper(currentCapacity, 0, profits, weights);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        int[][] dp = new int[currentCapacity + 1][profits.length + 1];
        resetDP(dp);
        maxProfit = ks.solveKnapsackHelperMemo(profits, weights, currentCapacity, profits.length, dp);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        int[] p1 = new int[]{1, 3, 4, 5};
        int[] w1 = new int[]{1, 4, 5, 7};
        resetDP(dp);
        maxProfit = ks.solveKnapsackHelperMemo(p1, w1, currentCapacity, profits.length, dp);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private static void resetDP(int[][] dp) {
        for (int[] row : dp)
            Arrays.fill(row, -1);
    }

    private int solveKnapsackHelper(int currentCapacity, int currentIndex, int[] profits, int[] weights) {
        if (currentCapacity <= 0 || currentIndex >= profits.length)
            return 0;
        int maxProfit1 = 0;
        if (currentCapacity - weights[currentIndex] >= 0)
            maxProfit1 = profits[currentIndex] + solveKnapsackHelper(currentCapacity - weights[currentIndex],
                    currentIndex + 1, profits, weights);
        int maxProfit2 = solveKnapsackHelper(currentCapacity,
                currentIndex + 1, profits, weights);
        return Math.max(maxProfit1, maxProfit2);
    }

    private int solveKnapsackHelperMemo(int[] profits, int[] weights, int currentCapacity, int currentIndex, int[][] dp) {
        if (currentCapacity == 0 || currentIndex == 0)
            return 0;
        if (dp[currentCapacity][currentIndex] >= 0) {
            return dp[currentCapacity][currentIndex];
        }
        int maxProfit1 = 0;
        if (currentCapacity - weights[currentIndex - 1] >= 0)
            maxProfit1 = profits[currentIndex - 1] + solveKnapsackHelperMemo(profits, weights,
                    currentCapacity - weights[currentIndex - 1], currentIndex - 1, dp);
        int maxProfit2 = solveKnapsackHelperMemo(profits, weights,
                currentCapacity, currentIndex - 1, dp);
        dp[currentCapacity][currentIndex] = Math.max(maxProfit1, maxProfit2);
        return dp[currentCapacity][currentIndex];
    }

}