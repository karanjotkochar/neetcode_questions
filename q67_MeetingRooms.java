import java.util.*;

class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}


public class q67_MeetingRooms {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,20));

        System.out.println(intervals);                              // by over-riding toString function
        System.out.println(intervals.size());

        Boolean ans = canAttendMeetings(intervals);
        System.out.println(ans);

        Boolean ans2 = canAttendMeetings2(intervals);
        System.out.println(ans2);
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        // Brute force
        // TC = O(n.n)
        // SC = O(1)
        int n = intervals.size();
        for (int i=0; i<n; i++) {
            Interval A = intervals.get(i);

            for (int j=i+1; j<n; j++) {
                Interval B = intervals.get(j);

                if (Math.min(A.end, B.end) > Math.max(A.start, B.start)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canAttendMeetings2(List<Interval> intervals) {
        // Sorting
        // TC = O(n.logn)
        // SC = O(1) or O(n)

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i-1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }

}
