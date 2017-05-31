package binarySearch;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/find-right-interval/#/description
 */
public class FindRightInterval {
    class Interval {
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
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] rets = new int[intervals.length];
        int[] starts = new int[intervals.length];
        HashMap<Integer, Integer> startIndex = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            startIndex.put(starts[i], i);
        }
        Arrays.sort(starts);
        for (int i = 0; i < intervals.length; i++) {
            int pos = Arrays.binarySearch(starts, intervals[i].end);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            rets[i] = pos < starts.length ? startIndex.get(starts[pos]) : -1;
        }
        return rets;
    }
}
