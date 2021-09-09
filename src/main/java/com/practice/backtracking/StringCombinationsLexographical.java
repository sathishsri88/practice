package com.practice.backtracking;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringCombinationsLexographical
{
  void lexographicCombinations(char[] input, char[] output, int pos)
  {
    printUntilLength(output, pos);
    for (int i = pos; i < input.length; i++) {
      if (input[i] == output[pos]) {
        continue;
      }
      output[pos] = input[i];
      lexographicCombinations(input, output, i + 1);
      i = i - 1;
//      pos = 0;
    }
  }

  private void printUntilLength(char[] output, int length)
  {
    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      builder.append(output[i]);
    }
    if (builder.length() > 0) {
      System.out.println(builder.toString());
    }
  }

  private void allCombinationsinLexographicOrder(char[] input, int[] count, char[] output, int length)
  {
    printUntilLength(output, length);
    for (int i = 0; i < input.length; i++) {
      if (count[i] == 0) {
        continue;
      }
      output[length] = input[i];
      count[i]--;
      allCombinationsinLexographicOrder(input, count, output, length + 1);
      count[i]++;
    }
  }

  private void combinations(char[] input, int[] count, char[] output, int pos, int length)
  {
    printUntilLength(output, length);
    for (int i = pos; i < input.length; i++) {
      if (count[i] == 0) {
        continue;
      }
      output[length] = input[i];
      count[i]--;
      combinations(input, count, output, i, length + 1);
      count[i]++;
    }
  }

  void printCombinations(char[] input, int isAllCombinations)
  {
    final Map<Character, Integer> sizeMap = getSizeMap(input);
    final char[] inputArray = new char[sizeMap.size()];
    int i = 0;
    for (Character c : sizeMap.keySet()) {
      inputArray[i++] = c;
    }
    final int[] count = sizeMap.values().stream().mapToInt(c -> c).toArray();
    if (isAllCombinations == 1) {
      allCombinationsinLexographicOrder(inputArray, count, new char[input.length], 0);
    } else {
      combinations(inputArray, count, new char[input.length], 0, 0);
    }
  }


  private Map<Character, Integer> getSizeMap(char[] input)
  {
    final HashMap<Character, Integer> sizeMap = new HashMap<Character, Integer>();
    for (char c : input) {
      if (sizeMap.containsKey(c)) {
        sizeMap.put(c, sizeMap.get(c) + 1);
      } else {
        sizeMap.put(c, 1);
      }
    }
    return sizeMap;
  }

  @Test
  public void testLexographicStringPrint()
  {
    final StringCombinationsLexographical lexographical = new StringCombinationsLexographical();
    lexographical.lexographicCombinations("ABC".toCharArray(), new char[3], 0);
  }

  @Test
  public void testStringCombinations()
  {
    final StringCombinationsLexographical lexographical = new StringCombinationsLexographical();
//    lexographical.printCombinations("ABC".toCharArray());
//    lexographical.printCombinations("AABC".toCharArray(), 0);
//    lexographical.printCombinations("DE".toCharArray(), 0);
    System.out.println("--------------------------------------------------");
    lexographical.printCombinations("DE".toCharArray(), 1);
  }
}
