import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Intervals {
    public int start, end;
    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class q79_MeetingRooms2 {
    public static void main(String[] args) {
        List<Intervals> intervals = new ArrayList<>();
        intervals.add(new Intervals(0, 40));
        intervals.add(new Intervals(5, 10));
        intervals.add(new Intervals(15, 20));
        // minMeetingRooms(intervals);
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(List<Intervals> intervals) {
        // Two Pointer approach
        // TC = O(n.logn)
        // SC = O(n)

        int n = intervals.size();
        int[] start = new int[n];                       // maintain 2 arrays: start values and end values
        int[] end = new int[n];

        for (int i =0; i<n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);                             // sort these 2 arrays
        Arrays.sort(end);

        int count = 0;                                  // count will do increment and result is answer
        int result = 0;
        int s = 0;
        int e = 0;

        while (s<n) {
            if (start[s] < end[e]) {                    // start value less than end value --> meeting going count +1, s+1
                s++;
                count++;
            } else {                                    // end value greater --> meeting ends --> e+1 and count -1
                e++;                                    // ** EDGE case: meeting end and starts at the same time here
                count--;
            }
            result = Math.max(result, count);
        }

        return result;
    }

}
