import java.util.PriorityQueue;

public class q57_KLargestElementStream {
    private PriorityQueue<Integer> minHeap;
    private int k;
    // IMP -- we need minHeap of size 'k' and the "kth' largest value  = minimum value in size 'k'

    public q57_KLargestElementStream(int k, int[] nums) {
        // time  = O(nlogn), add/pop in heap = O(logn) and find min = O(1)
        // space = O(n)

        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
