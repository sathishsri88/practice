package com.freshstart.search;

import org.junit.Test;

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int M = L + (R - L) / 2;
            if (arr[M] >= target) {
                R = M;
            } else {
                L = M + 1;
            }
        }
        return L == R && arr[L] == target ? L : -1;
    }

    public int binarySearchR(int[] arr, int L, int R, int target) {
        if (L == R)
            return arr[L] == target ? L : -1;
        int M = L + (R - L) / 2;
        if (arr[M] >= target) {
            return binarySearchR(arr, L, M, target);
        } else {
            return binarySearchR(arr, M + 1, R, target);
        }
    }

    @Test
    public void testBSearch() {
        int[] arr = {1, 3, 5, 7, 11, 13, 17};
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 13));
//        System.out.println(binarySearch(arr, 15));
//        System.out.println(binarySearch(arr, 4));
    }

    @Test
    public void testBSearchR() {
        int[] arr = {1, 3, 5, 7, 11, 13, 17};
        System.out.println(binarySearchR(arr, 0, arr.length, 3));
        System.out.println(binarySearchR(arr, 0, arr.length, 13));
        System.out.println(binarySearchR(arr, 0, arr.length, 15));
    }
}
