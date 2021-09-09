package com.guidewire;

import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SiblingsOfNonNegativeIntegers {
        private static final String EMPTY_STRING = "";

    public int solution(int N) {
        if (N < 0 || N > 100000000)
            return -1;
        final String maxSiblingString = getSortedString(String.valueOf(N));
        try {
            return Integer.parseInt(maxSiblingString);
        } catch (NumberFormatException nfe) {
            System.out.println("Skipping the integer overflow exception, for :" + maxSiblingString);
            nfe.printStackTrace();
            return -1;
        }
    }

    private String getSortedString(String input) {
        return Stream.of(input.split(EMPTY_STRING))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());
    }

    @Test
    public void testMaxSibling() {
        System.out.println(solution(535));
        System.out.println(solution(123));
    }
}
