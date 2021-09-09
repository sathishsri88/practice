package com.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayAlteration {
    private int[] alterArray(int[] a) {
        for (int i = 1; i < a.length; i++) {

        }
        List<Object> array = new ArrayList<>();
        int sum = 0, level = 1;
        return a;
    }

    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> array, int level) {
        int sum = 0;
        for (Object currentElem : array) {
            if (currentElem instanceof List) {
                sum += productSumHelper((List) currentElem, level + 1);
            } else if (currentElem instanceof Integer) {
                sum += (int) currentElem;
            }
        }
        return level * sum;
    }

}
