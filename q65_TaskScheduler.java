import java.util.*;

public class q65_TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','C','C'};
        int n = 2;
        leastInterval(tasks, n);
    }

    public static int leastInterval(char[] tasks, int n) {
        // Max heap or Priority Queue
        // TC = O(n)
        // Space = O(1)

        int[] count = new int[26];          // make a integer array

        for (char task : tasks) {           // make a frequency of chars
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pqHeap = new PriorityQueue<>(Collections.reverseOrder());    // max Heap
        for (int cnt : count) {
            if (cnt > 0) {
                pqHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!pqHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (pqHeap.isEmpty()) {                                     // Heap is empty and Queue is not empty
                time = q.peek()[1];                                     // So, next time == next available time (** this does the skip-ing **)
            } else {

                int currTask = pqHeap.poll() - 1;                       // take the element
                if (currTask > 0) {
                    q.add(new int[]{currTask, time + n});               // reduce by 1 and add the element to cooling queue
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {                  // check queue: when item is ready from the cooling queue
                pqHeap.add(q.poll()[0]);                                // add elemt back to max heap : FIFO
            }
        }

        return time;
    }

}
