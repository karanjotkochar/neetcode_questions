import java.util.Arrays;

public class q70_NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {1,2}, {2,4}, {1,4} };
        eraseOverlapIntervals(intervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Greedy. sorting by start
        // TC = O(n.logn)
        // SC = O(n)

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int result = 0;

        int prevStart = intervals[0][0];                    // take i = 0
        int prevEnd = intervals[0][1];

        for (int i=1; i<n; i++) {                           // iterate from i = 1

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (prevEnd <= currStart) {                     // end of first <= start of second --> no overlap
                prevEnd = currEnd;                          // ** why? --> no overlap, so keep this interval --> prevEnd = end, avoid other overlapping

            } else {
                result++;
                prevEnd = Math.min(prevEnd, currEnd);       // in overlap, remove the one woth smaller end time

            }
        }

        return result;
    }

}
