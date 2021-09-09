package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
  public static void main(String[] args) {
    //    final TreeMap<Integer, Integer> sortedNumbers = new TreeMap<>();
    //    for(Map.Entry<Integer, Integer> number : sortedNumbers.entrySet()){
    //      final Integer value = number.getValue();
    //      for (int i = 1; i <= value; i++) System.out.println(number.getKey());
    //    }
    //    final String[] strings = new String[]{};
    //    final List<String> strings1 = Arrays.asList(strings);
    //    System.out.println(bin(23, 3));
    //    System.out.println(kSub(5, Arrays.asList(5, 10, 11, 9, 5)));
    System.out.println(kSub(3, Arrays.asList(5, 1, 2, 3, 4, 1)));
  }

  static Integer bin(int n, int k) {
    //    long count = 0;
    //    //This performs a basic conversion from int to binary using divide by two and checking
    // even or odd
    //    while(n != 0){
    //      count += (n%2 == 0)?1:0;
    //      n/=2;
    //    }
    //    count = (long) Math.pow(2,count);
    //    System.out.println(count);
    final String binaryString = Integer.toBinaryString(n);
    int length = binaryString.length();
    if (length >= k) return Integer.parseInt(binaryString.substring(length - k, (length - k + 1)));
    return -1;
  }

  public static long kSub(int k, List<Integer> nums) {
    // Write your code here
    List<List<Integer>> subSequences = new ArrayList();
    for (int i = 0; i < k; i++) subSequences.add(new ArrayList());
    int sum = 0;
    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      subSequences.get(sum % k).add(i);
    }
    long kSequences = 0;
    for (int row = 0; row < subSequences.size(); row++) {
      if (row == 0) {
        kSequences += (subSequences.get(0).size() + ((subSequences.get(row).size() + 1) / 2));
      } else {
        kSequences += (subSequences.get(row).size() + ((subSequences.get(row).size() - 1) / 2));
      }
    }
    return kSequences;
  }

  static final class FrequencyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return 0;
    }
  }
}
