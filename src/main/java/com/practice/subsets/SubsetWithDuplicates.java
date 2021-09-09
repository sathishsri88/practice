package com.practice.subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here
        subsets.add(new ArrayList<Integer>());
        for (Integer num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                final List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                if (!subsets.contains(subset)) {
                    subsets.add(subset);
                }
            }
        }
        return subsets;
    }

    @Test
    public void testFindSubsets() {
        System.out.println(findSubsets(new int[]{1, 3, 3}));
        System.out.println(findSubsets(new int[]{1, 5, 3, 3}));
        // [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
    }
}
