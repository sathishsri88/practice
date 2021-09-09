package com.practice.dp;

import org.junit.Test;

public class Fibonnaci {
    int fib(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n - 1] > 0)
            return dp[n - 1];
        dp[n - 1] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n - 1];
    }

    @Test
    public void testFib() {
        int size = 6;
        int[] dp = new int[size + 1];
        System.out.println(fib(size, dp));
    }
}
