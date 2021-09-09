package com.freshstart.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int top = 0, bottom = A.size() - 1, left = 0, right = A.get(0).size() - 1, resultPointer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            int currentIterator = left;
            while (currentIterator <= right) {
                result.add(resultPointer++, A.get(top).get(currentIterator++));
            }
            top++;
            currentIterator = top;
            while (currentIterator <= bottom) {
                result.add(resultPointer++, A.get(currentIterator++).get(right));
            }
            right--;
            if(top <= bottom) {
                currentIterator = right;
                while (currentIterator >= left) {
                    result.add(resultPointer++, A.get(bottom).get(currentIterator--));
                }
                bottom--;
            }
            if(left <= right) {
                currentIterator = bottom;
                while (currentIterator >= top) {
                    result.add(resultPointer++, A.get(currentIterator--).get(left));
                }
                left++;
            }
        }
        return result;
    }

    @Test
    public void testSpiralOrder1() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        System.out.println(spiralOrder(matrix));
    }

    @Test
    public void testSpiralOrder2() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
        System.out.println(spiralOrder(matrix));
    }

    @Test
    public void testSpiralOrderRowIssue() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Collections.singletonList(1)));
        matrix.add(new ArrayList<>(Collections.singletonList(2)));
        matrix.add(new ArrayList<>(Collections.singletonList(3)));
        System.out.println(spiralOrder(matrix));
    }
}
