package com.leetcode.searching;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class MergeIntervals {
    public List<Interval> mergeCrrct(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
            {
                end = Math.max(end, interval.end);
            } else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
//    intervals.sort(
//        (a, b) -> (a.start < b.start) || (a.end < b.end)
//                  ? -1
//                  : ((a.start == b.start && a.end == b.end) ? 0 : 1)
//    );
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> result = new ArrayList<Interval>();
        Interval curr = intervals.get(0);
        int i = 1;
        while (i < intervals.size() && intervals.get(i).start > curr.end) {
            result.add(curr);
            curr = intervals.get(i);
            i++;
        }
        while (i < intervals.size()) {
            if (curr.end >= intervals.get(i).start) {
                curr = new Interval(
                        Math.min(curr.start, intervals.get(i).start),
                        Math.max(curr.end, intervals.get(i).end)
                );
            } else {
                result.add(curr);
                curr = intervals.get(i);
            }
            i++;
        }
        if (curr != null) {
            result.add(curr);
        }
        return result;
    }

    public List<Interval> mergeOptimize(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    @Test
    public void testMergeInterval() {
        Interval a = new Interval(1, 3), b = new Interval(2, 6),
                c = new Interval(8, 10), d = new Interval(15, 18);
        System.out.println(merge(Arrays.asList(a, b, c, d)));
    }

    @Test
    public void testMergeIntervalFailure() {
        Interval a = new Interval(1, 4), b = new Interval(5, 6);
        System.out.println(merge(Arrays.asList(a, b)));
    }

    @Test
    public void testMergeIntervalSort() {
        Interval a = new Interval(1, 4), b = new Interval(0, 0);
        System.out.println(merge(Arrays.asList(a, b)));
    }

    @Test
    public void testMergeIntervalSortWithCrct() {
        Interval a = new Interval(1, 4), b = new Interval(0, 0);
        System.out.println(mergeCrrct(Arrays.asList(a, b)));
    }

    @Test
    public void testMergeIntervalOptimized() {
        Interval a = new Interval(1, 3), b = new Interval(2, 6),
                c = new Interval(8, 10), d = new Interval(15, 18);
        System.out.println(mergeOptimize(Arrays.asList(a, b, c, d)));
    }

    @Test
    public void testMeetingRooms() {
        Interval a = new Interval(0, 30), b = new Interval(5, 10),
                c = new Interval(15, 20);
        System.out.println(merge(Arrays.asList(a, b, c)));
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Interval.class.getSimpleName() + "[", "]")
                    .add("start=" + start)
                    .add("end=" + end)
                    .toString();
        }
    }
}
