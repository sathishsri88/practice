package com.practice.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        final List<Interval> mergedIntervals = new LinkedList<>();
        if (intervals == null || intervals.isEmpty())
            return mergedIntervals;
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int currStart = intervals.get(0).start, currEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            final Interval currInterval = intervals.get(i);
            if (currEnd >= currInterval.start) {
                currEnd = Math.max(currInterval.end, currEnd);
            } else {
                mergedIntervals.add(new Interval(currStart, currEnd));
                currStart = currInterval.start;
                currEnd = currInterval.end;
            }
        }
        mergedIntervals.add(new Interval(currStart, currEnd));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

