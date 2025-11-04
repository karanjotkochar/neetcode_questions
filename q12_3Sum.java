import java.util.*;

public class q12_3Sum {
    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        threeSum(nums);
        System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        // brute force
        // time = O(n*n*n) and space = O(m)
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums); // helps in finding duplicate ** IMPORTANT

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j< nums.length; j++) {
                for (int k=j+1; k< nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0){

                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(tempList);
                    }

                }
            }
        }
        return new ArrayList<>(result);
    }
    public static List<List<Integer>> threeSum2(int[] nums) {
        // two pointer approach
        // time = O(n*n) and space = O(1) or O(m)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i < nums.length; i++) {
            if (nums[i] > 0)                        // to make sure sum will come zero
                break;
            if (i>0 && nums[i] == nums[i-1])        // to make sure to avoid duplicates
                continue;

            int left = i+1;                         // 2 Sum
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    left++;

                else if (sum > 0)
                    right--;

                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {      // to make sure to avoid duplicates in 2 sum
                        left++;
                    }

                }
            }
        }
        return result;
    }
}
