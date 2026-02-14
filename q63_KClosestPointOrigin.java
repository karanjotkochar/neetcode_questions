import java.util.Comparator;
import java.util.PriorityQueue;

public class q63_KClosestPointOrigin {

    public static void main(String[] args) {
        int[][] points = {{0,2},{2,2}};
        int k = 1;

        kClosest(points, k);
    }

    public static int[][] kClosest(int[][] points, int k) {
        // TC = O(n + k.logn)
        // Space = O(n)

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0])); // ** IMP: because only a[0] is being used to create Min-Heap **

        // calculate distance for each point and add three things(distance,x,y) in minHeap --> n
        for (int[] point : points) {
            int distance = (point[0]*point[0]) + (point[1]*point[1]);
            pq.offer(new int[]{distance, point[0], point[1]});
        }

        // Pop k Times and append to result but only (x,y) --> k.logn
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            int[] point = pq.poll();
            result[i] = new int[]{point[1], point[2]};
        }

        return result;
    }

}