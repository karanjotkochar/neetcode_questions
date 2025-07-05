import java.util.Arrays;
import java.util.HashMap;

public class q3_twoSum {
    public static void main(String[] args) {
        int[] nums = {3,5,4,6};
        int target = 7;
        twoSum(nums,target);
        twoSum2(nums,target);
    }
    public static void twoSum(int[] nums, int target) {
        // brute force method
        // time O(n) = n*n

        int[] ans = new int[2];

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("found");
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }
    public static int[] twoSum2(int[] nums, int target) {
        // using hashmap, time O(n) = n

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (hashMap.containsKey(diff)) {
                return new int[]{hashMap.get(diff), i};
            }
            hashMap.put(num, i);
        }


        return new int[] {};
    }

}
