package com.practice.arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public int findMaxSumSubArray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - k];
            }
            windowSum += arr[i];
        }
        return Math.max(maxSum, windowSum);
    }

    @Test
    public void testFindMaxSumSubArray() {
        int[] arr = new int[]{3, 2, 1, 5, 1, 3, 2};
        System.out.println(findMaxSumSubArray(arr, 3));
        arr = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(findMaxSumSubArray(arr, 3));
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMaxSumSubArray(arr, 2));
    }

    public static int findMinContSubArray(int[] arr, int k) {
        int minSum = Integer.MAX_VALUE, windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                minSum = Math.min(windowSum, minSum);
                windowSum -= arr[i - k];
            }
            windowSum += arr[i];
        }
        return Math.min(windowSum, minSum);
    }

    @Test
    public void testFindContMinSumSubArray() {
        int[] arr = new int[]{3, 2, 1, 5, 1, 3, 2};
        System.out.println(findMinContSubArray(arr, 3));
        arr = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(findMinContSubArray(arr, 2));
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMinContSubArray(arr, 2));
    }

    public static int findMinSubArrayTrial1(int S, int[] arr) {
        int windowStart = 0, windowEnd = 0, windowSum = 0, minLength = Integer.MAX_VALUE;
        while (windowStart <= windowEnd && arr.length > windowEnd) {
            if (windowSum < S) {
                windowSum += arr[windowEnd];
                windowEnd++;
            } else {
                minLength = Math.min((windowEnd - windowStart + 1), minLength);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength;
    }

    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0, windowSum = 0, minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                // +1 to indicate the length of the string
                minLength = Math.min(minLength, (windowEnd - windowStart) + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    @Test
    public void testFindMinSubArray() {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArray(7, arr));
        arr = new int[]{2, 1, 5, 2, 8};
        System.out.println(findMinSubArray(7, arr));
        arr = new int[]{3, 4, 1, 1, 6};
        System.out.println(findMinSubArray(8, arr));
    }

    public int longestSubStringWithKDistinct(String str, int k) {
        int result = 0;
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            if (map.keySet().size() < k || map.get(ch) != null) {
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);

                }
                result++;
            } else {
                int count = map.get(str.charAt(start));
                if (count == 1) {
                    map.remove(str.charAt(start));
                    map.put(str.charAt(end), 1);
                } else {
                    map.put(str.charAt(start), str.charAt(start) - 1);

                }
                start++;
            }

        }
        return result;
    }

    public int longestSubstringKDistinct(String str, int k) {
        final Map<Character, Integer> dictionary = new HashMap<>();
        int windowStart = 0, maxStringLength = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char currChar = str.charAt(windowEnd);
            dictionary.put(currChar, dictionary.getOrDefault(currChar, 0) + 1);
            while (dictionary.get(currChar) >= k) {
                maxStringLength = Math.max(maxStringLength, (windowEnd - windowStart) + 1);
                dictionary.put(str.charAt(windowStart), dictionary.get(currChar) - 1);
                windowStart++;
            }
        }
        return maxStringLength == Integer.MIN_VALUE ? str.length() : maxStringLength;
    }

    @Test
    public void testLongestSubstringKDistinct() {
        System.out.println(longestSubStringWithKDistinct("araaci", 2));
        System.out.println(longestSubStringWithKDistinct("araaci", 1));
        System.out.println(longestSubStringWithKDistinct("cbbebi", 3));
    }

    public int findMaxLengthNoRepeatSubstring(String str) {
        int windowStart = 0, maxLength = 0;
        final Map<Character, Integer> wordFreqMap = new HashMap<>();
//        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//            char LO = str.charAt(windowEnd);
//            if (wordFreqMap.containsKey(rightChar)) {
//                windowStart = Math.max(windowStart, wordFreqMap.get(rightChar) + 1);
//            }
//            wordFreqMap.put(rightChar, windowEnd);
//            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
//        }
        return maxLength;
    }

    public int findMaxLengthNoRepeatSubstringOption2(String str) {
        int windowStart = 0, maxLength = 0;
        final Map<Character, Integer> wordFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            wordFreqMap.put(rightChar, wordFreqMap.getOrDefault(rightChar, 0) + 1);
            while (wordFreqMap.get(rightChar) > 1) {
                char leftChar = str.charAt(windowStart);
                wordFreqMap.put(leftChar, wordFreqMap.get(leftChar) - 1);
                if (wordFreqMap.get(leftChar) == 0) {
                    wordFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    @Test
    public void testNoRepeatSubstring() {
        System.out.println(findMaxLengthNoRepeatSubstring("aabccbb"));
        System.out.println(findMaxLengthNoRepeatSubstring("abbbb"));
        System.out.println(findMaxLengthNoRepeatSubstring("abccde"));
    }

    public float[] findSlidingWindowMedian(int[] a, int k) {
        int sum = 0;
        float[] median = new float[a.length - k + 1];
        int kCounter = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (i - k + 1 >= 0) {
//                median[kCounter++] = (float) sum / (float) k;
                median[kCounter++] = sum;
                sum -= a[i - k + 1];
            }
        }
        return median;
    }

    @Test
    public void testFindSlidingWindowMedian() {
        System.out.println(ArrayUtils.toString(findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2)));
        System.out.println(ArrayUtils.toString(findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3)));
    }
}
