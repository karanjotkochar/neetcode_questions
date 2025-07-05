import java.util.*;

public class q6_kFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1,2,2,3,3,3,3,7,7,7};
        int k = 2;
        topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // brute force method
        // time O(n) = O(nlogn) and space = O(n)
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i,0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {

            arr.add(new int[] {entry.getKey(), entry.getValue()});

        }
        arr.sort((a,b) -> b[1] - a[1]);
        arr.forEach(a -> System.out.println(Arrays.toString(a)));

        int[] result = new int[k];
        for (int i=0; i < k; i++) {
           result[i] = arr.get(i)[0];
        }

        return result;
    }

//    TODO: Method 2
}