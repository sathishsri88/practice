package com.leetcode.searching;

import org.junit.Test;

import java.util.Arrays;

public class MinMeetingRooms
{
  public int minMeetingRooms(MergeIntervals.Interval[] intervals)
  {
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i].start;
      ends[i] = intervals[i].end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int rooms = 0;
    for (int i = 0, endItr = 0; i < starts.length; i++) {
      if (starts[i] < ends[endItr]) {
        rooms++;
      } else {
        endItr++;
      }
    }
    return rooms;
  }

  @Test
  public void testMeetingRooms()
  {
    MergeIntervals.Interval a = new MergeIntervals.Interval(0, 30), b = new MergeIntervals.Interval(5, 10),
        c = new MergeIntervals.Interval(15, 20);
    System.out.println(minMeetingRooms(new MergeIntervals.Interval[]{a, b, c}));
  }
}
