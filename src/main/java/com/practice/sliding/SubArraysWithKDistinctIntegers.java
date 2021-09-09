package com.practice.sliding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDistinctIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    @Test
    public void testSubArraysWithKdistinct() {
        System.out.println(atMostK(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(atMostK(new int[]{1, 2, 1, 2, 3}, 1));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
