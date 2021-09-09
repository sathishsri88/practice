package com.practice.dp;

import org.junit.Test;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        final StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        while (currentIndex < s.length()) {
            for (int row = 0; row < numRows; row++) {
                if (currentIndex >= s.length())
                    return result.toString();
                final char currentChar = s.charAt(currentIndex++);
                result.append(currentChar);
            }
            for (int row = numRows - 1; row >= 0; row--) {
                if (currentIndex >= s.length())
                    return result.toString();
                final char currentChar = s.charAt(currentIndex++);
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    @Test
    public void testConvert() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
