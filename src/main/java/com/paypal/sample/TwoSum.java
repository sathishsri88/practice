package com.paypal.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum
{

  public static void main(String[] args)
  {
//    final int[] result = new TwoSum().twoNumberSumSort(new int[]{2,7,11,15}, 9);
    final int[] result = new TwoSum().twoNumberSumSort(new int[]{4,6}, 10);
//    final int[] result = new TwoSum().twoNumberSumSort(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
//    final int[] result = new TwoSum().twoNumberSumReturnIndexBySort(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
    System.out.println(Arrays.toString(result));
  }

  public int[] twoNumberSum(int[] nums, int target)
  {
    // Write your code here.
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//    for (Integer n : nums) {
//      set.add(n);
//    }
//    for (int num : nums) {
//      int y = target - num;
//      if (y != num && set.contains(y)) {
//        return num < y ? new int[]{num, y} : new int[]{y, num};
//      }
//    }
    for (int i=0;i<nums.length;i++) {
      int y = target - nums[i];
      if(map.containsKey(y)){
        return new int[]{map.get(y),i};
      }
      map.put(nums[i],i);
    }

//    for (int i = 0; i < nums.length; i++) {
//      for (int j = i + 1; j < nums.length; j++) {
//        if (nums[i] + nums[j] == target) {
//          return nums[i] < nums[j] ? new int[]{nums[i], nums[j]} : new int[]{nums[j], nums[i]};
//        }
//      }
//    }
    return new int[]{};
  }

  public int[] twoNumberSumSort(int[] array, int targetSum)
  {
    java.util.Arrays.sort(array);
    int left=0,right=array.length-1;
    while(left<right){
      if(array[left]+array[right] == targetSum){
        return array[left] < array[right] ? new int[]{array[left], array[right]} : new int[]{array[right], array[left]};
      }else if(targetSum - array[left] > array[right]){
        left ++;
      }else{
        right --;
      }
    }
    return new int[]{};
  }

  public int[] twoNumberSumReturnIndexBySort(int[] array, int targetSum)
  {
    Arrays.sort(array);
    int left=0,right=array.length-1;
    while(left<right){
      if(array[left]+array[right] == targetSum){
        return array[left] < array[right] ? new int[]{left,right} : new int[]{right,left};
      }else if(targetSum - array[left] > array[right]){
        left ++;
      }else{
        right --;
      }
    }
    return new int[]{};
  }
}
