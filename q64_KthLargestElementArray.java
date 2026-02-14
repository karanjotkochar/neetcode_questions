import java.util.Collections;
import java.util.PriorityQueue;

public class q64_KthLargestElementArray {

    public static void main(String[] args) {
        int[] nums = {2,3,1,5,4};
        int k = 2;

        findKthLargest(nums, k);
        findKthLargest2(nums, k);
    }

    public static int findKthLargest(int[] nums, int k) {
        // using Min Heap
        // size always of = k       (k largest seen so far)
        // TC =>  Insert = O(log k), n elements --> O(n.log k)
        // TC ==> Remove = O(log k), n elements --> O(n.log k)
        // SO, tc = O(n.log k)
        // Space = O(k)

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        // using Max Heap
        // TC =>  Insert  = O(log n), n elements --> O(n.log n)
        // TC ==> Remove = O(log n), k elements --> O(k.log n)
        // SO, tc = O(n.log n)
        // Space = O(n)

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {        // insert
            pq.offer(i);
        }

        for (int i=1; i<k; i++) {   // remove
            pq.poll();
        }

        return pq.peek();
    }
}
