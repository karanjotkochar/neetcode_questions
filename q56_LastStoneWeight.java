import java.util.PriorityQueue;

public class q56_LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,3,6,2,4};
//        lastStoneWeight(stones);
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {

        // Priority queue --> by default is Min Heap
        // negating it to make it Max Heap

        // time = o(n) to make heap and o(logn) to get max
        // time = O(nlogn)
        // space = O(n)

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int s : stones) {
            minHeap.offer(-s);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            // if second == first --> stones smashed
            // in positives: first always greater than second (second cannot be less than first)
            // in negatives: second > first
            if (second > first) {
                minHeap.offer(first - second);
            }
        }

        // edge case: if all stones smashed out, add 0 at the end
        minHeap.offer(0);

        return Math.abs(minHeap.peek());
    }
}
