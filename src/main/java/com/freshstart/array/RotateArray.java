package com.freshstart.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArray {
    public ArrayList<Integer> rotateArray(List<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>(A);
        if (B >= A.size())
            B = A.size() - 1;
        rotate(ret, 0, B - 1);
        rotate(ret, B, A.size() - 1);
        rotate(ret, 0, A.size() - 1);
        return ret;
    }

    public ArrayList<Integer> rotateArrayIB(List<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; (i + B) % A.size() < A.size() && i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }


    private void rotate(List<Integer> arr, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    @Test
    public void testArrayRotation() {
        System.out.println(rotateArray(Arrays.asList(1, 2, 3, 4, 5, 6), 1));
        System.out.println(rotateArrayIB(Arrays.asList(1, 2, 3, 4, 5, 6), 1));
        System.out.println(rotateArrayIB(
                Arrays.asList(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35), 56));
        System.out.println(rotateArray(
                Arrays.asList(14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35), 56));
        System.out.println(rotateArrayIB(
                Arrays.asList(28, 68, 100, 90, 46, 58, 54, 74), 78));
    }

    @Test
    public void testWithOneElem() {
        System.out.println(rotateArrayIB(Collections.singletonList(1), 1));
    }
}
