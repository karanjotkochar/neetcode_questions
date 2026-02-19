import java.util.ArrayList;
import java.util.List;

public class q68_InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {1,3}, {4,6} };
        int[] newInterval = new int[]{2,5};
        insert(intervals, newInterval);

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Linear search
        // TC = O(n)
        // SC= O(n)

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // case 1: Add all intervals that come before new interval --> then go to add new interval
        while (i<n && intervals[i][1] < newInterval[0] ) {
            result.add(intervals[i]);
            i++;
        }

        // case 2: overlapping scenario: (Min of both, Max of both) --> then add new interval
        // condition IMP: end of new >= start of prev
        while (i<n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // case 3: add all remaining intervals after adding new interval
        while (i<n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray( new int[result.size()][] );
    }

}
