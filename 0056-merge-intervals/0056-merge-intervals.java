import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // First interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 2: Process remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Overlap
            if (nextStart <= end) {

                end = Math.max(end, nextEnd);

            } else {

                // No overlap
                result.add(new int[]{start, end});

                start = nextStart;
                end = nextEnd;
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}