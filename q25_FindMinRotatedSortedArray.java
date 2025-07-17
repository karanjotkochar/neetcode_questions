import java.util.Arrays;

public class q25_FindMinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        // findMin(nums);
        System.out.println(findMin(nums));
        System.out.println(findMin2(nums));
        System.out.println(findMin3(nums));
    }
    public static int findMin(int[] nums) {
        // brute force
        // time = o(n) and space = o(1)
        int min = nums[0];
        for (int i=0; i< nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }

        return min;
    }

    public static int findMin2(int[] nums) {
        // brute force
        // time = o(n) and space = o(1)
        return Arrays.stream(nums).min().getAsInt();
    }

    public static int findMin3(int[] nums) {
        // binary search
        // time = o(logn) and space = o(1)
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];

        while (left <= right) {
            if (nums[left] <  nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1; // right sorted portion
            } else {
                right = mid - 1; // left sorted portion
            }
        }

        return result;
    }

}
