import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q69_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals= new int[][]{ {1,3}, {1,5}, {6,7} };
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {

        // Sorting
        // TC = O(n.logn)
        // SC = O(n)

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));       // sorting

        List<int[]> result= new ArrayList<>();
        result.add(intervals[0]);                                           // add first element


        for (int[] i : intervals) {
            int start = i[0];
            int end = i[1];

            int[] prevInt = result.get(result.size() - 1);                  // **IMP get the value from result (values added in this process) and not intervals array
            int prevIntEnd = prevInt[1];

            // start @ second <= end of first
            if (start <= prevIntEnd) {                                      // current interval overlaps with the last one --> update end
                prevInt[1] = Math.max(end, prevIntEnd);

            } else {                                                        // no overlap -- new interval
                result.add(new int[]{start, end});
            }
        }

        return result.toArray( new int[result.size()][] );
    }

}
