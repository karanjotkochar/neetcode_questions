import java.util.*;

public class q65_TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','C','C'};
        int n = 2;
        leastInterval(tasks, n);
    }

    public static int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                pq.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int currTask = pq.poll() - 1;                            // take the element
                if (currTask > 0) {
                    q.add(new int[]{currTask, time + n});                // reduce by 1 and add the element to cooling queue
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {                  // check queue: when item is ready from the cooling queue
                pq.add(q.poll()[0]);                                    // add elemt back to max heap : FIFO
            }
        }

        return time;
    }

}
